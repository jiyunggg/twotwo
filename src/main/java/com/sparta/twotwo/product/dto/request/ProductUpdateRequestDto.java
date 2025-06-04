package com.sparta.twotwo.product.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductUpdateRequestDto {
    private String productName;
    private Integer price;
    private String imageUrl;
    private String description;
}