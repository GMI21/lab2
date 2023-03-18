package com.example.demo.service;

import com.example.demo.entity.Player;
import com.example.demo.entity.Weapon;
import com.example.demo.repository.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeaponService {
    @Autowired
    private WeaponRepository weaponRepository;

    public List<Weapon> listAll() {
        return weaponRepository.findAll(PageRequest.of(0, 25)).toList();
    }

    public void save(Weapon weapon) {
        weaponRepository.save(weapon);
    }

    public Weapon get(Long id) {
        return weaponRepository.findById(id).get();
    }

    public void delete(Long id) {
        weaponRepository.deleteById(id);
    }

    public void deleteWeapons(Long [] weaponIds) {
        for (Long id : weaponIds){
            weaponRepository.deleteById(id);
        }
    }
}
