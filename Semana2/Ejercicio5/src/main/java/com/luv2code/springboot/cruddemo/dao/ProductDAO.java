package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Producto;

import java.util.List;

public interface ProductDAO {

    List<Producto> findAll();

    Producto findById(int theId);

    Producto save(Producto elProducto);

    void deleteById(int theId);
}










