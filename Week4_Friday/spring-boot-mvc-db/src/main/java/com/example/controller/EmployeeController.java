package com.example.controller;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("")
    public String viewHomePage() {
        return "employeeIndex";
    }

    @RequestMapping("/employees")
    public String home(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        return "employees";
    }


    @PostMapping("/saveEmployee")
    public String createEmployee(@ModelAttribute("employee") Employee theEmployee) {
        employeeRepository.save(theEmployee);
        return "redirect:/employees";
    }

    @RequestMapping("/add")
    public String addEmployee(Model model) {
        model.addAttribute("employeeInput", new Employee());
        return "add";
    }

    @RequestMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        //model.addAttribute("deleteId", new Integer());
        //model.getAttribute();
        employeeRepository.deleteById(id); //work
        return "redirect:/employees";
    }


    @RequestMapping("/update/{id}/{salary}")
    public String updateEmployee(@PathVariable("id") Long id, @PathVariable("salary") Float newSalary) {
        Employee employeeFromDb = employeeRepository.findById(id).get();
        employeeFromDb.setEmployeeSalary(newSalary);
        employeeRepository.save(employeeFromDb);

        return "redirect:/employees";
    }




}
