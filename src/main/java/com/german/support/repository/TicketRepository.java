package com.german.support.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.german.support.model.Ticket;
import com.german.support.model.TicketStatus;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Page<Ticket> findByStatus(TicketStatus status, Pageable pageable);

    Page<Ticket> findByCreatedBy(String createdBy, Pageable pageable);

    Page<Ticket> findByAssignedTo(String assignedTo, Pageable pageable);
}
