package com.sena.disquera_rc.controller;

import javax.validation.Valid;
import com.sena.disquera_rc.model.Genero;
import com.sena.disquera_rc.model.ListarG;
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
@SessionAttributes("genero")
@RequestMapping("/genero")
public class generoController {

    @Autowired
    private ListarG generoz;
    
    @GetMapping(path={"/listar",""})
    public String listar(Model g){
        g.addAttribute("generos", generoz.findAll());
        return "genero/listar";    
    }

    @GetMapping("/ver/{id_genero}")
    public String ver(@PathVariable Integer id_genero, Model g){
        Genero genero=null;
        if(id_genero>0){
            genero=generoz.findOne(id_genero);
        }else{
            return "redirect:listar";
        }
        g.addAttribute("genero",genero);
        g.addAttribute("accion", "Actualizar genero");
        return "genero/registrar";
    }

    @GetMapping("/registrar")     
    public String registrar(Model g){
        Genero genero=new Genero();
        g.addAttribute("genero", genero);
        g.addAttribute("accion", "Registrar genero");
        return "genero/registrar"; 
    }

    @PostMapping("/add")
    public String add(@Valid Genero genero,BindingResult res, Model g,SessionStatus status){
        if(res.hasErrors()){
        return "genero/registrar";
        }
        generoz.save(genero);
        status.setComplete();
        return "genero/listar";
    }    
    @GetMapping("/delete/{id_genero}")
    public String delete(@PathVariable Integer id_genero) {	
		if(id_genero > 0) {
			generoz.delete(id_genero);
		}
		return "redirect:../listar";
	}
}
