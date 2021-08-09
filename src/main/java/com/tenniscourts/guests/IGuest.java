
package com.tenniscourts.guests;

import java.util.List;
import java.util.Optional;

public interface IGuest {
    
    Guest save(Guest guest);
    void deleteById(Long id);
    Optional<Guest> findById(Long id);
    Optional<Guest> findByName(String name);
    List<Guest> getAllGuests();

}
