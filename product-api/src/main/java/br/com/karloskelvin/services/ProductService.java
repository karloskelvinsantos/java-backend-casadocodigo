package br.com.karloskelvin.services;

import br.com.karloskelvin.converters.DTOConverter;
import br.com.karloskelvin.exceptions.ProductNotFoundException;
import br.com.karloskelvin.models.Product;
import br.com.karloskelvin.dtos.ProductDTO;
import br.com.karloskelvin.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(DTOConverter::convert).collect(Collectors.toList());
    }

    public List<ProductDTO> getProductsByCategoryId(Long categoriaId) {
        List<Product> products = productRepository.getProductByCategoriaId(categoriaId);
        return products.stream().map(DTOConverter::convert).collect(Collectors.toList());
    }

    public ProductDTO findByProductIdentifier(String identificador) {
        Optional<Product> product = productRepository.findByIdentificador(identificador);
        return product.map(DTOConverter::convert).orElse(null);
    }

    public ProductDTO save(ProductDTO productDTO) {
        var product = productRepository.save(Product.convert(productDTO));
        return DTOConverter.convert(product);
    }

    public ProductDTO delete(long productId) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findById(productId);

        if (product.isPresent()) {
            productRepository.delete(product.get());
        }
        return null;
    }
}
