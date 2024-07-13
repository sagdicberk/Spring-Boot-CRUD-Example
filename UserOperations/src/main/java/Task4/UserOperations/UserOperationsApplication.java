package Task4.UserOperations;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserOperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserOperationsApplication.class, args);
	}
	
	@Bean // IoC'ye bu nesneyi eklemek için bu motasyon kullanılır.
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
