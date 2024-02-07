package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TPO_INFO")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data // @Getter @Setter
@ToString
public class PoInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private int poIdx;

    @Column(length = 10, nullable = false)
    private String poCd;

    @Column(length = 50, nullable = false)
    private String poMctId;

    @Column(length = 200, nullable = false)
    private String poMctNm;

    @Column(nullable = false)
    private float poMdr;

    @Column(nullable = false)
    private LocalDateTime regDt;

    @OneToMany(mappedBy = "poInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MerchantEntity> merchants;
}
