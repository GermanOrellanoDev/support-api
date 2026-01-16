package com.german.support.dto;

import com.german.support.model.TicketPriority;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateTicketRequest {
    @NotBlank(message = "El título es obligatorio")
    @Size(min = 5, max = 200, message = "El título debe contener entre 5 y 200 caracteres")
    private String title;

    @NotBlank(message = "La descripción es obligatoria")
    @Size(min = 10, max = 2000, message = "La descripción debe tener entre 10 y 2000 caracteres")
    private String description;

    @NotBlank(message = "El creador es obligatorio")
    private String createdby;

    private TicketPriority priority = TicketPriority.MEDIUM;
}
