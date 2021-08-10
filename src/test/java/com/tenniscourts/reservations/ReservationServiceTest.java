package com.tenniscourts.reservations;

import com.tenniscourts.guests.*;
import com.tenniscourts.schedules.*;
import com.tenniscourts.tenniscourts.*;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = ReservationService.class)
public class ReservationServiceTest {

    @InjectMocks
    ReservationService reservationService;
    
    @Test
    public void getRefundValueFullRefund() {
        Schedule schedule = new Schedule();

        LocalDateTime startDateTime = LocalDateTime.now().plusDays(2);

        schedule.setStartDateTime(startDateTime);
        
        Assert.assertEquals(reservationService.getRefundValue(Reservation.builder().schedule(schedule).value(new BigDecimal(10L)).build()), new BigDecimal(10));
    }
    
    @Test
    public void bookNewReservation(){
        
        TennisCourtDTO tennisCourtDTO = new TennisCourtDTO();
        tennisCourtDTO.setId(1l);

        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setId(1l);
        scheduleDTO.setStartDateTime(LocalDateTime.now());
        scheduleDTO.setEndDateTime(LocalDateTime.now());
        scheduleDTO.setTennisCourt(tennisCourtDTO);
        
        CreateReservationRequestDTO createReservationRequestDTO = new CreateReservationRequestDTO();
        createReservationRequestDTO.setGuestId(1l);
        createReservationRequestDTO.setScheduleId(1l);
        
        Assert.assertNotNull(reservationService.bookReservation(createReservationRequestDTO));        
    }
}