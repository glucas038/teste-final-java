package com.minsait.testefinaljava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minsait.testefinaljava.entity.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente, String>{

}
