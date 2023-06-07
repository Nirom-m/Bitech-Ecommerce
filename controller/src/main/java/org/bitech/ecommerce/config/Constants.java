package org.bitech.ecommerce.config;

public class Constants {
    private Constants() {
        throw new IllegalStateException("Utility class");
    }
    public static final String RESPONSE_MESSAGE_KEY = "message";
    public static final String PRODUCT_CREATED_MESSAGE = "product created successfully";
    public static final String PRODUCT_MODIFIED_MESSAGE = "product modified successfully";
    public static final String PRODUCT_DELETED_MESSAGE = "product deleted successfully";
    public static final String RESPONSE_ERROR_MESSAGE_KEY = "error message";
    public static final String PRODUCT_NOT_FOUND_EXCEPTION_MESSAGE = "the product you want to modify has not been found";
    public static final String PRODUCTS_NOT_FOUND_EXCEPTION_MESSAGE = "not a single product found";
}
