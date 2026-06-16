package com.ecommerce.orderservice.dto;

import java.util.Collection;
import java.util.List;

import com.ecommerce.orderservice.model.OrderLineItems;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class OrderRequest {
    private List<OrderLineItemsDto> orderLineItemsDtoList;
}
