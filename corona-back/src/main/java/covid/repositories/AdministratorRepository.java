package covid.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import covid.models.Administrator;

@Repository
public interface AdministratorRepository extends MongoRepository<Administrator, String> {

}
