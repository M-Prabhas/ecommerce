package com.ecommerce.orderservice.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class OrderPlacedEvent {
    
private String orderNumber;
}
