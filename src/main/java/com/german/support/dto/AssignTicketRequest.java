package com.german.support.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AssignTicketRequest {
    @NotBlank(message = "El agente asignado es obligatorio")
    private String assigantedTo;
}
