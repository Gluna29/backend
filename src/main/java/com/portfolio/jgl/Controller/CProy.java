/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.jgl.Controller;

import com.portfolio.jgl.Dto.dtoProy;
import com.portfolio.jgl.Entity.Proy;
import com.portfolio.jgl.Security.Controller.Mensaje;
import com.portfolio.jgl.Service.SProy;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/proy")
@CrossOrigin(origins = "http://apjglfront.web.app/")
public class CProy {
    @Autowired
    SProy sProy;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proy>>list(){
      List<Proy> list = sProy.list();
      return new ResponseEntity(list, HttpStatus.OK);
      
    }
     @GetMapping("/detail/{id}")
    public ResponseEntity<Proy>getById(@PathVariable("id")int id){
        if(!sProy.existsById(id)){
            return new ResponseEntity(new Mensaje ("No existe el id"), HttpStatus.BAD_REQUEST);
        }
        Proy proy = sProy.getOne(id).get();
        return new ResponseEntity(proy, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if (!sProy.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe el id"), HttpStatus.NOT_FOUND);
        }
        sProy.delete(id);
        return new ResponseEntity(new Mensaje("proyecto eliminado"), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProy dtoproy){
        if (StringUtils.isBlank(dtoproy.getNombreP())){
            return new ResponseEntity(new Mensaje("el nombre el obligatorio"),HttpStatus.BAD_REQUEST);
        }
        if (sProy.existsByNombreP(dtoproy.getNombreP())){
            return new ResponseEntity(new Mensaje("esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        Proy proy = new Proy(
      dtoproy.getNombreP(),dtoproy.getDescripcionP(),dtoproy.getImg()
      );
      sProy.save(proy);
      return new ResponseEntity(new Mensaje("Proyecto creado"),HttpStatus.OK);
    }    
     @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody dtoProy dtoproy){
        if(!sProy.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        if(sProy.existsByNombreP(dtoproy.getNombreP()) && sProy.getByNombreP(dtoproy.getNombreP()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoproy.getNombreP())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        Proy proy = sProy.getOne(id).get();
        
        proy.setNombreP(dtoproy.getNombreP());
        proy.setDescripcionP(dtoproy.getDescripcionP());
        proy.setImg(dtoproy.getImg());
        
        sProy.save(proy);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"),HttpStatus.OK);
    } 
}
