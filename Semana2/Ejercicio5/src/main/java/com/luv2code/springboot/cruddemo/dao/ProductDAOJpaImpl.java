package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOJpaImpl implements ProductDAO {

    // define field for entitymanager
    private EntityManager entityManager;


    // set up constructor injection
    @Autowired
    public ProductDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override
    public List<Producto> findAll() {

        // create a query
        TypedQuery<Producto> theQuery = entityManager.createQuery("from Producto", Producto.class);
        //Entity Connection: org.hibernate.query.sqm.UnknownEntityException: Could not resolve root entity 'Employee'

        // execute query and get result list
        List<Producto> products = theQuery.getResultList();

        // return the results
        return products;
    }

    @Override
    public Producto findById(int theId) {

        // get employee
        Producto theProduct = entityManager.find(Producto.class, theId);

        // return employee
        return theProduct;
    }

    @Override
    public Producto save(Producto elProducto) {

        // save employee
        Producto dbProduct = entityManager.merge(elProducto);

        // return the dbEmployee
        return dbProduct;
    }

    @Override
    public void deleteById(int theId) {

        // find employee by id
        Producto theProduct = entityManager.find(Producto.class, theId);

        // remove employee
        entityManager.remove(theProduct);
    }
}











