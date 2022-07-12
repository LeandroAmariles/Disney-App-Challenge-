package com.disney.disneyproject.repository;

import com.disney.disneyproject.entities.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<Gender,Long> {
}
