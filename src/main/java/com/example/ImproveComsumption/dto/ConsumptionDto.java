package com.example.ImproveComsumption.dto;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class ConsumptionDto {

    private Long id; // ✅ id 필드 추가
    private LocalDateTime localDateTime;
    private int amount;
    private String item;
    private String place;

}
