package lk.java.springboot.academy.Demo.Service;


import lk.java.springboot.academy.Demo.DTO.ResponseDTO;
import lk.java.springboot.academy.Demo.DTO.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    public abstract ResponseEntity<ResponseDTO> saveUser(UserDTO userDTO);

   // public ResponseDTO saveUser(UserDTO userDTO);
    public List<UserDTO> getAllUsers();

    public ResponseDTO findUser(int id);

    public void deleteUser(int id);
}

