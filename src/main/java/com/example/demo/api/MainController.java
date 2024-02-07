package com.example.demo.api;

import com.example.demo.config.CardNumberMasking;
import com.example.demo.config.GenerateRandomString;
import com.example.demo.dto.NotificationData;
import com.example.demo.entity.TransEntity;
import com.example.demo.service.MainService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/notify", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    private final MainService mainService;
    @PostMapping("/kcp")
    public Map<String, String> handleNotification(NotificationData notiData) {
        try {
            // 카드 번호 마스킹
            String cardNo = CardNumberMasking.maskCardNumber(notiData.getCard_no());

            // 상위PG MID가 원장에 존재하는지 확인
            if (!mainService.isExistsByPoMid(notiData.getSite_cd())) {
                return errorResponse("존재하지 않는 MID", "존재하지 않는 상위PG MID입니다.");
            }
            // 발급사 및 매입사 정보 수신 되었는지 확인 (보류)
            /*if (StringUtils.isEmpty(CARD_CD) && StringUtils.isEmpty(ACQU_CD)) {
                return errorResponse("Missing data", "발급사 또는 매입사 정보가 누락되었습니다.");
            }*/
            // 거래번호 생성
            String newTno = String.valueOf(notiData.getApp_time()).substring(0, 8).concat(GenerateRandomString.generateRandomString(5));
            logger.info("newTno: {}", newTno);

            // 업무 통보코드가 승인인지 취소인지 체크
            String transType = null;
            if (notiData.getTx_cd().equals("NC01")) {
                transType = "1";
                // 중복거래 체크 (1안 : 상위PG 거래번호 tno 로 체크 / 2안 : 상위PG사 site_cd, 카드BIN card_no, 거래시간 app_time, 금액 amount 으로 체크)
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
                if (mainService.isExistsTno(notiData.getTno()) || mainService.isExistsDuplTran(notiData.getSite_cd(), cardNo, LocalDateTime.parse(notiData.getApp_time(), formatter), notiData.getAmount())) {
                    return errorResponse("중복거래", "중복거래가 확인되었습니다.");
                }
            } else if (notiData.getTx_cd().equals("NC02")) {
                transType = "2";
            }

            int poIdx = mainService.findByPoIdx(notiData.getSite_cd()).getPoIdx();
            TransEntity transEntity = mainService.createTransEntity(notiData, cardNo, transType, poIdx, newTno);
            mainService.saveTransaction(transEntity);

            return successResponse();

        } catch (Exception e) {
            logger.error("Error notification: {}", e.getMessage());
            return errorResponse("Error", "에러 발생으로 프로세스가 중단 되었습니다.");
        }
    }

    private Map<String, String> successResponse() {
        Map<String, String> response = new HashMap<>();
        response.put("res_msg", "Success");
        response.put("msg", "거래가 성공적으로 처리되었습니다.");
        return response;
    }

    private Map<String, String> errorResponse(String resMsg, String msg) {
        Map<String, String> response = new HashMap<>();
        response.put("res_msg", resMsg);
        response.put("msg", msg);
        return response;
    }
}
