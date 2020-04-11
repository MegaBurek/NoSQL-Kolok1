package covid.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import covid.exeption.ResourceNotFoundException;
import covid.models.AccountData;
import covid.repositories.AccountDataRepository;
import covid.utils.UserPrincipal;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountDataRepository accountDataRepository;

    
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     
    	AccountData accountData = accountDataRepository.getByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found with email : " + username));
    	
    	return UserPrincipal.create(accountData);
    }
    

    @Transactional
    public UserDetails loadUserById(String id) {
    	AccountData accountData = accountDataRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    	System.out.println("id");
        return UserPrincipal.create(accountData);
   }
}