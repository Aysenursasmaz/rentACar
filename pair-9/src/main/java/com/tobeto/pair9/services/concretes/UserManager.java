package com.tobeto.pair9.services.concretes;

import com.tobeto.pair9.core.utilities.exceptions.UserBusinessException;
import com.tobeto.pair9.core.utilities.results.BaseResponse;
import com.tobeto.pair9.core.utilities.results.Messages;
import com.tobeto.pair9.entities.concretes.User;
import com.tobeto.pair9.repositories.UserRepository;
import com.tobeto.pair9.services.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(Messages.userIsNotFound));
    }

    @Override
    public boolean isExistUserByUserName(String userName) {
        return userRepository.existsByUsername(userName);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(Messages.userIsNotFound));
    }

    @Override
    public User getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            return user.get();
        }
        throw new UserBusinessException(Messages.userIsNotFound);
    }

    @Override
    public BaseResponse save(User user) {
        userRepository.save(user);
        return new BaseResponse(true,Messages.userAdded);
    }
}
