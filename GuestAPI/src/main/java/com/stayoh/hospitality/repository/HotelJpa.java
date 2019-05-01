package com.stayoh.hospitality.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stayoh.hospitality.entity.Hotel;
@Repository
public interface HotelJpa extends JpaRepository<Hotel, Integer> {

}
