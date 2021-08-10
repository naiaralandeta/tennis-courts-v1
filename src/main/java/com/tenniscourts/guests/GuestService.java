
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

    /**
     *
     * @param guest
     * @return 
     */
    //@PreAuthorize("hasAuthority('ADMIN')")
    @Override
    public Guest save(Guest guest) {
        return guestRepository.save(guest);
    }

    /**
     *
     * @param id from a guest
     */
    @Override
    //@PreAuthorize("hasAuthority('ADMIN')")
    public void deleteById(Long id) {
        guestRepository.deleteById(id);
    }

    /**
     *
     * @param id from a guest
     * @return a guest in the case that exist
     */
    @Override
    //@PreAuthorize("hasAuthority('ADMIN')")
    public Optional<Guest> findById(Long id) {
        return guestRepository.findById(id);
    }

    /**
     *
     * @param name of a guest
     * @return a guest in case that exist
     */
    @Override
    //@PreAuthorize("hasAuthority('ADMIN')")
    public Optional<Guest> findByName(String name) {
        return guestRepository.findByName(name);
    }

    /**
     *
     * @return a list with all guests found it
     */
    @Override
    //@PreAuthorize("hasAuthority('ADMIN')")
    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }
 
}
