package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TMERCHANT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data // @Getter @Setter
@ToString
public class MerchantEntity {

    @Id
    @Column(length = 20, unique = true)
    private String merchantId;

    @Column(length = 50, nullable = false)
    private String merchantNm;

    @Column(nullable = false)
    private double merchantMdr;

    @Column(nullable = false)
    private int poIdx;

    @Column(nullable = false)
    private LocalDateTime regDt;

    @ManyToOne
    @JoinColumn(name = "poIdx", insertable = false, updatable = false)  // 이 부분이 중요!
    private PoInfoEntity poInfo;
}
