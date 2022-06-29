package com.sena.disquera_rc.controller;

import javax.validation.Valid;
//import javax.validation.constraints.Min.List;

import com.sena.disquera_rc.model.Album;
import com.sena.disquera_rc.model.ListarA;
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
@SessionAttributes("album")
@RequestMapping("/album")
public class albumController {

    @Autowired
    private ListarA albumz;
    
    @GetMapping(path={"/listar"})
    public String listar(Model a){
        a.addAttribute("album", albumz.findAll());
        return "album/listar";    
    }

    @GetMapping("/vista")
    public String vista(Model a){
        Album al=new Album();
        al.setId_album(1);
        al.setNombre_album("Ronald");
        //al.setAno_publicacion("2003");
        //al.setId_genero("1");
        al.setEstado_album(false); 
        a.addAttribute("album", al);
        return "album/vista";
    }

    @GetMapping("/ver/{id_album}")
    public String ver(@PathVariable Integer id_album, Model a){
        Album album=null;
        if(id_album>0){
            album=albumz.findOne(id_album);
        }else{
            return "redirect:listar";
        }
        a.addAttribute("album",album);
        a.addAttribute("accion", "Actualizar album");
        return "album/registrar";
    }

    @GetMapping("/registrar")     
    public String registrar(Model a){
        Album album=new Album();
        a.addAttribute("album", album);
        a.addAttribute("accion", "Registrar album");
        return "album/registrar"; 
    }

    @PostMapping("/add")
    public String add(@Valid Album album, BindingResult res, Model a,SessionStatus status){
        if(res.hasErrors()){
        return "album/registrar";
        }
        albumz.save(album);
        status.setComplete();
        return "album/listar";
    }    
    @GetMapping("/delete/{idGenero}")
    public String delete(@PathVariable Integer id_album) {	
		if(id_album> 0) {
			albumz.delete(id_album);
		}
		return "redirect:../listar";
	}
}
