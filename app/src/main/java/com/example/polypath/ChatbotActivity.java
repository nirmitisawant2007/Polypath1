package com.example.polypath;

import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.ai.client.generativeai.GenerativeModel;
import com.google.ai.client.generativeai.java.GenerativeModelFutures;
import com.google.ai.client.generativeai.type.Content;
import com.google.ai.client.generativeai.type.GenerateContentResponse;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.ArrayList;
import java.util.List;

public class ChatbotActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EditText etMessage;
    private ImageView btnSend;
    private List<ChatMessage> messageList;
    private ChatAdapter adapter;
    private GenerativeModelFutures model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatbot);

        recyclerView = findViewById(R.id.chatRecyclerView);
        etMessage = findViewById(R.id.et_message);
        btnSend = findViewById(R.id.btn_send);

        // API Key paste kar yahan
        GenerativeModel gm = new GenerativeModel("models/gemini-3-flash-preview", "AIzaSyDJYlWKgnP2jeFIrS5ZKTbRMDNnWW2ugu0");
        model = GenerativeModelFutures.from(gm);

        messageList = new ArrayList<>();
        adapter = new ChatAdapter(messageList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        btnSend.setOnClickListener(v -> {
            String question = etMessage.getText().toString().trim();
            if (!question.isEmpty()) {
                addToChat(question, ChatMessage.SENT_BY_USER);
                etMessage.setText("");
                askGemini(question);
            }
        });
    }

    private void addToChat(String message, String sentBy) {
        runOnUiThread(() -> {
            messageList.add(new ChatMessage(message, sentBy));
            adapter.notifyItemInserted(messageList.size() - 1); // Specific update

            // Scroll tabhi karo jab list empty na ho
            if (adapter.getItemCount() > 0) {
                recyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);
            }
        });
    }

    private void askGemini(String question) {
        // 1. "Thinking..." add karo
        addToChat("PolyBot is thinking...", ChatMessage.SENT_BY_BOT);

        Content content = new Content.Builder().addText(question).build();
        ListenableFuture<GenerateContentResponse> response = model.generateContent(content);

        Futures.addCallback(response, new FutureCallback<GenerateContentResponse>() {
            @Override
            public void onSuccess(GenerateContentResponse result) {
                runOnUiThread(() -> {
                    // IMPORTANT FIX: List check karo aur remove karke seedha notify karo
                    if (!messageList.isEmpty()) {
                        int lastIndex = messageList.size() - 1;
                        if (messageList.get(lastIndex).getMessage().equals("PolyBot is thinking...")) {
                            messageList.remove(lastIndex);
                            adapter.notifyItemRemoved(lastIndex); // RecyclerView ko batao line remove hui
                        }
                    }
                    addToChat(result.getText(), ChatMessage.SENT_BY_BOT);
                });
            }

            @Override
            public void onFailure(Throwable t) {
                runOnUiThread(() -> {
                    if (!messageList.isEmpty()) {
                        int lastIndex = messageList.size() - 1;
                        messageList.remove(lastIndex);
                        adapter.notifyItemRemoved(lastIndex);
                    }
                    addToChat("Error: " + t.getMessage(), ChatMessage.SENT_BY_BOT);
                });
            }
        }, androidx.core.content.ContextCompat.getMainExecutor(ChatbotActivity.this));
    }
}