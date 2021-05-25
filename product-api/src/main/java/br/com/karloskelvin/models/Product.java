package br.com.karloskelvin.models;

import br.com.karloskelvin.dtos.ProductDTO;
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
    private String identificador;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categoria;

    public static Product convert(ProductDTO productDTO) {
        return new ModelMapper().map(productDTO, Product.class);
    }
}
