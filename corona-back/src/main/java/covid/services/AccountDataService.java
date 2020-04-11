package covid.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import covid.models.AccountData;
import covid.models.AuthProvider;
import covid.repositories.AccountDataRepository;

@Service
public class AccountDataService {

	@Autowired
	private AccountDataRepository accountDataRepository;
	
	@Autowired
	private PermissionService perrmissionService;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Iterable<AccountData> getAll() {
		return accountDataRepository.findAll();
	}
	
	public Optional<AccountData> getById(String id) {
		return accountDataRepository.findById(id);
	}

	public void addAdminAccountData(AccountData accountData) {
		accountData.setPassword(passwordEncoder.encode(accountData.getPassword()));
		accountData.setAuthProvider(AuthProvider.facebook.local);
		perrmissionService.addAdministratorPermission(accountData.getPermission());
		accountDataRepository.save(accountData);
	}

	public void addUserAccountData(AccountData accountData) {
		accountData.setPassword(passwordEncoder.encode(accountData.getPassword()));
		accountData.setAuthProvider(AuthProvider.facebook.local);
		perrmissionService.addUserPermission(accountData.getPermission());
		accountDataRepository.save(accountData);
	}
	
	public void editAccountData(String id, AccountData accountData) {
		
		Optional<AccountData> a = accountDataRepository.findById(id);
		
		if(a.isPresent()) {
			accountData.setId(a.get().getId());
			accountData.setPassword(passwordEncoder.encode(accountData.getPassword()));
			
			accountDataRepository.save(accountData);
		}
	}
	
//	public void editAccountDataPassword(String id, AccountData accountData) {
//		Optional<AccountData> u = accountDataRepository.findById(id);
//
//		if(u.isPresent()) {
//			accountData.setId(u.get().getId());
//			accountData.setPhoneNumber(u.get().getPhoneNumber());
//			accountData.setSurname(u.get().getSurname());
//			accountData.setName(u.get().getName());
//			accountData.setPin(passwordEncoder.encode(accountData.getPin()));
//			accountDataRepository.save(accountData);
//		}
//	}
	
	public void deleteUser(String id) {
		Optional<AccountData> u = accountDataRepository.findById(id);
		
		if (u.isPresent()) {
			accountDataRepository.delete(u.get());
		}
		
	}

	
	
	
}
