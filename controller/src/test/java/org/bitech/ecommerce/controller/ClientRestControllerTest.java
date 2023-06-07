package org.bitech.ecommerce.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.bitech.ecommerce.ControllerApplication;
import org.bitech.ecommerce.config.Constants;
import org.bitech.ecommerce.dto.ProductDto;
import org.bitech.ecommerce.model.Client;
import org.bitech.ecommerce.model.Product;
import org.bitech.ecommerce.model.ShCartDetail;
import org.bitech.ecommerce.model.ShoppingCart;
import org.bitech.ecommerce.repository.ClientRepository;
import org.bitech.ecommerce.repository.ProductRepository;
import org.bitech.ecommerce.repository.ShCartDetailRepository;
import org.bitech.ecommerce.repository.ShoppingCartRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Map;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = ControllerApplication.class)
@AutoConfigureMockMvc
class ClientRestControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProductRepository productRepository;
    @MockBean
    private ClientRepository clientRepository;
    @MockBean
    private ShoppingCartRepository shoppingCartRepository;
    @MockBean
    private ShCartDetailRepository cartDetailRepository;
    @Test
    void getProducts() {

    }

    @Test
    void addToCart() throws Exception{
//        // Preparar los datos de entrada para la petición
//        ProductDto productDto = new ProductDto(
//                1,
//                "Product Name",
//                "Product Reference",
//                "Product Category",
//                10,
//                "product_photo.jpg"
//        );
//        int cant = 5;
//        int idClient = 1;
//        Integer idCart = null; // Opcional, depende de tu caso de uso
//
//        // Simular la llamada al método findClientById() en el ClientRepository
//        Client client = new Client(); // Crear un objeto Client de muestra
//        when(clientRepository.findClientById(idClient)).thenReturn(client);
//
//        // Simular la llamada al método findProductById() en el ProductRepository
//        Product product = new Product(); // Crear un objeto Product de muestra
//        when(productRepository.findProductById(productDto.getId())).thenReturn(product);
//
//        // Simular la llamada al método findShoppingCartByIdAndIdClient() en el ShoppingCartRepository
//        ShoppingCart shoppingCart = null; // Opcional, depende de tu caso de uso
//        if (idCart != null) {
//            shoppingCart = new ShoppingCart(); // Crear un objeto ShoppingCart de muestra
//            when(shoppingCartRepository.findShoppingCartByIdAndIdClient(idCart, idClient)).thenReturn(shoppingCart);
//        }
//
//        // Realizar la petición POST al endpoint "/client" y verificar la respuesta
//        MvcResult mvcResult =mockMvc.perform(post("/client")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .param("cant", String.valueOf(cant))
//                        .param("idClient", String.valueOf(idClient))
//                        .param("idCart", String.valueOf(idCart))
//                        .content(asJsonString(productDto)))
//                .andExpect(status().isOk())
//                .andReturn();
//
//
//        // Verificar que se haya llamado al método findClientById() en el ClientRepository
//        verify(clientRepository).findClientById(idClient);
//
//        // Verificar que se haya llamado al método findProductById() en el ProductRepository
//        verify(productRepository).findProductById(productDto.getId());
//
//        // Verificar que se haya llamado al método findShoppingCartByIdAndIdClient() en el ShoppingCartRepository (si aplica)
//        if (idCart != null) {
//            verify(shoppingCartRepository).findShoppingCartByIdAndIdClient(idCart, idClient);
//        }
//
//        // Verificar que se haya llamado al método save() en el cartDetailRepository
//        verify(cartDetailRepository).save(any(ShCartDetail.class));
//
//        // Verificar que se haya llamado al método save() en el productRepository
//        verify(productRepository).save(product);
//        String responseJson = mvcResult.getResponse().getContentAsString();
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        Map<String, String> responseMap = objectMapper.readValue(responseJson, new TypeReference<Map<String, String>>(){});
//        assertEquals(Constants.PRODUCT_ADD_TO_CART_MESSAGE, responseMap.get(Constants.RESPONSE_MESSAGE_KEY));
    }

    @Test
    void getProductsAddToCart() {
    }
    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}