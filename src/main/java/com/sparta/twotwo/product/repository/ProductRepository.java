package com.sparta.twotwo.product.repository;

import com.sparta.twotwo.product.entity.ProductEntity;
import com.sparta.twotwo.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, UUID>, ProductSearchRepository {
    List<ProductEntity> findByStoreAndIsDeletedFalse(Store store);
    Optional<ProductEntity> findByIdAndIsDeletedFalse(UUID id);
}