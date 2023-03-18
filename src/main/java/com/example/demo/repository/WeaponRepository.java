package com.example.demo.repository;

import com.example.demo.entity.Weapon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface WeaponRepository extends PagingAndSortingRepository<Weapon, Long>, CrudRepository<Weapon, Long> {
}