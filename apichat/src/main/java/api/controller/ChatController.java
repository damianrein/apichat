package api.controller;

import api.service.ChatService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/chat")
public class ChatController {
    @Inject
    private ChatService chatService;

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response chat(String mensaje) {
        String respuesta = chatService.chatMessage(mensaje);
        return Response.ok(respuesta).build();
    }
}
