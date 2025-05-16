package com.sparta.twotwo.product.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sparta.twotwo.product.entity.Product;
import lombok.Builder;
import lombok.Getter;

import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)  // null 값이면 JSON 응답에서 제외
public class ProductResponseDto {
    private UUID productId;
    private UUID storeId;
    private UUID descriptionId;
    private String description;
    private String productName;
    private int price;
    private String imageUrl;
    private String createdAt;
    private Long createdBy;
    private String updatedAt;
    private Long updatedBy;

    public static ProductResponseDto from(Product product) {
        return ProductResponseDto.builder()
                .productId(product.getId())
                .storeId(product.getStore().getId())
                .description(product.getDescription())
                .productName(product.getProductName())
                .price(product.getPrice())
                .imageUrl(product.getImageUrl())
                .createdAt(product.getCreatedAt().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .createdBy(product.getCreatedBy())
                .build();
    }
}
