package br.com.karloskelvin.controllers;

import br.com.karloskelvin.dtos.UserDTO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    public static List<UserDTO> usuarios = new ArrayList<>();

    @PostConstruct
    public void initiateList() {
        UserDTO userDTO = new UserDTO();
        userDTO.setNome("Karlos");
        userDTO.setCpf("12345");
        userDTO.setEndereco("Rua A");
        userDTO.setEmail("karlos@email.com");
        userDTO.setTelefone("1232-1321");
        userDTO.setDataCadastro(new Date());

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setNome("Karlos");
        userDTO2.setCpf("12345");
        userDTO2.setEndereco("Rua A");
        userDTO2.setEmail("karlos@email.com");
        userDTO2.setTelefone("1232-1321");
        userDTO2.setDataCadastro(new Date());

        UserDTO userDTO3 = new UserDTO();
        userDTO3.setNome("Karlos");
        userDTO3.setCpf("12345");
        userDTO3.setEndereco("Rua A");
        userDTO3.setEmail("karlos@email.com");
        userDTO3.setTelefone("1232-1321");
        userDTO3.setDataCadastro(new Date());

        usuarios.add(userDTO);
        usuarios.add(userDTO2);
        usuarios.add(userDTO3);
    }

    @GetMapping("/")
    public String getMensagem() {
        return "Spring boot is working!";
    }

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return usuarios;
    }

    @GetMapping("/users/{cpf}")
    public UserDTO getUsersFiltro(@PathVariable String cpf) {
        for (UserDTO userFilter: usuarios) {
            if (userFilter.getCpf().equals(cpf)) {
                return userFilter;
            }
        }

        return null;
    }

    @PostMapping("/newUser")
    public UserDTO inserir(@RequestBody UserDTO userDTO) {
        userDTO.setDataCadastro(new Date());
        usuarios.add(userDTO);
        return userDTO;
    }

    @DeleteMapping("/users/{cpf}")
    public boolean removeUser(@PathVariable String cpf) {
        for (UserDTO userFilter: usuarios) {
            if (userFilter.getCpf().equals(cpf)) {
                usuarios.remove(userFilter);
                return true;
            }
        }

        return false;
    }
}
