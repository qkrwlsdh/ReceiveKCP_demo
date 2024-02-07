package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TCODE_BIN")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data // @Getter @Setter
@ToString
public class BinEntity {
    @Id
    @Column(length = 20, nullable = false)
    private String binNo;

    @Column(length = 10, nullable = false)
    private String issuerCardCd;

    @Column(length = 10, nullable = false)
    private String acquCardCd;

    @Column(length = 100, nullable = false)
    private String issuerCardNm;

    @Column(length = 200, nullable = false)
    private String cardNickNm;

    @Column(length = 20, nullable = false)
    private String cardType;

    @Column(nullable = false)
    private LocalDateTime regDt;
}
