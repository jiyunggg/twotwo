package com.sparta.twotwo.product.dto.request;

import com.sparta.twotwo.product.entity.ProductEntity;
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

    public ProductEntity toEntity(Store store, Long createdBy) {
        return new ProductEntity(
                store,
                productName,
                price,
                imageUrl,
                createdBy
        );
    }
}