package com.codegym.currency_converter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ConverterController {

    @GetMapping("/converter")
    public ModelAndView converter(Model model){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView ;
    }
    @PostMapping("/converter")
    public ModelAndView converter(HttpServletRequest request,Model model){
        ModelAndView modelAndView = new ModelAndView("index");
        float rate= Float.parseFloat(request.getParameter("rate"));
        float usd = Float.parseFloat(request.getParameter("usd"));
        float vnd = rate * usd ;
        model.addAttribute("rRate",rate);
        model.addAttribute("rUSD",usd);
        model.addAttribute("rVND",vnd);
        return modelAndView ;
    }
}
