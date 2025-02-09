package com.javatechie.spring.batch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INFO_EMPLEADOS")

public class Empleados {

    @Id
    @Column(name = "CUSTOMER_ID")
    private int id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "GENERO")
    private String genero;
    @Column(name = "NUM_CONTACT")
    private String numContacto;
    @Column(name = "PAIS")
    private String pais;
    @Column(name = "FdN")
    private String fechaNac;
    
	public Empleados(int id, String firstName, String lastName, String email, String gender, String contactNo,
			String country, String dob) {
		super();
		this.id = id;
		this.nombre = firstName;
		this.apellido = lastName;
		this.email = email;
		this.genero = gender;
		this.numContacto = contactNo;
		this.pais = country;
		this.fechaNac = dob;
	}

	public Empleados() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return nombre;
	}

	public void setFirstName(String firstName) {
		this.nombre = firstName;
	}

	public String getLastName() {
		return apellido;
	}

	public void setLastName(String lastName) {
		this.apellido = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return genero;
	}

	public void setGender(String gender) {
		this.genero = gender;
	}

	public String getContactNo() {
		return numContacto;
	}

	public void setContactNo(String contactNo) {
		this.numContacto = contactNo;
	}

	public String getCountry() {
		return pais;
	}

	public void setCountry(String country) {
		this.pais = country;
	}

	public String getDob() {
		return fechaNac;
	}

	public void setDob(String dob) {
		this.fechaNac = dob;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + nombre + ", lastName=" + apellido + ", email=" + email
				+ ", gender=" + genero + ", contactNo=" + numContacto + ", country=" + pais + ", dob=" + fechaNac + "]";
	}
	

}
