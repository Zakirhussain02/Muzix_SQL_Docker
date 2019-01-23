package com.stackroute.repository;

import com.stackroute.domain.Muzix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


//muzix repo for connecting with DB

@Repository
public interface MuzixRepository extends JpaRepository<Muzix,Integer>{
    @Query("SELECT m FROM Muzix m WHERE m.trackName= ?1")
    List<Muzix> findBytrackName(String trackName);

}

