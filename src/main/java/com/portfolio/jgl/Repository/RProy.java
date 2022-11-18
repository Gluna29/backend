/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.jgl.Repository;

import com.portfolio.jgl.Entity.Proy;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProy extends JpaRepository<Proy, Integer>{
    public Optional<Proy> findByNombreP(String nombreP);
    public boolean existsByNombreP(String nombreP);
}
