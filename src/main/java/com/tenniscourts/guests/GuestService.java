
package com.tenniscourts.guests;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GuestService implements IGuest{   
   
    private final GuestRespository guestRepository;

    @Override
    public Guest save(Guest guest) {
        return guestRepository.save(guest);
    }
    
    @Override
    public void deleteById(Long id) {
        guestRepository.deleteById(id);
    }
    
    @Override
    public Optional<Guest> findById(Long id) {
        return guestRepository.findById(id);
    }
    
    @Override
    public Optional<Guest> findByName(String name) {
        return guestRepository.findByName(name);
    }
    
    @Override
    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }
 
}
