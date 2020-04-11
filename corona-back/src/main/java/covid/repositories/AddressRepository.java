package covid.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import covid.models.Address;

@Repository
public interface AddressRepository extends MongoRepository<Address, Long> {

	Optional<Address> getById(String id);
}
