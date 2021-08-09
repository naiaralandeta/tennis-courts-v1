package com.tenniscourts.guests;


import com.tenniscourts.config.BaseRestController;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.PathVariable;
import com.tenniscourts.exceptions.GuestNotFoundException;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class GuestController extends BaseRestController {
    
    private final GuestService guestservice;
    
    @PostMapping(value="/guests")
    public Guest addGuest(@Valid @RequestBody Guest guest) {
        return guestservice.save(guest);
    } 
    
    @PutMapping(value="/guests/{id}")
    public Guest updateGuest(@PathVariable("id") Long id, @Valid @RequestBody Guest newguest) {
        Guest guest = guestservice.findById(id).orElseThrow(() -> new GuestNotFoundException("Guest with ID: " + id + " is NOT FOUND!"));
        guest.setName(newguest.getName());
        guest.setDateUpdate(newguest.getDateCreate());
        guest.setUserUpdate(newguest.getUserCreate());
        guest.setIpNumberUpdate(newguest.getIpNumberCreate());
        return guestservice.save(guest);   
    } 
    
    @DeleteMapping(value="/guests/{id}")
    public String deleteGuest(@PathVariable("id") Long id) {
        Guest guest = guestservice.findById(id).orElseThrow(() -> new GuestNotFoundException("Guest with ID: " + id + " is NOT FOUND!"));
        guestservice.deleteById(guest.getId());
        return "Guest with ID :" + id + " is deleted";            
    }
    
    @GetMapping(value="/guests/{id}")
    public Guest getGuestById(@PathVariable("id") Long id) {
        Guest std = guestservice.findById(id).orElseThrow(() -> new GuestNotFoundException("Guest with ID:" + id + " is NOT FOUND!"));
        return std;
    }
    
    @GetMapping(value="/guests/{name}")
    public Guest getGuestByName(@PathVariable("name") String name) {
        Guest std = guestservice.findByName(name).orElseThrow(() -> new GuestNotFoundException("Guest with name:" + name + " is NOT FOUND!"));
        return std;
    } 
    
    @GetMapping(value = "/guests")
    public List<Guest> getAllGuests(){
        return guestservice.getAllGuests();
    } 
    
}
