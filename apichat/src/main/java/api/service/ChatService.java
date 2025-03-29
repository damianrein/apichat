package api.service;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import dev.langchain4j.model.openai.OpenAiChatModel;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ChatService {

	@ConfigProperty(name = "quarkus.langchain4j.openai.api-key")
	private String apiKey;

    private OpenAiChatModel chatModel = OpenAiChatModel.builder()
            .apiKey(apiKey)
            .temperature(0.7)
            .maxTokens(2048)
            .baseUrl("https://api.openai.com/v1")
            .modelName("gpt-4o")
            .build(); 

    public String chatMessage(String mensaje) {
        try {
            return chatModel.chat(mensaje); 
        } catch (Exception e) {
            return "Error al enviar el mensaje: " + e.getMessage();
        }
    }
}
