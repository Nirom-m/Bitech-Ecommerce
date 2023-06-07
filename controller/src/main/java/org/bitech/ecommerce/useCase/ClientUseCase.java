package org.bitech.ecommerce.useCase;

import lombok.RequiredArgsConstructor;
import org.bitech.ecommerce.dto.ProductDto;
import org.bitech.ecommerce.dto.ShoppingCartDto;
import org.bitech.ecommerce.model.Client;
import org.bitech.ecommerce.model.Product;
import org.bitech.ecommerce.model.ShCartDetail;
import org.bitech.ecommerce.model.ShoppingCart;
import org.bitech.ecommerce.repository.ClientRepository;
import org.bitech.ecommerce.repository.ProductRepository;
import org.bitech.ecommerce.repository.ShCartDetailRepository;
import org.bitech.ecommerce.repository.ShoppingCartRepository;
import org.bitech.ecommerce.service.AdminService;
import org.bitech.ecommerce.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientUseCase {

    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;
    private final ShoppingCartRepository shoppingCartRepository;
    private final ShCartDetailRepository cartDetailRepository;

    public List<Product> getProducts(){
        List<Product> products= productRepository.findAll();
        AdminService.verifyProductsFound(products);
        return products;
    }

    public void addToCart(ProductDto productDto, int cant, int idClient, Integer idCart){
        Client client= clientRepository.findClientById(idClient);
        Product product= productRepository.findProductById(productDto.getId());

        AdminService.verifyProductFound(product);
        ClientService.verifyClientFound(client);
        ClientService.verifyNegativeAmountProduct(product.getCant(), cant);



        ShoppingCart shoppingCart= new ShoppingCart();
        if(idCart != null){
            shoppingCart= shoppingCartRepository.findShoppingCartByIdAndIdClient(idCart, idClient);
            ClientService.verifyShoppingCartFoundWithIdAndIdClient(shoppingCart);

        }else{
            shoppingCart.setClient(client);
            shoppingCart.setDetails(new ArrayList<>());
            shoppingCart = shoppingCartRepository.save(shoppingCart);
        }

        ShCartDetail cartDetails= new ShCartDetail();
        cartDetails.setProduct(product);
        cartDetails.setCant(cant);
        cartDetails.setShoppingCart(shoppingCart);

        cartDetailRepository.save(cartDetails);

        product.setCant(product.getCant()-cant);
        productRepository.save(product);

    }

    public List<String> getProductsAddToCart(int idCart, int idClient){
        ClientService.verifyClientFound(clientRepository.findClientById(idClient));
        ClientService.verifyShoppingCartFoundWithIdAndIdClient(shoppingCartRepository.
                findShoppingCartByIdAndIdClient(idCart, idClient));
        List<String> productsAddToCart= cartDetailRepository.findAllProductosByCarritoId(idCart, idClient);
        return productsAddToCart;
    }
}
