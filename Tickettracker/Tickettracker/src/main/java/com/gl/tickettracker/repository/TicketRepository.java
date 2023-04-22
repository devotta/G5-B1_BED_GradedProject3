package com.gl.tickettracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gl.tickettracker.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

	// Query to retrieve data from Ticket table
	// where keyword matching the title and description
	@Query(value = "select * from Ticket t where t.ticket_title like %:keyword% or t.ticket_desc like %:keyword%", nativeQuery = true)
	List<Ticket> findByKeyword(@Param("keyword") String keyword);

}
