package com.example.llmlearningapp.llm;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LLMHelper {

    // PUT YOUR OPENAI API KEY HERE
    private static final String API_KEY = "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";

    private static final String API_URL =
            "https://api.openai.com/v1/chat/completions";

    public interface LLMCallback {
        void onSuccess(String response);
        void onError(String error);
    }

    public static void askAI(String prompt, LLMCallback callback) {

        OkHttpClient client = new OkHttpClient();

        try {

            JSONObject jsonBody = new JSONObject();

            jsonBody.put("model", "gpt-3.5-turbo");

            JSONArray messages = new JSONArray();

            JSONObject userMessage = new JSONObject();
            userMessage.put("role", "user");
            userMessage.put("content", prompt);

            messages.put(userMessage);

            jsonBody.put("messages", messages);

            RequestBody body = RequestBody.create(
                    jsonBody.toString(),
                    MediaType.parse("application/json")
            );

            Request request = new Request.Builder()
                    .url(API_URL)
                    .addHeader("Authorization", "Bearer " + API_KEY)
                    .addHeader("Content-Type", "application/json")
                    .post(body)
                    .build();

            client.newCall(request).enqueue(new Callback() {

                @Override
                public void onFailure(Call call, IOException e) {
                    callback.onError(e.getMessage());
                }

                @Override
                public void onResponse(Call call, Response response)
                        throws IOException {

                    if (response.body() == null) {
                        callback.onError("Empty response");
                        return;
                    }

                    try {

                        String responseData = response.body().string();

                        JSONObject json = new JSONObject(responseData);

                        String result = json
                                .getJSONArray("choices")
                                .getJSONObject(0)
                                .getJSONObject("message")
                                .getString("content");

                        callback.onSuccess(result);

                    } catch (Exception e) {
                        callback.onError(e.getMessage());
                    }
                }
            });

        } catch (Exception e) {
            callback.onError(e.getMessage());
        }
    }
}