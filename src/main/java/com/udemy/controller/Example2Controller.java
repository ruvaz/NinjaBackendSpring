package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example2")
public class Example2Controller {

    public static final String EXAMPLE2_VIEW = "example2";

    //Peticion GET
    //localhost:8080/example2/request1?nm=NOMBRE
    @GetMapping("/request1")   //recibe parametro nm por GET   sin ser requeri nm
    public ModelAndView request1(@RequestParam(name = "nm", required = false, defaultValue = "NULL") String name) {

        ModelAndView mav = new ModelAndView(EXAMPLE2_VIEW);//Crea el Model y la VIEW

        mav.addObject("nm_in_model", name); //Mete valores al ModelAndView
        return mav;
    }


    //Otra peticion GET  /  parametros en el PATH
    //localhost:8080/example2/request2/RUBEN
    @GetMapping("/request2/{nm}")
    public ModelAndView request2(@PathVariable("nm") String name){  // pasa a name el valor GET

        ModelAndView mav = new ModelAndView(EXAMPLE2_VIEW);

        mav.addObject("nm_in_model",name);

        return mav;


    }

}
