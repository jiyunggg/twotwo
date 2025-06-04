package com.sparta.twotwo.product.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class ProductUpdateResponseDto {
    private UUID productId;
    private String updatedAt;
    private Long updatedBy;
}