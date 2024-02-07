package com.example.demo.config;

public class CardNumberMasking {
    /**
     * 카드번호 마스킹
     * @param cardNumber
     * @return
     */
    public static String maskCardNumber(String cardNumber) {
        // 정규식을 사용하여 숫자 이외의 문자를 제거
        String val = cardNumber.replaceAll("\\s+", "").replaceAll("\\D", "");

        // 마스킹 처리
        StringBuilder maskedValue = new StringBuilder();
        for (int i = 0; i < val.length(); i++) {
            if (i >= 6 && i < 12) {
                maskedValue.append('*');
            } else {
                maskedValue.append(val.charAt(i));
            }
        }

        return maskedValue.toString();
    }
}
