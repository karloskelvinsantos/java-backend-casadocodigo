package br.com.karloskelvin.shoppingapi.model;

import br.com.karloskelvin.shoppingapi.model.dto.ItemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private String productIdentifier;
    private Float price;

    public static Item convert(ItemDTO itemDTO) {
        return new ModelMapper().map(itemDTO, Item.class);
    }
}
