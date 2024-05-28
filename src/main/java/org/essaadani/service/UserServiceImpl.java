package org.essaadani.service;

import io.quarkus.cache.CacheInvalidate;
import io.quarkus.cache.CacheInvalidateAll;
import io.quarkus.cache.CacheResult;
import jakarta.enterprise.context.ApplicationScoped;
import org.essaadani.dto.CreateUserDTO;
import org.essaadani.dto.UpdateUserDTO;
import org.essaadani.dto.UserDetailsDTO;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UserServiceImpl implements UserService {
    private final List<UserDetailsDTO> usersList = new ArrayList<>();

    @Override
    @CacheResult(cacheName = "users")
    public List<UserDetailsDTO> readAll() {
        fillUsers();
        return usersList;
    }

    private void fillUsers() {
        UserDetailsDTO mohamed = new UserDetailsDTO("Mohamed Es-saadani", "26", "essaadani80@gmail.com");
        UserDetailsDTO youssef = new UserDetailsDTO("Youssef Youssef", "35", "essaadani22@gmail.com");
        UserDetailsDTO abdellah = new UserDetailsDTO("Abdellah Abdellah", "49", "essaadani@gmail.com");
        //
        usersList.addAll(List.of(youssef, mohamed, abdellah));
    }

    @Override
    @CacheResult(cacheName = "user")
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
    @CacheInvalidateAll(cacheName = "users")
    public void create(UserDetailsDTO userDTO) {
        System.out.println("userdto" + userDTO);
        usersList.add(userDTO);
    }

    @Override
    @CacheInvalidate(cacheName = "users")
    public void update(UpdateUserDTO userDTO) {

    }

    @Override
    @CacheInvalidateAll(cacheName = "users")
    @CacheInvalidate(cacheName = "user")
    public void clearCache() {

    }
}
