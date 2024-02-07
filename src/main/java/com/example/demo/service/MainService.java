package com.example.demo.service;

import com.example.demo.dto.NotificationData;
import com.example.demo.entity.PoInfoEntity;
import com.example.demo.entity.TransEntity;
import com.example.demo.repository.BinRepository;
import com.example.demo.repository.MainRepository;
import com.example.demo.repository.TransRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MainService {

    private final MainRepository mainRepository;
    private final BinRepository binRepository;
    private final TransRepository transRepository;
    public boolean isExistsByPoMid(String siteCd) {
        return mainRepository.existsByPoMctId(siteCd);
    }

    public boolean isExistsBin(String cardNo) {
        return binRepository.existsByBinNo(cardNo);
    }

    public boolean isExistsTno(String tno) {
        return transRepository.existsByTransId(tno);
    }

    public boolean isExistsDuplTran(String siteCd, String cardNo, LocalDateTime appTime, double amount) {
        return transRepository.existsByPoMctIdAndCardNoAndTransDtAndTransAmt(siteCd, cardNo, appTime, amount);
    }

    @Transactional
    public void saveTransaction(TransEntity transEntity) {
        transRepository.save(transEntity);
    }

    public TransEntity createTransEntity(NotificationData notiData, String cardNo, String transType, int poIdx, String newTno) {
        TransEntity transEntity = new TransEntity();
        transEntity.setTransId(newTno);
        transEntity.setCardNo(cardNo);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        transEntity.setTransDt(LocalDateTime.parse(notiData.getApp_time(), formatter));
        transEntity.setTransAmt(notiData.getAmount());
        transEntity.setTransType(transType);
        transEntity.setInstallment(notiData.getQuota());
        transEntity.setInterestFree(notiData.getNoinf());
        transEntity.setPoCd("KCP");
        transEntity.setPoMctId(notiData.getSite_cd());
        transEntity.setPoIdx(poIdx);
        transEntity.setMctTransId(notiData.getOrdr_idxx());
        transEntity.setAuthNo(String.valueOf(notiData.getApp_no()));
        transEntity.setIssueComCd(notiData.getCard_cd());
        transEntity.setAcquComCd(notiData.getAcqu_cd());
        transEntity.setAcquMctNo(notiData.getBizx_numb());
        transEntity.setRegDt(LocalDateTime.now());

        return transEntity;
    }

    public PoInfoEntity findByPoIdx(String siteCd) {
        return mainRepository.findByPoMctId(siteCd);
    }
}
