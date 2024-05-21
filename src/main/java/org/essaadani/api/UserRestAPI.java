package org.essaadani.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.essaadani.dto.CreateUserDTO;
import org.essaadani.dto.UserDetailsDTO;
import org.essaadani.service.UserService;

import java.util.List;

@Path("/api/users")
public class UserRestAPI {
    @Inject
    private UserService userService;

    @POST
    @Consumes("application/json")
    public Response createUser(CreateUserDTO userDTO) {
        System.out.println(userDTO);
        return Response.status(Response.Status.CREATED).build();
    }


    @GET
    @Produces("application/json")
    public List<UserDetailsDTO> getAll(){
        return userService.readAll();
    }
}
