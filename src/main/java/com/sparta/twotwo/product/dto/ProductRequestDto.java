package com.sparta.twotwo.product.dto;

import com.sparta.twotwo.product.entity.Product;
import com.sparta.twotwo.store.entity.Store;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductRequestDto {
    @NotNull
    private UUID storeId;

    private String description;

    @NotBlank
    private String productName;

    @Min(0)
    private int price;

    private String imageUrl;

    public Product toEntity(Store store, Long createdBy) {
        return new Product(
                store,
                productName,
                price,
                imageUrl,
                createdBy
        );
    }
}