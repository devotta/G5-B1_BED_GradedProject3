package com.gl.tickettracker.controller;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gl.tickettracker.entity.Ticket;
import com.gl.tickettracker.service.TicketService;

@Controller
public class TicketController {

	@Autowired
	private TicketService ticketService;

	public TicketController(TicketService ticketService) {
		super();
		this.ticketService = ticketService;
	}

	@RequestMapping(path = { "/", "/search" })
	public String home(Ticket ticket, Model model, String keyword) {
		if (keyword != null) {
			List<Ticket> list = ticketService.findByKeyword(keyword);
			model.addAttribute("tickets", list);
		} else {
			List<Ticket> list = ticketService.getAllTickets();
			model.addAttribute("tickets", list);
		}
		return "search";
	}

	// handler method to handle list ticket and return mode and view
	@GetMapping("/tickets")
	public String listtickets(Model model) {
		model.addAttribute("tickets", ticketService.getAllTickets());
		return "tickets";
	}

	@GetMapping("/tickets/new")
	public String createticketForm(Model model) {

		// create ticket object to hold ticket form data
		Ticket ticket = new Ticket();

		model.addAttribute("ticket", ticket);

		return "create_ticket";

	}

	@PostMapping("/tickets")
	public String saveTicket(@ModelAttribute("ticket") Ticket ticket) {

		ticketService.saveTicket(ticket);
		return "redirect:/tickets";
	}

	@GetMapping("/tickets/edit/{id}")
	public String editticketForm(@PathVariable Long id, Model model) {
		model.addAttribute("ticket", ticketService.getTicketById(id));
		return "edit_ticket";
	}

	@GetMapping("/tickets/view/{id}")
	public String viewticketForm(@PathVariable Long id, Model model) {
		model.addAttribute("ticket", ticketService.getTicketById(id));
		return "view_ticket";
	}

	@PostMapping("/tickets/{id}")
	public String updateticket(@PathVariable Long id, @ModelAttribute("ticket") Ticket ticket, Model model) {

		// get ticket from database by id

		Ticket existingTicket = ticketService.getTicketById(id);
		existingTicket.setId(id);
		existingTicket.setTicket_title(ticket.getTicket_title());
		existingTicket.setTicket_desc(ticket.getTicket_desc());
		existingTicket.setTicket_date(ticket.getTicket_date());
		existingTicket.setTicket_content(ticket.getTicket_content());

		// save updated ticket object
		ticketService.updateTicket(existingTicket);

		return "redirect:/tickets";
	}

	// handler method to handle delete ticket request

	@GetMapping("/tickets/{id}")
	public String deleteticket(@PathVariable Long id) {
		ticketService.deleteTicketById(id);
		return "redirect:/tickets";
	}

}
