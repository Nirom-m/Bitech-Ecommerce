package org.bitech.ecommerce.service;

import org.bitech.ecommerce.exception.*;
import org.bitech.ecommerce.model.Client;
import org.bitech.ecommerce.model.Product;
import org.bitech.ecommerce.model.ShoppingCart;

public class ClientService {

    public static void verifyNegativeAmountProduct(int cantAmount, int cantOrdered){
        if((cantAmount-cantOrdered)<0){
            throw new NegativeAmountProductException();
        }
    }
    public static void verifyClientFound(Client client){
        if(client==null){
            throw new ClientNotFoundException();
        }
    }

    public static void verifyShoppingCartFound(ShoppingCart shoppingCart){
        if(shoppingCart==null){
            throw new ShoppingCartNotFoundException();
        }
    }
    public static void verifyShoppingCartFoundWithIdAndIdClient(ShoppingCart shoppingCart){
        if(shoppingCart==null){
            throw new ClientNotHaveShoppingCartException();
        }
    }
}
