package kb.practice.dao;

import javax.persistence.*;
import java.util.List;

public class ProduitDAOImpl implements IProduitDAO {

    // Déclaration de l'objet EntityManager qui permet de gérer les entités
    private EntityManager entityManager;

    // Constructeur
    public ProduitDAOImpl() {
        // Création de l'objet Entity Manager Factory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("UP_CAT");

        // Creation de l'objet Entity Manager
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void save(Produit p) {

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(p);
            transaction.commit();
        }
        catch (Exception e)
        {
            transaction.rollback();
            e.printStackTrace();
        }

    }

    @Override
    public List<Produit> findAll() {
        Query query = entityManager.createQuery("select p from Produit p");
        return query.getResultList();
    }

    @Override
    public List<Produit> findByDesignation(String mc) {
        Query query = entityManager.createQuery("select p from Produit p where p.designation like :x");
        query.setParameter("x", "%"+mc+"%");
        return query.getResultList();
    }

    @Override
    public Produit findByID(Long id) {
        Produit p = entityManager.find(Produit.class, id);
        return p;
    }

    @Override
    public void update(Produit p)
    {
        entityManager.merge(p);
    }

    @Override
    public void deleteById(Long idP)
    {
        Produit p = entityManager.find(Produit.class, idP);
        entityManager.remove(p);
    }
}
