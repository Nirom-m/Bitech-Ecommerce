package org.bitech.ecommerce.useCase;

import org.bitech.ecommerce.dto.ProductDto;
import org.bitech.ecommerce.model.Product;
import org.bitech.ecommerce.repository.AdminRepository;
import org.bitech.ecommerce.repository.ProductRepository;
import org.bitech.ecommerce.service.AdminService;
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


        Product product= productRepository.findProductById(productDto.getId());

        AdminService.verifyProductFound(product);

        product.setName(productDto.getName());
        product.setReference(productDto.getReference());
        product.setCategory(productDto.getCategory());
        product.setCant(productDto.getCant());
        product.setPhoto(productDto.getPhoto());

        productRepository.save(product);

    }
    public void deleteProduct(ProductDto productDto){

        Product product= productRepository.findProductById(productDto.getId());

        AdminService.verifyProductFound(product);

        productRepository.delete(product);

    }
    public List<Product> getProducts(){
        List<Product> products= productRepository.findAll();
        AdminService.verifyProductsFound(products);
        return products;
    }
}
