package com.sena.disquera_rc.controller;

import javax.validation.Valid;
import com.sena.disquera_rc.model.Cancion;
import com.sena.disquera_rc.service.ListarCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;



@Controller
@SessionAttributes("cancion")
@RequestMapping("/cancion")
public class cancionController {

    @Autowired
    private ListarCService cancionz;
    
    @GetMapping(path={"/listar"})
    public String listar(Model c){
        c.addAttribute("canciones", cancionz.findAll());
        return "cancion/listar";    
    }

    @GetMapping("/ver/{id_cancion}")
    public String ver(@PathVariable Integer id_cancion,Model c){
        Cancion cancion=null;
        if(id_cancion>0){
            cancion=cancionz.findOne(id_cancion);
        }else{
            return "redirect:listar";
        }
        c.addAttribute("cancion",cancion);
        c.addAttribute("accion", "Actualizar Cancion");
        return "cancion/registrar";
    }

    @GetMapping("/registrar")     
    public String form(Model c){
        Cancion cancion=new Cancion();
        c.addAttribute("cancion", cancion);
        c.addAttribute("accion", "Agregar Cancion");
        return "cancion/registrar"; 
    }

    @PostMapping("/add")
    public String add(@Valid Cancion cancion,BindingResult res, Model c, SessionStatus status){
        if(res.hasErrors()){
            return "cancion/registrar";
        }
        cancionz.save(cancion);
        status.setComplete();
        return "redirect:listar";
    }    
    @GetMapping("/delete/{id_cancion}")
    public String delete(@PathVariable Integer id_cancion) {
		
		if(id_cancion > 0) {
			cancionz.delete(id_cancion);
		}
		return "redirect:listar";
	}
}
