package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Producto;
import com.luv2code.springboot.cruddemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductRestController {

    private ProductService productoService;

    @Autowired
    public ProductRestController(ProductService theProductService) {
    	productoService = theProductService;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/productos")
    public List<Producto> findAll() {
        return productoService.findAll();
    }

    // add mapping for GET /employees/{employeeId}

    @GetMapping("/productos/{productoId}")
    public Producto getEmployee(@PathVariable int productoId) {

        Producto theProducto = productoService.findById(productoId);

        if (theProducto == null) {
            throw new RuntimeException("Product id not found - " + productoId);
        }

        return theProducto;
    }

    // add mapping for POST /employees - add new employee

    @PostMapping("/productos")
    public Producto addProducto(@RequestBody Producto theProducto) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

    	theProducto.setId(0);

        Producto dbProduct = productoService.save(theProducto);

        return dbProduct;
    }

    // add mapping for PUT /employees - update existing employee

    @PutMapping("/productos")
    public Producto updateEmployee(@RequestBody Producto elProducto) {

        Producto dbProduct = productoService.save(elProducto);

        return dbProduct;
    }

    // add mapping for DELETE /employees/{employeeId} - delete employee

    @DeleteMapping("/productos/{productoId}")
    public String deleteProducto(@PathVariable int productoId) {

        Producto findProducto = productoService.findById(productoId);

        // throw exception if null

        if (findProducto == null) {
            throw new RuntimeException("Product id not found - " + productoId);
        }

        productoService.deleteById(productoId);

        return "Deleted product id - " + productoId;
    }

}














