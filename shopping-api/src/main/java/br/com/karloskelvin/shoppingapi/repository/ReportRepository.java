package br.com.karloskelvin.shoppingapi.repository;

import br.com.karloskelvin.shoppingapi.model.Shop;
import br.com.karloskelvin.shoppingapi.model.dto.ShopReportDTO;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReportRepository {

    List<Shop> getShopsByFilters(Date dataInicio, Date dataFim, Float valorMinimo);
    ShopReportDTO getReportByDate(Date dataInicio, Date dataFim);
}
