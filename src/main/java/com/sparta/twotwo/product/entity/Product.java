package com.sparta.twotwo.product.entity;

import com.sparta.twotwo.ai.entity.AIRequestLog;
import com.sparta.twotwo.common.auditing.BaseEntity;
import com.sparta.twotwo.store.entity.Store;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "p_product")
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.BINARY)
    @Column(name = "id", columnDefinition = "BINARY(16)", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", columnDefinition = "BINARY(16)", nullable = false)
    private Store store;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "description_id")
    private AIRequestLog descriptionLog;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "product_name", length = 100, nullable = false)
    private String productName;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "image_url", length = 200)
    private String imageUrl;

    public Product(
            Store store,
            String productName,
            int price,
            String imageUrl,
            Long createdBy
    ) {
        this.store = store;
        this.productName = productName;
        this.price = price;
        this.imageUrl = imageUrl;
        this.createdBy = createdBy;
        this.createdAt = LocalDateTime.now();
    }
}