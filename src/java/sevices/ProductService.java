package sevices;

import entities.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ProductService implements IProductService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("coffeeOnlinePU");
    EntityManager em = emf.createEntityManager();

    @Override
    public Product findById(Integer id) {
        Product p = em.find(Product.class, id);
        return p;

    }

    @Override
    public List<Product> findAllProducts() {
        List<Product> myList;
        em.getTransaction().begin();
        Query q = em.createNamedQuery("Product.findAll");
        myList = q.getResultList();
        em.getTransaction().commit();
        em.close();
        return myList;
    }

    @Override
    public void saveProduct(Product p) {
//        EntityManagerFactory emf=Persistence.createEntityManagerFactory("coffeeOnlinePU");  
//        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateProduct(Product p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteProductById(Integer id) {
       em.getTransaction().begin();
       Product pr = em.find(Product.class, id);
       em.remove(pr);
       em.getTransaction().commit();
       
    }

}
