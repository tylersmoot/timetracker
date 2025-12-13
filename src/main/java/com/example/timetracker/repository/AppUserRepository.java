package com.example.timetracker.repository;
import com.example.timetracker.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

  AppUser findByEmail(String email);

}
