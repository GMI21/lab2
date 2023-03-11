package com.example.demo.service;

import com.example.demo.entity.Player;
import com.example.demo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    PlayerRepository PlayerBase;

    /*@GetMapping("/admin/EditPlayer")
    public String editPlayer(@RequestParam(name = "name", required = true) String name, Model model) {

        model.addAttribute("name", name);
        return "Output.html";
    }*/

    @GetMapping("/admin/AddPlayer")
    public String addPlayer(@RequestParam(name = "name", required = false) String name, Model model) {
        Player P1 = new Player();
        P1.setName(name);
        PlayerBase.save(P1);
        model.addAttribute("name", name);
        model.addAttribute("id", P1.getId());
        return "addPlayer.html";

    }

    @GetMapping("/admin/ViewPlayers")
    public String viewPlayers(Model model) {
        Iterable<Player> players = PlayerBase.findAll();
        model.addAttribute("players", players);
        return "deletePlayer.html";

    }
}
