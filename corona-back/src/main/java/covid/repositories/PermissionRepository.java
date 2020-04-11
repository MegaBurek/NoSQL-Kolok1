package covid.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import covid.models.Permission;

@Repository
public interface PermissionRepository extends MongoRepository<Permission, String> {

	Optional<Permission> getByAuthority(String authority);
}
