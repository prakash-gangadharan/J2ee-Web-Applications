package com.springmvc.example.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.example.beans.Emp;

@Controller
public class EmpController {
	
    @RequestMapping("/empform")  
    public ModelAndView showform(){  
        //command is a reserved request attribute name, now use <form> tag to show object data  
        return new ModelAndView("empform","command",new Emp());  
    }
	
	@RequestMapping(value="/save",method = RequestMethod.POST)  
	public ModelAndView save(@ModelAttribute("emp") Emp emp){
		
		// write code to save emp object  
        //here, we are displaying emp object to prove emp has data  
        System.out.println(emp.getName()+" "+emp.getSalary()+" "+emp.getDesignation());  
		
		System.out.println(emp);
		
		return new ModelAndView("redirect:/viewemp");//will redirect to viewemp request mapping  
		
	}
	
    @RequestMapping("/viewemp")  
    public ModelAndView viewemp(){  
        //write the code to get all employees from DAO  
        //here, we are writing manual code of list for easy understanding  
        List<Emp> list=new ArrayList<Emp>();  
        list.add(new Emp(1,"rahul",35000f,"S.Engineer"));  
        list.add(new Emp(2,"aditya",25000f,"IT Manager"));  
        list.add(new Emp(3,"sachin",55000f,"Care Taker"));  
          
        return new ModelAndView("viewemp","list",list);
    }
    
    /**
     *  It displays object data into form for the given id.
     *  The @PathVariable puts URL data into variable.
     * 
     * @param id
     * @return
     */
    @RequestMapping(value="/editemp/{id}")  
    public ModelAndView edit(@PathVariable int id){  
        Emp emp=new Emp(1,"rahul",35000f,"S.Engineer");
        
        return new ModelAndView("empeditform","command",emp);  
    }
    
    /**
     * It updates model object. 
     * 
     * @param emp
     * @return
     */
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public ModelAndView editsave(@ModelAttribute("emp") Emp emp){
    	
        return new ModelAndView("redirect:/viewemp");  
    }
    
    /**
     *  It deletes record for the given id in URL and redirects to /viewemp
     * 
     * @param id
     * @return
     */
    @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)  
    public ModelAndView delete(@PathVariable int id){
    	
        return new ModelAndView("redirect:/viewemp");  
    }  

}