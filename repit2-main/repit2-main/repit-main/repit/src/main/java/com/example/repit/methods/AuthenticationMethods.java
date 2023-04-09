package com.example.repit.methods;

import com.example.repit.entities.Authentication;
import com.example.repit.repositories.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AuthenticationMethods {
    private final AuthenticationRepository authenticationRepository;
    @Autowired
    public AuthenticationMethods(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    @Transactional(readOnly = true)
    public List<Authentication> getAll(){
        return authenticationRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Authentication getByID(int id){
       Optional<Authentication> authentication = authenticationRepository.findById(id);
       return authentication.orElse(null);
    }
    @Transactional
    public void save(Authentication authentication){
        authenticationRepository.save(authentication);
    }

    @Transactional
    public void update(int id, Authentication NewAuthentication){
        Authentication old = getByID(id);

        old.setPassword(NewAuthentication.getPassword());
        old.setLogin(NewAuthentication.get_login());
        old.setRole(NewAuthentication.getRole());

        authenticationRepository.save(old);
    }

    @Transactional
    public void delete(int id){
        authenticationRepository.deleteById(id);
    }


}
