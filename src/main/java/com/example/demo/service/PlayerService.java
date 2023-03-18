package com.example.demo.service;

import com.example.demo.entity.Player;
import com.example.demo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository PlayerBase;

    public List<Player> listAll() {
        return PlayerBase.findAll();
    }

    public void save(Player player) {
        PlayerBase.save(player);
    }

    public Player get(Long id) {
        return PlayerBase.findById(id).get();
    }

    public void delete(Long id){
        PlayerBase.deleteById(id);
    }
}
