package com.gl.tickettracker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.tickettracker.entity.Ticket;
import com.gl.tickettracker.repository.TicketRepository;
import com.gl.tickettracker.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	public TicketServiceImpl(TicketRepository ticketRepository) {

		this.ticketRepository = ticketRepository;
	}

	@Autowired
	private TicketRepository ticketRepository;

	public List<Ticket> getAllTickets() {
		return ticketRepository.findAll();
	}

	public List<Ticket> findByKeyword(String keyword) {
		return ticketRepository.findByKeyword(keyword);
	}

	@Override
	public Ticket saveTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	@Override
	public Ticket getTicketById(Long id) {
		return ticketRepository.findById(id).get();
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	@Override
	public void deleteTicketById(Long id) {
		ticketRepository.deleteById(id);

	}

}
