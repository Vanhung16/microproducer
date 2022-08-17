package com.example.microproducer;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomMessage {
    private UUID messageId;
    private String message;
}
