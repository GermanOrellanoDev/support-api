package com.german.support.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.german.support.dto.AssignTicketRequest;
import com.german.support.dto.CreateCommentRequest;
import com.german.support.dto.CreateTicketRequest;
import com.german.support.dto.UpdateTicketStatusRequest;
import com.german.support.exception.ResourceNotFoundException;
import com.german.support.model.Comment;
import com.german.support.model.Ticket;
import com.german.support.model.TicketStatus;
import com.german.support.repository.CommentRepository;
import com.german.support.repository.TicketRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public Ticket createTicket(CreateTicketRequest request) {
        Ticket ticket = new Ticket();
        ticket.setTitle(request.getTitle());
        ticket.setDescription(request.getDescription());
        ticket.setCreatedBy(request.getCreatedby());
        ticket.setPriority(request.getPriority());
        ticket.setStatus(TicketStatus.OPEN);

        return ticketRepository.save(ticket);
    }

    public Page<Ticket> getAllTickets(Pageable pageable) {
        return ticketRepository.findAll(pageable);
    }

    public Page<Ticket> getAllByStatus(TicketStatus status, Pageable pageable) {
        return ticketRepository.findByStatus(status, pageable);
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket no encontrado con ID: " + id));
    }

    @Transactional
    public Ticket updateTicketByStatus(Long id, UpdateTicketStatusRequest request) {
        Ticket ticket = getTicketById(id);
        ticket.setStatus(request.getStatus());
        return ticketRepository.save(ticket);
    }

    @Transactional
    public Ticket assingTicket(Long id, AssignTicketRequest request) {
        Ticket ticket = getTicketById(id);
        ticket.setAssignedTo(request.getAssigantedTo());
        if (ticket.getStatus() == TicketStatus.OPEN) {
            ticket.setStatus(TicketStatus.IN_PROGRESS);
        }
        return ticketRepository.save(ticket);
    }

    @Transactional
    public Comment addComment(Long id, CreateCommentRequest request) {
        Ticket ticket = getTicketById(id);
        Comment comment = new Comment();
        comment.setContent(request.getContent());
        comment.setAuthor(request.getAuthor());
        comment.setTicket(ticket);

        return commentRepository.save(comment);
    }

    public List<Comment> getTickComments(Long id) {
        getTicketById(id);
        return commentRepository.findByTicketIdOrderByCreatedAtDesc(id);
    }

    @Transactional
    public void deleteTicket(Long id) {
        Ticket ticket = getTicketById(id);
        ticketRepository.delete(ticket);
    }
}
