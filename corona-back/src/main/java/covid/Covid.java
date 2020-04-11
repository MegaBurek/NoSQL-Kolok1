package covid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import covid.config.AppProperties;

@SpringBootApplication
@EnableMongoRepositories
@EnableConfigurationProperties(AppProperties.class)
public class Covid {

	public static void main(String[] args) {
		SpringApplication.run(Covid.class, args);

	}

}
