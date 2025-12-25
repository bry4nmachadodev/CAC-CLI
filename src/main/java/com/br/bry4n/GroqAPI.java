package com.br.bry4n;
import okhttp3.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;

public class GroqAPI {
    private static final String API_KEY = System.getenv("GROQ_API_KEY");
    private static final String API_URL = "https://api.groq.com/openai/v1/chat/completions";

    public static String chamarGroq(String prompt) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();

        JsonObject message = new JsonObject();
        message.addProperty("role", "user");
        message.addProperty("content", prompt);

        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("model", "llama-3.3-70b-versatile");
        requestBody.add("messages", gson.toJsonTree(new JsonObject[]{gson.fromJson(message, JsonObject.class)}));

        RequestBody body = RequestBody.create(
                requestBody.toString(),
                MediaType.parse("application/json")
        );

        Request request = new Request.Builder()
                .url(API_URL)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .addHeader("Content-Type", "application/json")
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                JsonObject jsonResponse = gson.fromJson(responseBody, JsonObject.class);
                return jsonResponse
                        .getAsJsonArray("choices")
                        .get(0)
                        .getAsJsonObject()
                        .getAsJsonObject("message")
                        .get("content")
                        .getAsString();
            } else {
                throw new IOException("Erro na API: " + response.code());
            }
        }
    }
}