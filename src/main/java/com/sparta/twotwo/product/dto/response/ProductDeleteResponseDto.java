package com.sparta.twotwo.product.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class ProductDeleteResponseDto {
    private UUID productId;
    private String deletedAt;
    private Long deletedBy;
}