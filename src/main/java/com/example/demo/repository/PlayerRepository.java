package com.example.demo.repository;

import com.example.demo.entity.Player;
import org.springframework.data.repository.CrudRepository;


public interface PlayerRepository extends CrudRepository<Player, Long> {
}
