package org.bitech.ecommerce.service;

import org.bitech.ecommerce.exception.ProductNotFoundException;
import org.bitech.ecommerce.exception.ProductsNotFoundException;
import org.bitech.ecommerce.model.Product;

import java.util.List;

public class AdminService {

    public static void verifyProductFound(Product product){
        if(product==null){
            throw new ProductNotFoundException();
        }
    }
    public static void verifyProductsFound(List<Product> products){
        if(products.isEmpty()){
            throw new ProductsNotFoundException();
        }
    }
}
