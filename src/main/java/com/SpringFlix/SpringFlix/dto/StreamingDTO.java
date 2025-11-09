package com.SpringFlix.SpringFlix.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StreamingDTO {
    private Long id;
    @NotEmpty(message = "Streaming name is needed")
    private String name;
}
