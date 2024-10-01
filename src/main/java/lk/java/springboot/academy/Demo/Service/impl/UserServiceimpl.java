package lk.java.springboot.academy.Demo.Service.impl;

import lk.java.springboot.academy.Demo.DTO.ResponseDTO;
import lk.java.springboot.academy.Demo.DTO.UserDTO;
import lk.java.springboot.academy.Demo.Entity.User;
import lk.java.springboot.academy.Demo.Repository.UserRepository;
import lk.java.springboot.academy.Demo.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserServiceimpl implements UserService {

    @Autowired
    private UserRepository userRepository;

   @Override
    public ResponseEntity<ResponseDTO> saveUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setAge(userDTO.getAge());
        userRepository.save(user);
        return new ResponseEntity<>(ResponseDTO.builder()
                .message("save user successfully")
                .responseCode(HttpStatus.CREATED)
                .build(), HttpStatus.CREATED);
    }


    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> userList = new ArrayList<>();

        List<User> all =userRepository.findAll();
        all.stream().forEach(data->{
            UserDTO userDTO = new UserDTO();
            userDTO.setId(data.getId());
            userDTO.setName(data.getName());
            userDTO.setAge(data.getAge());
            userList.add(userDTO);

        });
        return userList;


    }


    @Override
    public ResponseDTO findUser(int id) {
        return userRepository.findById(id)
                .map(user -> ResponseDTO.builder()
                        .data(user)
                        .message("User found")
                        .responseCode(HttpStatus.OK)
                        .build())
                .orElseGet(() -> ResponseDTO.builder()
                        .message("User not found")
                        .responseCode(HttpStatus.NOT_FOUND)
                        .build());
    }

    @Override
    public void deleteUser(int id) {
         userRepository.deleteById(id);
    }


}
