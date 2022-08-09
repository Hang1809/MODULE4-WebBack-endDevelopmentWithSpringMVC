package com.cg.controller;

import com.cg.model.Customer;
import com.cg.service.HibernateCustomerService;
import com.cg.service.IGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customers")
//RequestMapping: hỗ trợ cho class
public class CustomerController {

    @Autowired
    private HibernateCustomerService hibernateCustomerService;

    @GetMapping()
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/list");
        List<Customer> customerList = hibernateCustomerService.findAll();
        modelAndView.addObject("customers",customerList );
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView showCustomerByIdPage(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/info");

        Customer customer = hibernateCustomerService.findOne(id);
        modelAndView.addObject("customer",customer);


        return modelAndView;
    }


    @GetMapping("/create")
    public ModelAndView showCreatePage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/create");

        Customer customer = new Customer();
        modelAndView.addObject("customer",customer);

        return modelAndView;
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute Customer customer){

        hibernateCustomerService.save(customer);

        return "redirect:/customers";
    }
    @PostMapping("/{id}")
//    binding data : nhan gia tri model map view
    public String doUpdate (@PathVariable Long id, @ModelAttribute Customer customer){

        hibernateCustomerService.save(customer);
       return "redirect:/customers";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/delete");

        Customer customer = hibernateCustomerService.findOne(id);
        modelAndView.addObject("customer",customer);

        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id, @ModelAttribute Customer customer) {
        hibernateCustomerService.delete(customer);
        return "redirect:/customers";
    }
}
