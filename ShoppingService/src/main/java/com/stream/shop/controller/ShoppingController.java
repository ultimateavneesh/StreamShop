package com.stream.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stream.shop.dto.AllOrdersDto;
import com.stream.shop.dto.CustomerCartDto;
import com.stream.shop.dto.ProductInventoryDto;
import com.stream.shop.entity.Cart;
import com.stream.shop.entity.Customer;
import com.stream.shop.entity.CustomerCart;
import com.stream.shop.entity.CustomerOrder;
import com.stream.shop.entity.Inventory;
import com.stream.shop.entity.LineItem;
import com.stream.shop.entity.OrderEntity;
import com.stream.shop.entity.Product;
import com.stream.shop.intefaces.CartRepository;
import com.stream.shop.intefaces.CustomerRepository;
import com.stream.shop.intefaces.InventoryRepository;
import com.stream.shop.intefaces.OrderRepository;
import com.stream.shop.intefaces.ProductRepository;
import com.stream.shop.repository.CustomerCartRepository;
import com.stream.shop.repository.CustomerOrderRepository;

@RestController
@RequestMapping("/shop")
public class ShoppingController {

	@Autowired
	ProductRepository feignProductRepository;

	@Autowired
	CustomerRepository feignCustomerRepository;

	@Autowired
	CartRepository fiegnCartRepository;

	@Autowired
	InventoryRepository feignInventoryRepository;

	@Autowired
	OrderRepository feignOrderRepository;

	@Autowired
	CustomerCartRepository customerCartRepository;

	@Autowired
	CustomerOrderRepository customerOrderRepository;

	@PostMapping("/products")
	public ResponseEntity<ProductInventoryDto> createProductInventory(
			@RequestBody ProductInventoryDto productInventoryDto) {

		Product product = new Product();
		product.setProductname(productInventoryDto.getProductname());
		product.setProdcutDescription(productInventoryDto.getProductDescription());
		product.setProductPrice(productInventoryDto.getProductPrice());
		int productId = feignProductRepository.addProduct(product).getProductId();

		Inventory inventory = new Inventory();
		inventory.setProductId(productId);
		inventory.setQuantity(productInventoryDto.getQuantity());
		feignInventoryRepository.addInventory(inventory);

		return ResponseEntity.status(HttpStatus.CREATED).body(productInventoryDto);
	}

	@PostMapping("/customer")
	public ResponseEntity<CustomerCart> createCustomerCart(@RequestBody CustomerCartDto customerCartDto) {
		CustomerCart customerCart = new CustomerCart();
		Customer customer = new Customer();
		customer.setCustomerName(customerCartDto.getCustomerName());
		customer.setCustomerEmail(customerCartDto.getCustomerEmail());
		customer.setBillingAddress(customerCartDto.getBillingAddress());
		customer.setShippingAddress(customerCartDto.getShippingAddress());
		customerCart.setCustomerId(feignCustomerRepository.addCustomer(customer).getCustomerId());

		Cart cart = new Cart();
		customerCart.setCartId(fiegnCartRepository.addCart(cart).getCartId());

		return ResponseEntity.status(HttpStatus.CREATED).body(customerCartRepository.save(customerCart));
	}

	@GetMapping("/products/getProducts")
	public List<Product> getAllProducts() {
		return feignProductRepository.getAllProducts();
	}

	@PutMapping("/customer/{customerId}/cart")
	public ResponseEntity<Cart> addToCart(@RequestBody Cart cart, @PathVariable int customerId) {
		int cartNo = customerCartRepository.findById(customerId).get().getCartId();
		List<LineItem> list = new ArrayList<LineItem>();

		List<LineItem> lineList = cart.getLineItem();
		for (LineItem lineItem : lineList) {
			list.add(lineItem);
		}

		cart.setCartId(cartNo);
		cart.setLineItem(list);

		return ResponseEntity.status(HttpStatus.OK).body(fiegnCartRepository.updateCart(cart));
	}

	@PostMapping("/customer/{customerId}/order")
	public ResponseEntity<OrderEntity> order(@PathVariable int customerId) {
		int cartNo = customerCartRepository.findById(customerId).get().getCartId();
		Cart cart = fiegnCartRepository.searchCart(cartNo).get();

		OrderEntity order = new OrderEntity();
		order.setLineItem(cart.getLineItem());

		OrderEntity orderResponse = feignOrderRepository.addCart(order);

		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setCustomerId(customerId);
		customerOrder.setOrderId(orderResponse.getOrderId());
		customerOrderRepository.save(customerOrder);

		List<LineItem> listLineItems = cart.getLineItem();
		for (LineItem lineItem : listLineItems) {
			Inventory inventory = feignInventoryRepository.searchInventory(lineItem.getProductId()).get();
			inventory.setQuantity(inventory.getQuantity() - lineItem.getQuantity());
			feignInventoryRepository.updateInventory(inventory);
		}
		cart.getLineItem().clear();
		fiegnCartRepository.updateCart(cart);

		return ResponseEntity.status(HttpStatus.CREATED).body(orderResponse);
	}

	@GetMapping("/customer/{customerId}/orders")
	public ResponseEntity<AllOrdersDto> getAll(@PathVariable int customerId) {
		List<OrderEntity> orderEntities = new ArrayList<>();
		List<CustomerOrder> order = customerOrderRepository.findAllOrders(customerId);
		for (CustomerOrder customerOrder : order) {
			orderEntities.add(feignOrderRepository.searchCart(customerOrder.getOrderId()).get());
		}
		AllOrdersDto allOrdersDto = new AllOrdersDto();
		allOrdersDto.setCustomer(feignCustomerRepository.searchCustomer(customerId));
		allOrdersDto.setOrderEntitie(orderEntities);

		return ResponseEntity.status(HttpStatus.FOUND).body(allOrdersDto);
	}
}
