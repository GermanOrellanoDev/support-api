package com.german.support.dto;

import com.german.support.model.TicketStatus;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateTicketStatusRequest {
    @NotNull(message = "El estado es obligatorio")
    private TicketStatus status;
}
