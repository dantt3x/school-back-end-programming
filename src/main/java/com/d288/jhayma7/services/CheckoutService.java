package com.d288.jhayma7.services;

import com.d288.jhayma7.dto.Purchase;
import com.d288.jhayma7.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
