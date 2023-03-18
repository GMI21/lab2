package com.example.demo.controller;

import org.springframework.ui.Model;
import com.example.demo.entity.Player;
import com.example.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private PlayerService service;

    @RequestMapping("/viewPlayer")
    public String viewIndex(Model model) {
        List<Player> listPlayers = service.listAll();
        model.addAttribute("listPlayers", listPlayers);
        return "viewPlayer.html";
    }

    @RequestMapping("/new")
    public String ShowNewPlayer(Model model) {
        Player player = new Player();
        model.addAttribute("player", player);
        return "addPlayer.html";
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String savePlayer(Model model, @ModelAttribute("player") Player player) {
        service.save(player);
        List<Player> listPlayers = service.listAll();
        model.addAttribute("listPlayers", listPlayers);
        return "/viewPlayer.html";
    }

    @RequestMapping("/EditPlayer/{id}")
    public ModelAndView editPlayer(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("editPlayer");

        Player player = service.get(id);
        mav.addObject("player", player);

        return mav;
    }

    @RequestMapping("/DeletePlayer/{id}")
    public String deletePlayer(@PathVariable(name = "id") Long id) {
        service.delete(id);

        return "redirect:/";
    }
}
