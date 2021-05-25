package br.com.karloskelvin.converters;

import br.com.karloskelvin.dtos.ProductDTO;
import br.com.karloskelvin.models.Product;
import org.modelmapper.ModelMapper;

public class DTOConverter {

    public static ProductDTO convert(Product product) {
        return new ModelMapper().map(product, ProductDTO.class);
    }
}
