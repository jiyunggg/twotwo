package com.sparta.twotwo.order.dto;

import com.sparta.twotwo.enums.OrderType;
import com.sparta.twotwo.members.entity.Member;
import com.sparta.twotwo.order.entity.Order;
import com.sparta.twotwo.order.entity.OrderProduct;
import com.sparta.twotwo.product.entity.ProductEntity;
import com.sparta.twotwo.store.entity.Store;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrderRequestDto {

    private OrderType orderType;
//    private Long price;

    private List<OrderProductRequestDto> orderProductRequestDtos;
//    private Long quantity;
//    private UUID productId;

    public Order toOrderEntity(Member member, Store store) {
        return Order.builder()
                .order_type(orderType)
                .member(member)
                .store(store)
                .orderProducts(new ArrayList<>())
                .build();
    }

    public OrderProduct toOrderProductEntity(Order order, ProductEntity product){
        return OrderProduct.builder()
                .order(order)
                .product(product)
                .build();
    }

    @Override
    public String toString() {
        return "OrderRequestDto{" +
                "orderType=" + orderType +
                ", orderProductRequestDtos=" + orderProductRequestDtos +
                '}';
    }
}
