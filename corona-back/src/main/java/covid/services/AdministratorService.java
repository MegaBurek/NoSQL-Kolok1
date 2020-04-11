package covid.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import covid.models.AccountData;
import covid.models.Administrator;
import covid.models.AuthProvider;
import covid.repositories.AccountDataRepository;
import covid.repositories.AdministratorRepository;

@Service
public class AdministratorService {

	@Autowired
	private AdministratorRepository administratorRepository;
	
	@Autowired
	private AccountDataService accountDataService;
	
	@Autowired
	private AccountDataRepository accountDataRepository;
	
	@Autowired
	private PermissionService perrmissionService;
	
	public Iterable<Administrator> getAll() {
		return administratorRepository.findAll();
	}
	
	public Optional<Administrator> getById(String id){
		return administratorRepository.findById(id);
	}
	
	public HttpStatus addAdministrator(Administrator administrator) {
		
		Optional<AccountData> accountData = accountDataRepository.getByUsername(administrator.getAccountData().getUsername());
		
		if(accountData.isPresent()) {
			return HttpStatus.IM_USED;
		} else {
			accountDataService.addAdminAccountData(administrator.getAccountData());
			administrator.getAccountData().setAuthProvider(AuthProvider.local);
			administratorRepository.save(administrator);
			
			return HttpStatus.CREATED;
		}
		
	}
	
public void editAdministrator(String id, Administrator administrator) {
		
		Optional<Administrator> a = administratorRepository.findById(id);
		
		if(a.isPresent()) {
			administrator.setId(a.get().getId());
			accountDataService.editAccountData(a.get().getAccountData().getId(), a.get().getAccountData());
			
			administratorRepository.save(administrator);
		}
	}
	
	public void deleteAdministrator(String id) {
		Optional<Administrator> a = administratorRepository.findById(id);
		
		if (a.isPresent()) {
			accountDataService.deleteUser(a.get().getAccountData().getId());
			administratorRepository.delete(a.get());
		}
		
	}

}
