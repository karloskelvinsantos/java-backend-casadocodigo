package br.com.karloskelvin.models.dtos;

import br.com.karloskelvin.models.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    @NotNull
    private long id;
    private String nome;

    public static CategoryDTO convert(Category category) {
        return new ModelMapper().map(category, CategoryDTO.class);
    }
}
