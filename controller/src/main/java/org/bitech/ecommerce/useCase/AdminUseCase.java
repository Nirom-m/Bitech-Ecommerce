package org.bitech.ecommerce.useCase;

import org.bitech.ecommerce.dto.ProductDto;
import org.bitech.ecommerce.model.Product;
import org.bitech.ecommerce.repository.AdminRepository;
import org.bitech.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUseCase {

    private final AdminRepository adminRepository;

    private final ProductRepository productRepository;

    public AdminUseCase(AdminRepository adminRepository, ProductRepository productRepository) {
        this.adminRepository = adminRepository;
        this.productRepository = productRepository;
    }

    public void createProduct(ProductDto productDto){

        int id= productDto.getId();
        String name= productDto.getName();
        String reference= productDto.getReference();
        String category= productDto.getCategory();
        int cant= productDto.getCant();
        String photo= productDto.getPhoto();

        Product product= new Product(id, name, reference, category, cant, photo);
        productRepository.save(product);

    }
    public void modifyProduct(ProductDto productDto){

    }
    public void deleteProduct(ProductDto productDto){

    }
    public List<Product> getProducts(){
        return null;
    }
}
