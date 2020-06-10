package javafx.invoicesys.service;

import javafx.invoicesys.entity.Customer;
import javafx.invoicesys.entity.User;
import javafx.invoicesys.repository.CustomersRepository;
import javafx.invoicesys.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
}

