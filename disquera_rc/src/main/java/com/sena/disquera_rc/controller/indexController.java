package com.sena.disquera_rc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
   public class indexController{
       @RequestMapping(value="/Index", method=RequestMethod.GET)
       public String index() {
           return "index";
       }
       
    }