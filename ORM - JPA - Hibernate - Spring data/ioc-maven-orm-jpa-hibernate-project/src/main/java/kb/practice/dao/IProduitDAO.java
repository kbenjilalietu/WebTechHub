package kb.practice.dao;

import java.util.List;

public interface IProduitDAO {
    void save(Produit p);
    List<Produit> findAll();
    List<Produit> findByDesignation(String mc);
    Produit findByID(Long id);
    void update(Produit p);
    void deleteById(Long idP);

}
