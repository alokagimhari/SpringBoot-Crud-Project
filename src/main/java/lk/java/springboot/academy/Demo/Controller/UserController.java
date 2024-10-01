package lk.java.springboot.academy.Demo.Controller;

import lk.java.springboot.academy.Demo.DTO.ResponseDTO;
import lk.java.springboot.academy.Demo.DTO.UserDTO;
import lk.java.springboot.academy.Demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/user")
@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> saveUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }



    @GetMapping("/get")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/find/by/{id}")
    public ResponseDTO findUser(@PathVariable int id)
    {
        return userService.findUser(id);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam int id)
    {
        userService.deleteUser(id);
    }
}
