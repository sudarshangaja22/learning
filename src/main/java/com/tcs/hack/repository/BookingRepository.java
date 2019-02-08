package com.tcs.hack.repository;


import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import com.tcs.hack.model.Booking;

public interface BookingRepository extends CrudRepository<Booking, Integer>{

    @Query(value="SELECT count(a.resource_id) FROM booking a WHERE a.resource_id =:resourceId and a.booking_date =:bookingDate and a.booking_slot =:slot ",nativeQuery = true)
//public int findAvailability(int resourceId, java.sql.Date date, String slot);
    public int findAvailability(@Param("resourceId") int resourceId, @Param("bookingDate") java.sql.Date bookingDate, @Param("slot") String slot);
}
