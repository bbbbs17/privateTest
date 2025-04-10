package com.example.ImproveComsumption.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ConsumptionUpdateDto {
    private Long id;                // 수정할 항목의 고유 ID
    private String item;
    private String place;
    private int amount;
    private LocalDateTime localDateTime;
}
