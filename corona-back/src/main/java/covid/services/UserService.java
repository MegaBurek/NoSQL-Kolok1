package covid.services;

import covid.models.AccountData;
import covid.models.User;
import covid.models.AuthProvider;
import covid.repositories.AccountDataRepository;
import covid.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountDataService accountDataService;

    @Autowired
    private AccountDataRepository accountDataRepository;

    @Autowired
    private PermissionService perrmissionService;

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> getById(String id){
        return userRepository.findById(id);
    }

    public HttpStatus addUser(User user) {

        Optional<AccountData> accountData = accountDataRepository.getByUsername(user.getAccountData().getUsername());

        if(accountData.isPresent()) {
            return HttpStatus.IM_USED;
        } else {
            accountDataService.addUserAccountData(user.getAccountData());
            user.getAccountData().setAuthProvider(AuthProvider.local);
            userRepository.save(user);

            return HttpStatus.CREATED;
        }

    }

    public void editUser(String id, User user) {

        Optional<User> a = userRepository.findById(id);

        if(a.isPresent()) {
            user.setId(a.get().getId());
            accountDataService.editAccountData(a.get().getAccountData().getId(), a.get().getAccountData());

            userRepository.save(user);
        }
    }

    public void deleteUser(String id) {
        Optional<User> a = userRepository.findById(id);

        if (a.isPresent()) {
            accountDataService.deleteUser(a.get().getAccountData().getId());
            userRepository.delete(a.get());
        }

    }
}
