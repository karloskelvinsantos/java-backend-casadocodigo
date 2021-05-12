package br.com.karloskelvin.shoppingapi.service;

import br.com.karloskelvin.shoppingapi.model.Shop;
import br.com.karloskelvin.shoppingapi.model.dto.ShopDTO;
import br.com.karloskelvin.shoppingapi.model.dto.ShopReportDTO;
import br.com.karloskelvin.shoppingapi.repository.ReportRepository;
import br.com.karloskelvin.shoppingapi.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {

    private final ShopRepository repository;

    public ReportService(ShopRepository repository) {
        this.repository = repository;
    }

    public List<ShopDTO> getShopsByFilter(Date dataInicio, Date dataFim, Float valorMinimo) {
        List<Shop> shops = repository.getShopsByFilters(dataInicio, dataFim, valorMinimo);

        return shops.stream().map(ShopDTO::convert).collect(Collectors.toList());
    }

    public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim) {
        return repository.getReportByDate(dataInicio, dataFim);
    }
}
