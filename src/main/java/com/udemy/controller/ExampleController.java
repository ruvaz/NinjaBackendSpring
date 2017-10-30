package com.udemy.controller;

import com.udemy.component.ExampleComponent;
import com.udemy.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/example")
public class ExampleController {

    public static final String EXAMPLE_VIEW = "example";

    @Autowired   //inyectar algo que esta en su memoria
    @Qualifier("exampleComponent") //nombre del bean ue esta en su memoria

    private ExampleComponent exampleComponent; //lo inyenctan en una variable


    //primer forma
    @GetMapping("/exampleString")
    //@RequestMapping(value = "/exampleString", method = RequestMethod.GET) //Sustituido por get mapping
    public String exampleString(Model model) {

        exampleComponent.sayHello(); //usando el componente inyectado

        //model.addAttribute("name", "John edsde get mappin");
        model.addAttribute("people", getPeople());
        return EXAMPLE_VIEW;
    }

    //segunda forma
    //@RequestMapping(value = "/exampleMAV", method = RequestMethod.GET)

    @GetMapping("/exampleMAV")
    public ModelAndView exampleMAV() {

        ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);

       // mav.addObject("name", "Mikel");  //dato simple

//        mav.addObject("person", new Person("RUBEN",33));  //dato complejo
        mav.addObject("people", getPeople() );  //dato complejo

        return mav;
    }


    @GetMapping("/hello2")
    public String getHello() {
        return "helloworld";
    }


    private List<Person> getPeople(){
        List<Person> people = new ArrayList<>();
        people.add(new Person("Ruben",23));
        people.add(new Person("Clau",33));
        people.add(new Person("Michele",13));
        people.add(new Person("Vazquez",26));
        return people;
    }
}
