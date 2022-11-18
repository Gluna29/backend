/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.jgl.Service;

import com.portfolio.jgl.Entity.Proy;
import com.portfolio.jgl.Repository.RProy;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProy {
    @Autowired
    RProy rProy;
    
    public List<Proy> list(){
        return rProy.findAll();
    }
    
    public Optional<Proy> getOne(int id){
        return rProy.findById(id);
                }
    public Optional<Proy> getByNombreP(String nombreP){
        return rProy.findByNombreP(nombreP);
    }
    public void save(Proy proy){
        rProy.save(proy);
    }    
    public void delete(int id){
        rProy.deleteById(id);
    }
    public boolean existsById(int id){
        return rProy.existsById(id);
    }
    public boolean existsByNombreP(String nombreP){
        return rProy.existsByNombreP(nombreP);
    }
}
