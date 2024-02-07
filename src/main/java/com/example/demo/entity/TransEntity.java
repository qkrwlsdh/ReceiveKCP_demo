package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TTRANS")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Data // @Getter @Setter
@ToString
public class TransEntity {
    @Id
    @Column(length = 20, unique = true)
    private String transId;

    @Column(length = 20)
    private String merchantId;

    @Column()
    private LocalDateTime transDt;

    @Column()
    private double transAmt;

    @Column(length = 20)
    private String transType;

    @Column(length = 50)
    private String cardNo;

    @Column(length = 10)
    private String installment;

    @Column(length = 10)
    private String interestFree;

    @Column(length = 10)
    private String poCd;

    @Column(length = 20)
    private String poMctId;

    @Column(length = 20)
    private String poTransId;

    @Column()
    private int poIdx;

    @Column(length = 20)
    private String orgnTransId;

    @Column(length = 50)
    private String mctTransId;

    @Column(length = 100)
    private String mctUserId;

    @Column(length = 20)
    private String authNo;

    @Column(length = 10)
    private String issueComCd;

    @Column(length = 10)
    private String acquComCd;

    @Column(length = 10)
    private String acquMctNo;

    @Column(length = 200)
    private String goodsNm;

    @Column(length = 100)
    private String payerNm;

    @Column(length = 100)
    private String payerEmail;

    @Column(length = 100)
    private String payerTel;

    @Column()
    private LocalDateTime regDt;

    @Column(length = 10)
    private String simplepayCd;
}
