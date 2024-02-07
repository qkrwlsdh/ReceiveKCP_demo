package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class NotificationData {
    private String site_cd;
    private String card_cd;
    private String card_no;
    private String acqu_cd;
    private String app_time;
    private String tno;
    private double amount;
    private String tx_cd;
    private String res_cd;
    private String res_msg;
    private String quota;
    private String noinf;
    private String ordr_idxx;
    private long tx_tm;
    private String buyr_mail;
    private String buyr_name;
    private String pay_type;
    private String can_time;
    private String can_type;
    private String card_name;
    private String acqu_name;
    private long app_no;
    private String bizx_numb;
    private long card_mny;
    private long coupon_mny;
    private String card_other_pay_type;
    private String shop_user_id;
    private String media_type;
    private String char_set;
    private int noti_cnt;

}
