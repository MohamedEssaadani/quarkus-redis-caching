package org.essaadani.service;

import org.essaadani.dto.CreateUserDTO;
import org.essaadani.dto.UpdateUserDTO;
import org.essaadani.dto.UserDetailsDTO;

import java.util.List;

public interface UserService {
    List<UserDetailsDTO> readAll();

    UserDetailsDTO readOne(String email);

    void create(CreateUserDTO userDTO);

    void update(UpdateUserDTO userDTO);
}
