package com.d288.jhayma7.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;


@Data
public class PurchaseResponse {
    @NonNull
    private String orderTrackingNumber;
}
