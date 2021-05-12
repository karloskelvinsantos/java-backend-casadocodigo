package br.com.karloskelvin.models;

import br.com.karloskelvin.models.dtos.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Entity(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private Float preco;
    private String descricao;
    private String productIdentifier;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public static Product convert(ProductDTO productDTO) {
        return new ModelMapper().map(productDTO, Product.class);
    }
}
