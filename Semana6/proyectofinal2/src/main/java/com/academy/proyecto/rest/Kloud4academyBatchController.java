package com.academy.proyecto.rest;

import com.academy.proyecto.bo.ProductBean;
import com.mongodb.bulk.BulkWriteResult;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Kloud4academyBatchController {

    @Value("${file.input}")
    private String fileInput;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/mongodbbulkupdate")
    public String directHomePage() {
        try {
            commitBulkUpdateToMongoDB();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Mongodb Bulk Update Processed";
    }

    private void commitBulkUpdateToMongoDB() {
        try {
        	BufferedReader reader = new BufferedReader(new FileReader(fileInput));
        	CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
        	CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(parser).withSkipLines(1).build();

            List<String[]> allData = csvReader.readAll();
            int count = 0;
            ProductBean productData = null;
            List<ProductBean> productInfoList = new ArrayList<>();

            for (String[] productRow : allData) {
                String[] productStringArry = new String[productRow.length];
                productData = new ProductBean();
                count = 0;
                for (String productInfo : productRow) {
                    productStringArry[count] = productInfo;
                    count++;
                }
                productData.setProductId(productStringArry[0]);
                productData.setProductName(productStringArry[1]);
                productData.setProductDesc(productStringArry[2]);
                productData.setPrice(productStringArry[3]);
                productInfoList.add(productData);
            }

            BulkOperations bulkOps = 
            		mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, ProductBean.class);
            productInfoList.stream().filter(product -> product != null).forEach(product -> {
                org.bson.Document dbDoc = new org.bson.Document().append("$set", product);
                mongoTemplate.getConverter().write(product, dbDoc);
                Query query = new Query().addCriteria(new Criteria("uuid").is(product.getProductId()));
                Update update = Update.fromDocument(dbDoc, "");
                bulkOps.upsert(query, update);
            });

            BulkWriteResult result = bulkOps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
