package com.tcs.hack.repository;

import com.tcs.hack.model.Booking;
import com.tcs.hack.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface ResourceRepository extends JpaRepository<Resource, Integer> {

}
