package kb.practice.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PRODUITS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Produit implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REF")
    private Long reference;
    @Column(name = "DES")
    private String designation;
    private double prix;
    private int quantite;

    public Produit(String designation, double prix, int quantite) {
        this.designation = designation;
        this.prix = prix;
        this.quantite = quantite;
    }

    // Constructeur par défaut
    // Getters et Setters
}
