package com.sparta.twotwo.store.dto.response;

import com.sparta.twotwo.address.dto.response.AddressResponseDto;
import com.sparta.twotwo.store.entity.Store;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class StoreResponseDto {

    private final UUID id;
    private final String imageUrl;
    private final String name;
    private final Long minOrderPrice;
    private final AddressResponseDto address;
    private final BigDecimal rating;
    private final Integer reviewCount;

    public static StoreResponseDto from(Store store) {
        return new StoreResponseDto(
                store.getId(),
                store.getImageUrl(),
                store.getName(),
                store.getMinOrderPrice(),
                AddressResponseDto.from(store.getAddress()),
                store.getRating(),
                store.getReviewCount()
        );
    }


}
