package com.d288.jhayma7.services;

import com.d288.jhayma7.dao.CartRepository;
import com.d288.jhayma7.dao.CustomerRepository;
import com.d288.jhayma7.dto.Purchase;
import com.d288.jhayma7.dto.PurchaseResponse;
import com.d288.jhayma7.entities.Cart;
import com.d288.jhayma7.entities.CartItem;
import com.d288.jhayma7.entities.Customer;
import com.d288.jhayma7.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{
    private CartRepository cartRepository;

    public CheckoutServiceImpl(CartRepository cartRepository) {
        this.cartRepository  = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        Cart cart = purchase.getCart();

        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> cart.add(item));
        cartItems.forEach(item -> item.setCart(cart));
        cart.setCartItem(cartItems);



        Customer customer = purchase.getCustomer();
        customer.add(cart);
        cart.setCustomer(customer);

        cart.setStatus(StatusType.ordered);
        cartRepository.save(cart);
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
