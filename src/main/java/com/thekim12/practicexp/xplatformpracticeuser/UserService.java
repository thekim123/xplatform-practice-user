package com.thekim12.practicexp.xplatformpracticeuser;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void joinUser(User user){
        System.out.println(user.getName());
        System.out.println("asdasdjasdjlasdjl");

        userRepository.save(user);
    }

    @Transactional
    public void updateUser(User user){
        User userEntity = userRepository.findByUsername(user.getUsername());
        userEntity.setName(user.getName());
        userEntity.setPassword(user.getPassword());
        userEntity.setEmail(user.getEmail());
    }

}
