package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.ProductDAO;
import com.luv2code.springboot.cruddemo.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO theProductDAO) {
    	productDAO = theProductDAO;
    }

    @Override
    public List<Producto> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Producto findById(int theId) {
        return productDAO.findById(theId);
    }

    @Transactional
    @Override
    public Producto save(Producto elProducto) {
        return productDAO.save(elProducto);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
    	productDAO.deleteById(theId);
    }
}






