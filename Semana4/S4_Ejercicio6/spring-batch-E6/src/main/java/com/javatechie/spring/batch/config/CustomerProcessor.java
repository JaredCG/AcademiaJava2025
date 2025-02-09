package com.javatechie.spring.batch.config;

import com.javatechie.spring.batch.entity.Empleados;
import org.springframework.batch.item.ItemProcessor;

public class CustomerProcessor implements ItemProcessor<Empleados,Empleados> {

    @Override
    public Empleados process(Empleados customer) throws Exception {
        if(customer.getCountry().equals("Russia") && customer.getGender().equals("Genderfluid")) {
            return customer;
        }else{
            return null;
        }
    }
}
