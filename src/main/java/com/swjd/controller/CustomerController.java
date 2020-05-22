package com.swjd.controller;

import com.swjd.pojo.Customer;
import com.swjd.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cc")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping("toMain")
    public String toMain(Model model){
        List<Customer> list = new ArrayList<>();
        list = customerService.getList();
        model.addAttribute("list",list);
        model.addAttribute("customer",new Customer());
        return "main";
    }

}
