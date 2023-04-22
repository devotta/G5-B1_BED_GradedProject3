package com.gl.tickettracker.service;

import java.util.List;

import com.gl.tickettracker.entity.Ticket;

public interface TicketService {

	List<Ticket> getAllTickets();

	Ticket saveTicket(Ticket ticket);

	Ticket getTicketById(Long id);

	Ticket updateTicket(Ticket ticket);

	void deleteTicketById(Long id);

	List<Ticket> findByKeyword(String keyword);

}
