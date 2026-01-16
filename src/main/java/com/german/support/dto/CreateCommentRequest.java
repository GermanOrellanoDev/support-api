package com.german.support.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateCommentRequest {
    @NotBlank(message = "El contenido es obligatorio")
    @Size(min = 1, max = 2000, message = "El comentario debe tener entre 1 y 2000 caracteres")
    private String content;

    @NotBlank(message = "El autor es obligatorio")
    private String author;
}
