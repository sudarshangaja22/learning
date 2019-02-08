package com.tcs.hack;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.sql.Date;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.tcs.hack.model.Booking;
import com.tcs.hack.model.Resource;
import org.springframework.http.HttpStatus;
import com.tcs.hack.repository.BookingRepository;
import com.tcs.hack.repository.ResourceRepository;
//import com.tcs.hack.Service;
import com.tcs.hack.dto.ReservationsDTO;
import com.tcs.hack.dto.BookingDTO;


@RestController
@RequestMapping("/tcs/hack/v1")
public class Controller {

    @Autowired
    private ResourceRepository resourceRepository ;
    @Autowired
    private BookingRepository bookingRepository;


    //private Service service;

    @GetMapping("/reservations")
    public ResponseEntity<List<ReservationsDTO>> getAllBookings() throws Exception {
//List<Booking> bookingList = bookingService.getAllBookings();
        ReservationsDTO reservationsDTO = new ReservationsDTO();
        reservationsDTO.setResourceName("resourceName");
        reservationsDTO.setBookingSlot("15:00 - 16:00");
        reservationsDTO.setBookingDate("2017-12-31");
        List<ReservationsDTO> reservationsDTOList = new ArrayList<ReservationsDTO>();
        reservationsDTOList.add(reservationsDTO);
        return new ResponseEntity<List<ReservationsDTO>>(reservationsDTOList, HttpStatus.OK);
    }

    @PostMapping("/reservations")
    public ResponseEntity<?> addBooking(@RequestBody BookingDTO bookingDTO) throws Exception {


        SimpleDateFormat df = new SimpleDateFormat("dd-MM-YYYY");
        java.util.Date date = df.parse(bookingDTO.getBookingDate());
        java.sql.Date sqlDate= new java.sql.Date(date.getTime());


        int countCheck = bookingRepository.findAvailability(bookingDTO.getResourceId() ,sqlDate ,bookingDTO.getBookingSlot());
        if (countCheck==0)
        {

            Booking booking =new Booking();

            booking.setBookingDate(sqlDate);
            booking.setBookingSlot(bookingDTO.getBookingSlot());
            Resource resource = resourceRepository.findOne(bookingDTO.getResourceId());
            booking.setResource(resource);
            booking.setBookingId(1100);
            Booking bookingSaved = bookingRepository.save(booking);
            return new ResponseEntity<Booking>( bookingSaved,HttpStatus.CREATED);
        }

        else
        {

            return new ResponseEntity<>( "Resource not available",HttpStatus.OK);
        }
    }



    @GetMapping("/resources")
    public ResponseEntity<List<Resource>> getAllResources() throws Exception {
        List <Resource> resourceList = new ArrayList<Resource>();
        resourceRepository.findAll().forEach(resourceList::add);
        return new ResponseEntity<List<Resource>>(resourceList, HttpStatus.OK);
    }

    @GetMapping("/resources/{id}")
    public ResponseEntity<Resource> getResourcebyID(@PathVariable String id) throws Exception {

        Resource resource = resourceRepository.findOne(Integer.parseInt(id));
        return new ResponseEntity<Resource>( resource,HttpStatus.OK);


    }

    @PostMapping("/resources")
    public ResponseEntity<Resource> createResource(@RequestBody Resource resource)
    {
        Resource resourceSaved = resourceRepository.save(resource);
        return new ResponseEntity<Resource>( resourceSaved,HttpStatus.CREATED);
    }


    @DeleteMapping("/resources")
    public ResponseEntity<Void> deleteReource(@RequestBody Resource resource)
    {
        resourceRepository.delete(resource);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }




}