package org.bitech.ecommerce.controller;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.bitech.ecommerce.ControllerApplication;
import org.bitech.ecommerce.config.Constants;
import org.bitech.ecommerce.dto.ProductDto;
import org.bitech.ecommerce.model.Product;
import org.bitech.ecommerce.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = ControllerApplication.class)
@AutoConfigureMockMvc
class AdminRestControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        when(productRepository.save(any(Product.class))).thenReturn(new Product());
        when(productRepository.findProductById(anyInt())).thenReturn(new Product());
    }

    @Test
    void createProduct() throws Exception{
        ProductDto productDto = new ProductDto(
                1,
                "Product Name",
                "Product Reference",
                "Product Category",
                10,
                "product_photo.jpg"
        );

        MvcResult mvcResult = mockMvc.perform(post("/admin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(productDto)))
                .andExpect(status().isCreated())
                .andReturn();

        String responseJson = mvcResult.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> responseMap = objectMapper.readValue(responseJson, new TypeReference<Map<String, String>>(){});
        assertEquals(Constants.PRODUCT_CREATED_MESSAGE, responseMap.get(Constants.RESPONSE_MESSAGE_KEY));
        verify(productRepository).save(any(Product.class));

    }
    @Test
    void modifyProduct() throws Exception {
        // Preparar el objeto ProductDto con los datos actualizados
        ProductDto productDto = new ProductDto(
                1,
                "Product Name",
                "Product Reference",
                "Product Category",
                30,
                "product_photo.jpg"
        );

        MvcResult mvcResult = mockMvc.perform(put("/admin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(productDto)))
                .andExpect(status().isOk())
                .andReturn();

        String responseJson = mvcResult.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> responseMap = objectMapper.readValue(responseJson, new TypeReference<Map<String, String>>(){});
        assertEquals(Constants.PRODUCT_MODIFIED_MESSAGE, responseMap.get(Constants.RESPONSE_MESSAGE_KEY));
        verify(productRepository).save(any(Product.class));
    }

    @Test
    void deleteProduct() throws Exception{
        ProductDto productDto = new ProductDto(
                1,
                "Product Name",
                "Product Reference",
                "Product Category",
                10,
                "product_photo.jpg"
        );
        MvcResult mvcResult = mockMvc.perform(delete("/admin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(productDto)))
                .andExpect(status().isOk())
                .andReturn();

        String responseJson = mvcResult.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> responseMap = objectMapper.readValue(responseJson, new TypeReference<Map<String, String>>(){});
        assertEquals(Constants.PRODUCT_DELETED_MESSAGE, responseMap.get(Constants.RESPONSE_MESSAGE_KEY));
        verify(productRepository).delete(any(Product.class));
    }

    @Test
    void getProducts() throws Exception {
        // Crear una lista de productos de muestra
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "Product 1", "Reference 1", "Category 1", 10, "photo1.jpg"));
        productList.add(new Product(2, "Product 2", "Reference 2", "Category 2", 20, "photo2.jpg"));
        productList.add(new Product(3, "Product 3", "Reference 3", "Category 3", 30, "photo3.jpg"));

        // Simular la llamada al método findAll() en el ProductRepository
        when(productRepository.findAll()).thenReturn(productList);

        // Realizar la petición GET al endpoint "/admin" y verificar la respuesta
        mockMvc.perform(get("/admin"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(productList.size()))
                .andExpect(jsonPath("$[0].id").value(productList.get(0).getId()))
                .andExpect(jsonPath("$[0].name").value(productList.get(0).getName()))
                .andExpect(jsonPath("$[0].reference").value(productList.get(0).getReference()))
                .andExpect(jsonPath("$[0].category").value(productList.get(0).getCategory()))
                .andExpect(jsonPath("$[0].cant").value(productList.get(0).getCant()))
                .andExpect(jsonPath("$[0].photo").value(productList.get(0).getPhoto()));

        // Verificar que se haya llamado al método findAll() en el ProductRepository
        verify(productRepository).findAll();
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