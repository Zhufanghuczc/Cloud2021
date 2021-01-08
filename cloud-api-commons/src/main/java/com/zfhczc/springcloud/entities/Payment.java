package com.zfhczc.springcloud.entities;

import lombok.*;

/**
 * 支付实体类
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private Long id;
    private String serial;
}
