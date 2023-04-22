package com.gl.tickettracker.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Ticket_title", nullable = false)
	private String ticket_title;

	@Column(name = "Ticket_desc", columnDefinition = "TEXT")
	private String ticket_desc;

	@Column(name = "Ticket_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ticket_date;

	public Ticket() {

	}

	public Ticket(String ticket_title, String ticket_desc, Date ticket_date) {
		super();
		this.ticket_title = ticket_title;
		this.ticket_desc = ticket_desc;
		this.ticket_date = ticket_date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTicket_title() {
		return ticket_title;
	}

	public void setTicket_title(String ticket_title) {
		this.ticket_title = ticket_title;
	}

	public String getTicket_desc() {
		return ticket_desc;
	}

	public void setTicket_desc(String ticket_desc) {
		this.ticket_desc = ticket_desc;
	}

	public Date getTicket_date() {
		return ticket_date;
	}

	public void setTicket_date(Date ticket_date) {
		this.ticket_date = ticket_date;
	}

}
