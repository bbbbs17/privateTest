package com.example.ImproveComsumption.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConsumptionRequestDto {
    private String email;
    private int amount;
    private String item;
    private String place;
    private LocalDateTime localDateTime;;
}
