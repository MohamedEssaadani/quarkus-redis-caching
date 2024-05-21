package org.essaadani.service;

import io.quarkus.cache.CacheInvalidate;
import io.quarkus.cache.CacheResult;
import jakarta.enterprise.context.ApplicationScoped;
import org.essaadani.dto.CreateUserDTO;
import org.essaadani.dto.UpdateUserDTO;
import org.essaadani.dto.UserDetailsDTO;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UserServiceImpl implements UserService {
    private List<UserDetailsDTO> usersList = new ArrayList<>();

    @Override
    @CacheResult(cacheName = "users")
    public List<UserDetailsDTO> readAll() {
        fillUsers();
        return usersList;
    }

    private void fillUsers() {
        UserDetailsDTO mohamed = new UserDetailsDTO("Mohamed Es-saadani", "26", "essaadani@gmail.com");
        UserDetailsDTO youssef = new UserDetailsDTO("Youssef Youssef", "35", "essaadani@gmail.com");
        UserDetailsDTO abdellah = new UserDetailsDTO("Abdellah Abdellah", "49", "essaadani@gmail.com");
        //
        usersList.addAll(List.of(youssef, mohamed, abdellah));
    }

    @Override
    public UserDetailsDTO readOne(String email) {
        UserDetailsDTO user = new UserDetailsDTO();

        for (UserDetailsDTO item : usersList) {
            if (email.equals(item.getEmail())) {
                user = item;
                break;
            }
        }
        return user;
    }

    @Override
    @CacheInvalidate(cacheName = "users")
    public void create(CreateUserDTO userDTO) {
    }

    @Override
    @CacheInvalidate(cacheName = "users")
    public void update(UpdateUserDTO userDTO) {

    }
}
