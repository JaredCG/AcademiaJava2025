package com.academy.proyecto.bo;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("productdata")
public class ProductBean {
	private String productId;
	private String productName;
	private String productDesc;
	private String price;
}
