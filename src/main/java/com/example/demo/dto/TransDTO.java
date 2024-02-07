package com.example.demo.dto;

import com.example.demo.entity.TransEntity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransDTO {
    private String transId;
    private String merchantId;
    private LocalDateTime transDt;
    private double transAmt;
    private String transType;
    private String cardNo;
    private String installment;
    private String interestFree;
    private String poCd;
    private String poMctId;
    private String poTransId;
    private int poIdx;
    private String orgnTransId;
    private String mctTransId;
    private String mctUserId;
    private String authNo;
    private String issueComCd;
    private String acquComCd;
    private String acquMctNo;
    private String goodsNm;
    private String payerNm;
    private String payerEmail;
    private String payerTel;
    private LocalDateTime regDt;
    private String simplepayCd;

    public static TransDTO toDTO(TransEntity entity) {
        TransDTO dto = new TransDTO();
        // 엔터티의 필드들을 DTO에 복사
        dto.setTransId(entity.getTransId());
        dto.setMerchantId(entity.getMerchantId());
        dto.setTransDt(entity.getTransDt());
        dto.setTransAmt(entity.getTransAmt());
        dto.setTransType(entity.getTransType());
        dto.setCardNo(entity.getCardNo());
        dto.setInstallment(entity.getInstallment());
        dto.setInterestFree(entity.getInterestFree());
        dto.setPoCd(entity.getPoCd());
        dto.setPoMctId(entity.getPoMctId());
        dto.setPoTransId(entity.getPoTransId());
        dto.setPoIdx(entity.getPoIdx());
        dto.setOrgnTransId(entity.getOrgnTransId());
        dto.setMctTransId(entity.getMctTransId());
        dto.setMctUserId(entity.getMctUserId());
        dto.setAuthNo(entity.getAuthNo());
        dto.setIssueComCd(entity.getIssueComCd());
        dto.setAcquComCd(entity.getAcquComCd());
        dto.setAcquMctNo(entity.getAcquMctNo());
        dto.setGoodsNm(entity.getGoodsNm());
        dto.setPayerNm(entity.getPayerNm());
        dto.setPayerEmail(entity.getPayerEmail());
        dto.setPayerTel(entity.getPayerTel());
        dto.setRegDt(entity.getRegDt());
        dto.setSimplepayCd(entity.getSimplepayCd());
        return dto;
    }
}
