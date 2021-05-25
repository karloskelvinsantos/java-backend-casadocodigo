package br.com.karloskelvin.shoppingapi.model.dto;

import br.com.karloskelvin.shoppingapi.model.Shop;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopDTO {

    @NotBlank
    private String userIdentifier;

    @NotNull
    private Float total;

    @NotNull
    private Date date;

    @NotNull
    private List<ItemDTO> items;

    public static ShopDTO convert(Shop shop) {
        return new ModelMapper().map(shop, ShopDTO.class);
    }
}
