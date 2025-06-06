package com.sparta.twotwo.ai.entity;

import com.sparta.twotwo.common.auditing.AuditableEntity;
import com.sparta.twotwo.enums.AIRequestStatus;
import com.sparta.twotwo.product.entity.ProductEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "p_ai_request_log")
public class AIRequestLog extends AuditableEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    @Column(name = "request_text", columnDefinition = "TEXT", nullable = false)
    private String requestText;

    @Column(name = "response_text", columnDefinition = "TEXT")
    private String responseText;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private AIRequestStatus status;
}