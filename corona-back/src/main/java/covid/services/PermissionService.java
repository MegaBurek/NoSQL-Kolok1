package covid.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covid.models.Permission;
import covid.repositories.PermissionRepository;

@Service
public class PermissionService {

	@Autowired
	private PermissionRepository permissionRepository;

	
	public void addAdministratorPermission(Permission permission) {
		permission.setAuthority("ROLE_ADMINISTRATOR");
		permissionRepository.save(permission);
	}

	public void addUserPermission(Permission permission) {
		permission.setAuthority("ROLE_USER");
		permissionRepository.save(permission);
	}

}
