package com.ecommerce.orderservice.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.orderservice.service.OrderService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.ecommerce.orderservice.dto.OrderRequest;

@RestController
@RequestMapping("/api/order")
@Slf4j
@RequiredArgsConstructor

public class OrderController {
   
    private final OrderService orderService;
    
    @PostMapping
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackPlaceOrder")
    @TimeLimiter(name = "inventory")
    @Retry(name = "inventory")
    public CompletableFuture<ResponseEntity<String>> placeOrder(@RequestBody OrderRequest orderRequest){
        orderService.placeOrder(orderRequest);
        return CompletableFuture.supplyAsync(() -> ResponseEntity.ok("Order Placed Successfully"));
    }

    public CompletableFuture<ResponseEntity<String>> fallbackPlaceOrder(OrderRequest orderRequest, Throwable throwable) {
        log.error("Failed to place order: {}", throwable.getMessage());
        return CompletableFuture.supplyAsync(() -> ResponseEntity.status(503).body("Service is currently unavailable. Please try again later.")) ;
    }
}
