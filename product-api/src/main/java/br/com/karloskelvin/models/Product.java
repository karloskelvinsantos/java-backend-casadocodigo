package br.com.karloskelvin.models;

import br.com.karloskelvin.models.dtos.ProductDTO;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Entity(name = "product")
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
