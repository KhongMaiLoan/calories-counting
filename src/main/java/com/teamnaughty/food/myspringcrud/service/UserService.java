package com.teamnaughty.food.myspringcrud.service;

import com.teamnaughty.food.myspringcrud.entity.Role;
import com.teamnaughty.food.myspringcrud.entity.User;
import com.teamnaughty.food.myspringcrud.repository.RoleRepository;
import com.teamnaughty.food.myspringcrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service("userService")
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }






    public List<User> findAll() {

        List<User> users = (List<User>) userRepository.findAll();

        return users;
    }

    public List<User> getAllUser() {
        return (List<User>) userRepository.findAll();
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public User findUserByIdentify(Long id){
        List<User> list = getAllUser();
        for (User u: list) {
            if (u.getId().equals(id))
                return u;
        }
        return null;
    }



    public boolean isEmailExisted(String email){
        List<User> list = getAllUser();
        for (User u: list) {
            if (u.getEmail().equals(email))
                return true;
        }
        return false;
    }

    public boolean isUser(String email, String password){
        List<User> list = getAllUser();
        for (User u: list) {
            if (u.getEmail().equals(email) && u.getPassword().equals(password) )
                return true;
        }
        return false;
    }
}