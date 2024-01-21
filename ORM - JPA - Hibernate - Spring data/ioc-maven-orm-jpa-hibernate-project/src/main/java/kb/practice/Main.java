package kb.practice;

import kb.practice.dao.Produit;
import kb.practice.dao.ProduitDAOImpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("UP_CAT");

        ProduitDAOImpl dao = new ProduitDAOImpl();
//        dao.save(new Produit("P1", 8000, 4));
//        dao.save(new Produit("P2", 6700, 2));
//        dao.save(new Produit("P3", 5000, 1));
//        System.out.println("-----------------------------");
//        List<Produit> produits1 = dao.findAll();
//        for (Produit p:produits1)
//            System.out.println(p.getDesignation());

//        System.out.println("-----------------------------");
//        System.out.println("Consulter les produits par mot clé");
//        List<Produit> produits2 = dao.findByDesignation("P");
//        for (Produit p:produits2)
//            System.out.println(p.getDesignation());

        System.out.println("-----------------------------");
        System.out.println("Consulter un produit");
        Produit p = dao.findByID(11L);
        System.out.println(p.getDesignation());
        System.out.println(p.getPrix());

        System.out.println("-----------------------------");
        System.out.println("Modifier le prix du produit");
        p.setPrix(123);
        dao.save(p);

        System.out.println("-----------------------------");
        System.out.println("Supprimer un produit");
        dao.deleteById(11L);




    }
}