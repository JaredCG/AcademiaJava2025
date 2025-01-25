package com.luv2code.springboot.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="productos")
public class Producto {//Checar EmployeeDAOJpaImpl.java linea 29

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="nombre")
    private String nombreFarmaco;

    @Column(name="gramaje")
    private int gramaje;

    @Column(name="precio")
    private String precio;


    // define constructors
    public Producto() {

    }

    public Producto(String name, int gramaje, String precio) {
        this.nombreFarmaco = name;
        this.gramaje = gramaje;
        this.precio = precio;
    }

    // define getter/setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreFarmaco() {
        return nombreFarmaco;
    }

    public void setNombreFarmaco(String name) {
        this.nombreFarmaco = name;
    }

    public int getGramaje() {
        return gramaje;
    }

    public void setGramaje(int gramaje) {
        this.gramaje = gramaje;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    // define toString
    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombreFarmaco='" + nombreFarmaco + '\'' +
                ", gramaje='" + gramaje + '\'' +
                ", precio='" + precio + '\'' +
                '}';
    }
}








