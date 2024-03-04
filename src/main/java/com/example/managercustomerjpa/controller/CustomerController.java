package com.example.managercustomerjpa.controller;

import com.example.managercustomerjpa.model.Customer;
import com.example.managercustomerjpa.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @GetMapping("")
    public String list (Model model) {
        List<Customer> customerList = iCustomerService.findAll();
        model.addAttribute("customers",customerList);
        return "list";
    }
    @GetMapping("/create")
    public String create (Model model) {
        model.addAttribute("customers",new Customer());
        return "create";
    }
    @PostMapping("/save")
    public String save (Customer customer) {
        iCustomerService.save(customer);
        return "redirect:/customers";
    }
    @GetMapping("/{id}/edit")
    public String edit (@PathVariable Long id,Model model) {
        model.addAttribute("customers",iCustomerService.findById(id));
        return "edit";
    }
    @PostMapping("/edit")
    public String update (Customer customer) {
        iCustomerService.save(customer);
        return "redirect:/customers";
    }
    @GetMapping("/{id}/delete")
    public String delete (@PathVariable Long id,Model model){
        model.addAttribute("customers",iCustomerService.findById(id));
        return "delete";
    }
    @PostMapping("/delete")
    public  String remove (Long id) {
        iCustomerService.remove(id);
        return "redirect:/customers";
    }
    @GetMapping("/{id}/view")
    public String view (@PathVariable Long id, Model model){
        model.addAttribute("customers",iCustomerService.findById(id));
        return "view";
    }
}
