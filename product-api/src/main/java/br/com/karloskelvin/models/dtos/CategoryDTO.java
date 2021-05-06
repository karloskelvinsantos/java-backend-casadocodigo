package br.com.karloskelvin.models.dtos;

import br.com.karloskelvin.models.Category;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotNull;

public class CategoryDTO {

    @NotNull
    private long id;
    private String nome;

    public static CategoryDTO convert(Category category) {
        return new ModelMapper().map(category, CategoryDTO.class);
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
}
