
package com.tenniscourts.guests;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
//import org.springframework.security.access.prepost.PreAuthorize;

@Service
@AllArgsConstructor
public class GuestService implements IGuest{   
   
    private final GuestRespository guestRepository;

    //@PreAuthorize("hasAuthority('ADMIN')")
    @Override
    public Guest save(Guest guest) {
        return guestRepository.save(guest);
    }
    
    //@PreAuthorize("hasAuthority('ADMIN')")
    @Override
    public void deleteById(Long id) {
        guestRepository.deleteById(id);
    }
    
    //@PreAuthorize("hasAuthority('ADMIN')")
    @Override
    public Optional<Guest> findById(Long id) {
        return guestRepository.findById(id);
    }
    
    //@PreAuthorize("hasAuthority('ADMIN')")
    @Override
    public Optional<Guest> findByName(String name) {
        return guestRepository.findByName(name);
    }
    
    //@PreAuthorize("hasAuthority('ADMIN')")
    @Override
    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }
 
}
