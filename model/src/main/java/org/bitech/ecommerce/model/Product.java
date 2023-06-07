package org.bitech.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    private int id;
    private String name;
    private String reference;
    private String category;
    private int cant;
    private String photo;
    @OneToMany(mappedBy = "product")
    private List<ShCartDetail> cartDetails;
    @ManyToOne
    private Admin admin;

    public Product(int id, String name, String reference, String category, int cant, String photo) {
        this.id = id;
        this.name = name;
        this.reference = reference;
        this.category = category;
        this.cant = cant;
        this.photo = photo;
    }
}
