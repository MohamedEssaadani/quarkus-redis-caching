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
        userService.create(userDTO);
        return Response.status(Response.Status.CREATED).build();
    }


    @GET
    @Produces("application/json")
    public List<UserDetailsDTO> getAll() {
        return userService.readAll();
    }

    @GET
    @Path("/{email}")
    public Response getOneByEmail(@PathParam("email") String email) {
        UserDetailsDTO userDetailsDTO = userService.readOne(email);

        return Response
                .status(Response.Status.OK)
                .entity(userDetailsDTO)
                .build();
    }

    @POST
    @Path(value = "/cache/clear")
    public Response clearCache() {
        System.out.println("received in clear cache");
        userService.clearCache();
        return Response.status(Response.Status.OK).build();
    }
}
