package br.com.karloskelvin.services;

import br.com.karloskelvin.model.User;
import br.com.karloskelvin.model.dtos.UserDTO;
import br.com.karloskelvin.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getAll() {
        List<User> usuarios = userRepository.findAll();
        return usuarios.stream().map(UserDTO::convert).collect(Collectors.toList());
    }

    public UserDTO findById(long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return UserDTO.convert(user.get());
        }
        return null;
    }

    public UserDTO save(UserDTO userDTO) {
        User user = userRepository.save(User.convert(userDTO));
        return UserDTO.convert(user);
    }

    public UserDTO delete(long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            userRepository.delete(user.get());
        }
        return null;
    }

    public UserDTO findByCpf(String cpf) {
        Optional<User> user = userRepository.findByCpf(cpf);
        if (user.isPresent()) {
            return UserDTO.convert(user.get());
        }

        return null;
    }

    public List<UserDTO> queryByName(String name) {
        List<User> users = userRepository.queryByNomeLike(name);
        return users.stream().map(UserDTO::convert).collect(Collectors.toList());
    }
}
