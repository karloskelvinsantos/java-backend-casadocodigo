package br.com.karloskelvin.models.dtos;

import br.com.karloskelvin.models.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    @NotBlank
    @JsonProperty("identificador")
    private String productIdentifier;
    @NotBlank
    private String nome;
    @NotNull
    private Float preco;
    @NotBlank
    private String descricao;
    @NotNull
    @JsonProperty("categoria")
    private CategoryDTO category;

    public static ProductDTO convert(Product product) {
        return new ModelMapper().map(product, ProductDTO.class);
    }
}
