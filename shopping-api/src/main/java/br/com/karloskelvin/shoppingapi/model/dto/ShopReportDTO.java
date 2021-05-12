package br.com.karloskelvin.shoppingapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopReportDTO {

    private Integer count;
    private Double total;
    private Double mean;
}
