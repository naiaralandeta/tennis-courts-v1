
package com.tenniscourts.guests;

import java.util.List;
import java.util.Optional;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GuestServiceTest {
    
    @Autowired
    private GuestRespository guestRespository;
        
    public GuestServiceTest() {
    }  

    /**
     * Test of save method, of class GuestService.
     */
    @Test
    @DisplayName ("Create user test")
    public void testSave() {
        System.out.println("save");
        Guest guest = new Guest("Peter Smith");
        Guest resultGuest = guestRespository.save(guest);
        assertNotNull(resultGuest);
    }
    
        /**
     * Test of update method, of class GuestService.
     */
    @Test
    @DisplayName ("Update user test")
    public void testUpdate() {
        System.out.println("update");
        String name = "Peter Smith";
        Optional<Guest> guest = guestRespository.findByName(name);
        guest.get().setName("Peter Murphy");
        Guest resultGuest = guestRespository.save(guest.get());
        assertEquals(resultGuest.getName(), "Peter Murphy");
    }

    /**
     * Test of findById method, of class GuestService.
     */
    
    @Test
    @DisplayName ("Find user by ID test")
    public void testFindById() {
        System.out.println("findById");
        Long id = 1l;
        Optional<Guest> guest = guestRespository.findById(id);
        assertEquals(guest.get().getId(), id);
    }

    /**
     * Test of findByName method, of class GuestService.
     */
    @Test
    @DisplayName ("Find user by name test")
    public void testFindByName() {
        System.out.println("findByName");
        String name = "Rafael Nadal";
        Optional<Guest> guest = guestRespository.findByName(name);
        assertEquals(guest.get().getName(), name);
    }

    /**
     * Test of getAllGuests method, of class GuestService.
     */
    @Test
    @DisplayName ("Find all users test")
    public void testGetAllGuests() {
        System.out.println("getAllGuests");
        List<Guest> guestList = guestRespository.findAll();
        assertTrue(!guestList.isEmpty());
    }
    
    /**
     * Test of deleteById method, of class GuestService.
     */
    @Test
    @DisplayName ("Delete user test")
    public void testDeleteById() {
        System.out.println("deleteById");
        List<Guest> guestList = guestRespository.findAll();
        Long id = guestList.get(1).getId();
        guestRespository.deleteById(id);
        Optional<Guest> result = guestRespository.findById(id);
        assertFalse(result.isPresent());
    }
    
}
