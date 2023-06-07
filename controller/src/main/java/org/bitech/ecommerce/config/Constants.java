package org.bitech.ecommerce.config;

public class Constants {
    private Constants() {
        throw new IllegalStateException("Utility class");
    }
    public static final String RESPONSE_MESSAGE_KEY = "message";
    public static final String PRODUCT_ADD_TO_CART_MESSAGE = "the product was successfully added to your cart";
    public static final String PRODUCT_CREATED_MESSAGE = "product created successfully";
    public static final String PRODUCT_MODIFIED_MESSAGE = "product modified successfully";
    public static final String PRODUCT_DELETED_MESSAGE = "product deleted successfully";
    public static final String RESPONSE_ERROR_MESSAGE_KEY = "error message";
    public static final String PRODUCT_NOT_FOUND_EXCEPTION_MESSAGE = "the product has not been found";
    public static final String PRODUCTS_NOT_FOUND_EXCEPTION_MESSAGE = "not a single product found";
    public static final String CLIENT_NOT_FOUND_EXCEPTION_MESSAGE = "the client has not been found";
    public static final String NEGATIVE_AMOUNT_PRODUCT_EXCEPTION_MESSAGE = "the quantity you have ordered of the product exceeds the quantity available";
    public static final String CLIENT_NOT_HAVE_SHOPPING_CART_EXCEPTION_MESSAGE = "the user does not have this cart or it does not exist";
}
