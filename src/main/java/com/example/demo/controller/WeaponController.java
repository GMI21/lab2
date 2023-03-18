package com.example.demo.controller;

import com.example.demo.entity.Player;
import com.example.demo.entity.Weapon;
import com.example.demo.service.DeleteWeaponForm;
import com.example.demo.service.PlayerService;
import com.example.demo.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WeaponController {
    @Autowired
    private WeaponService weaponService;

    @Autowired
    private PlayerService playerService;

    @RequestMapping("/viewWeapon")
    public String viewWeapons(Model model) {
        DeleteWeaponForm deleteWeaponForm = new DeleteWeaponForm();
        List<Weapon> weapons = weaponService.listAll();
        model.addAttribute("deleteWeaponForm", deleteWeaponForm);
        model.addAttribute("listWeapons", weapons);
        return "viewWeapon.html";
    }


    @RequestMapping("/newWeapon")
    public String newWeapon(Model model) {
        Weapon weapon = new Weapon();
        model.addAttribute("weapon", weapon);
        return "editWeaponForm.html";
    }

    @RequestMapping(value = "/saveWeapon", method = RequestMethod.GET)
    public String saveWeapon(Model model, @ModelAttribute("weapon") Weapon weapon) {
        DeleteWeaponForm deleteWeaponForm = new DeleteWeaponForm();
        weaponService.save(weapon);
        List<Weapon> weapons = weaponService.listAll();
        model.addAttribute("deleteWeaponForm", deleteWeaponForm);
        model.addAttribute("listWeapons", weapons);
        return "viewWeapon.html";
    }

    @RequestMapping("/EditWeapon/{id}")
    public ModelAndView editWeapon(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("editWeaponForm");
        Weapon weapon = weaponService.get(id);
        List<Player> allPlayers = playerService.listAll();
        mav.addObject("allPlayers", allPlayers);
        mav.addObject("weapon", weapon);
        return mav;
    }

    @RequestMapping("/DeleteWeapon/{id}")
    public String deleteWeapon(@PathVariable(name = "id") Long id) {
        weaponService.delete(id);
        return "";
    }

    @RequestMapping("/DeleteWeapons")
    public String deleteWeapons( @RequestParam("weapons") Long [] weaponIds, Model model) {
        weaponService.deleteWeapons(weaponIds);
        DeleteWeaponForm deleteWeaponForm = new DeleteWeaponForm();
        List<Weapon> weapons = weaponService.listAll();
        model.addAttribute("deleteWeaponForm", deleteWeaponForm);
        model.addAttribute("listWeapons", weapons);
        return "viewWeapon.html";
    }


}
