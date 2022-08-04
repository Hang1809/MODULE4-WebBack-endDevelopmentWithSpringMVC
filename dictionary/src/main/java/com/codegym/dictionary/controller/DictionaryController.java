package com.codegym.dictionary.controller;

import com.sun.org.apache.xml.internal.serialize.EncodingInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @GetMapping("/dictionary")
    public ModelAndView dictionary(Model model) {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @PostMapping("/dictionary")
    public ModelAndView dictionary(HttpServletRequest request, Model model) {
        ModelAndView modelAndView = new ModelAndView("index");
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "xin chào");
        dictionary.put("how", "thế nào");
        dictionary.put("book", "quyển sách");
        dictionary.put("computer", "máy tính");

        String search = request.getParameter("txtSearch");
        String result = dictionary.get(search);
        if (result != null) {
            model.addAttribute("Word", search);
            model.addAttribute("Result",result);
        } else {
            model.addAttribute("Notfound","not found");
        }
        return modelAndView;
    }
}


