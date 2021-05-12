package br.com.karloskelvin.shoppingapi.controller;

import br.com.karloskelvin.shoppingapi.model.dto.ShopDTO;
import br.com.karloskelvin.shoppingapi.model.dto.ShopReportDTO;
import br.com.karloskelvin.shoppingapi.service.ReportService;
import br.com.karloskelvin.shoppingapi.service.ShopService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
public class ShopController {

    private final ShopService service;
    private final ReportService reportService;

    public ShopController(ShopService service, ReportService reportService) {
        this.service = service;
        this.reportService = reportService;
    }

    @GetMapping("/shopping")
    public List<ShopDTO> getShops(){
        return service.getAll();
    }

    @GetMapping("/shopping/shopByUser/{userIdentifier}")
    public List<ShopDTO> getShops(@PathVariable String userIdentifier) {
        return service.getByUser(userIdentifier);
    }

    @GetMapping("/shopping/shopByDate")
    public List<ShopDTO> getShops(@RequestBody ShopDTO shopDTO) {
        return service.getByDate(shopDTO);
    }

    @GetMapping("/shopping/{id}")
    public ShopDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/shopping")
    public ShopDTO newShop(@Valid @RequestBody ShopDTO shopDTO) {
        return service.save(shopDTO);
    }

    @GetMapping("/shopping/search")
    public List<ShopDTO> getShopsByFilter(
            @RequestParam(name = "dataInicio") @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataInicio,
            @RequestParam(name = "dataFim", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataFim,
            @RequestParam(name = "valorMinimo", required = false) Float valorMinimo) {

        return reportService.getShopsByFilter(dataInicio, dataFim, valorMinimo);
    }

    @GetMapping("/shopping/report")
    public ShopReportDTO getReportByDate(
            @RequestParam(name = "dataInicio") @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataInicio,
            @RequestParam(name = "dataFim") @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataFim) {

        return reportService.getReportByDate(dataInicio, dataFim);
    }
}
