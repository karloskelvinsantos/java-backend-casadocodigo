package br.com.karloskelvin.shoppingapi.service;

import br.com.karloskelvin.shoppingapi.model.Shop;
import br.com.karloskelvin.shoppingapi.model.dto.ItemDTO;
import br.com.karloskelvin.shoppingapi.model.dto.ShopDTO;
import br.com.karloskelvin.shoppingapi.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShopService {

    private final ShopRepository repository;

    public ShopService(ShopRepository repository) {
        this.repository = repository;
    }

    public List<ShopDTO> getAll() {
        return repository.findAll().stream().map(ShopDTO::convert).collect(Collectors.toList());
    }

    public List<ShopDTO> getByUser(String userIdentifier) {
        List<Shop> shops = repository.findAllByUserIdentifier(userIdentifier);

        return shops.stream().map(ShopDTO::convert).collect(Collectors.toList());
    }

    public List<ShopDTO> getByDate(ShopDTO shopDTO) {
        return repository.findAllByDateGreaterThan(shopDTO.getDate())
                .stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    public ShopDTO findById(long productId) {
        Optional<Shop> shop = repository.findById(productId);

        if (shop.isPresent()) {
            return ShopDTO.convert(shop.get());
        }

        return null;
    }

    public ShopDTO save(ShopDTO shopDTO) {
        shopDTO.setTotal(shopDTO.getItems().stream().map(ItemDTO::getPrice).reduce((float) 0, Float::sum));

        Shop shop = Shop.convert(shopDTO);
        shop.setDate(new Date());

        shop = repository.save(shop);

        return ShopDTO.convert(shop);
    }
}
