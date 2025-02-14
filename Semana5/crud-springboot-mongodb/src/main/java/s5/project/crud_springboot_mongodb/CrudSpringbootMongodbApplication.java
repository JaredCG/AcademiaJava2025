package s5.project.crud_springboot_mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class CrudSpringbootMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringbootMongodbApplication.class, args);
	}

}
