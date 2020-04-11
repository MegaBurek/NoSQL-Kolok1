package covid.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import covid.models.AccountData;

@Repository
public interface AccountDataRepository extends MongoRepository<AccountData, String> {

	Optional<AccountData> getByUsername(String username);
	Optional<AccountData> getById(String id);
}
