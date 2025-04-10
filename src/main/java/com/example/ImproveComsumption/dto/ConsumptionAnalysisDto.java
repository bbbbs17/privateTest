package com.example.ImproveComsumption.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ConsumptionAnalysisDto {
    private LocalDateTime dateTime;
    private String item;
    private String place;
    private int amount;
    private boolean habitual; // 습관 소비 여부
}
