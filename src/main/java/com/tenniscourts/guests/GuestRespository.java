package com.tenniscourts.guests;

import java.util.Optional;
import org.springframework.context.annotation.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRespository extends JpaRepository<Guest, Long> {

    Optional<Guest> findByName(String name);
    
}