package com.udemy.controller;

import com.udemy.model.Person;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/example3")
public class Example3Controller {

    private static final Log LOGGER = LogFactory.getLog(Example3Controller.class);

    public static final String FORM_VIEW = "form";
    public static final String RESULT_VIEW = "result";


    //#1
//    @GetMapping("/")
//    public String redirect(){
//        return "redirect:/example3/showform";
//    }
    //#2
    @GetMapping("/")
    public RedirectView redirect(){
        return new RedirectView("/example3/showform");
    }

    /**
     *
     * @param model
     * @return
     */
    @GetMapping("/showform")
    public String showForm( Model model){
        model.addAttribute("person", new Person());
        return FORM_VIEW;
    }


    /**
     * request POST from form
     * @param person
     * @return
     */
    @PostMapping("/addperson")
    public ModelAndView addPerson(@ModelAttribute("person") Person person){
        LOGGER.info("METHOD: 'addPerson' -- PARAMS: '"+person+"'");
        ModelAndView mav = new ModelAndView(RESULT_VIEW);
        mav.addObject("person",person);
        LOGGER.info("TEMPLATE: '"+RESULT_VIEW+"' --DATA: '"+person+"'");
        return mav;
    }
}
