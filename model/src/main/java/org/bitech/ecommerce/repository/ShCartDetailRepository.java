package org.bitech.ecommerce.repository;

import org.bitech.ecommerce.model.Product;
import org.bitech.ecommerce.model.ShCartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShCartDetailRepository extends JpaRepository<ShCartDetail, String> {
//    @Query("SELECT p FROM Product p JOIN ShCartDetail dc JOIN ShoppingCart sc WHERE dc.shoppingCart.id = :idcart")
    @Query("select p.name from Product p JOIN p.cartDetails cd JOIN cd.shoppingCart sc JOIN sc.client c WHERE c.id= :idClient and sc.id= :idCart")
    List<String> findAllProductosByCarritoId(int idCart, int idClient);
}
