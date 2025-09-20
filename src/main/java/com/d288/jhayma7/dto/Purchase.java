package com.d288.jhayma7.dto;

import com.d288.jhayma7.entities.Cart;
import com.d288.jhayma7.entities.CartItem;
import com.d288.jhayma7.entities.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Purchase {
    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;
}
