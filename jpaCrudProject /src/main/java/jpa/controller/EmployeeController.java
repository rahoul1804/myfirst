package jpa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import jpa.controllerModelPojo.EmployeePojo;
import jpa.serviceInterface.ServiceInterface;

@Controller
public class EmployeeController {
	
		@Autowired
		ServiceInterface si;
	
		@RequestMapping(value="/SignUpToController" ,method=RequestMethod.POST)
		public ModelAndView signup(@ModelAttribute("employeePojo") EmployeePojo employeePojo)
		{	
			//System.err.println(employeePojo);
			EmployeePojo epCo=si.save(employeePojo);
						
			return new ModelAndView("SaveRegpage","RegKey",epCo);
		}
		
		// ---------------------------- view -----------------------------//
		
				
		@RequestMapping(value="/viewToController")
		public ModelAndView view(@ModelAttribute("employeePojo") EmployeePojo employeePojo)
		{
			Map model=new HashMap();
			List<EmployeePojo> list=si.findEmpAll();
			model.put("list",list);
			return new ModelAndView("View","viewKey",model);
		}
		
		//----------DELETE------------//
		
		@RequestMapping(value = "/deleteEmpRecord/{id}", method = RequestMethod.GET)
		public ModelAndView deleteemployee(@PathVariable int id) 
		{
			si.delete(id);
			return new ModelAndView("redirect:/viewToController");
		}
		
		
		//------------edit--------------//
		
		@RequestMapping(value="/editEmpRequestFromViewPage/{id}",method=RequestMethod.GET)
		public ModelAndView sendToEditPage(@PathVariable int id)
		{
 			EmployeePojo e= si.getEmployeById(id);
 			
			return new ModelAndView("editPage","editkey",e);
			
		}
		
		@RequestMapping(value="/editEmpRequestFromViewPage/editedDetailsrequest" ,method=RequestMethod.POST)
		public ModelAndView editsave(@ModelAttribute("employeePojo") EmployeePojo employeePojo)
		{
			System.err.println("hfjdsgkfb");
			si.editSave(employeePojo);
			return new ModelAndView("redirect:/viewToController");
			
		}
		
		//----------search--------------//
		@RequestMapping(value="/searchByName")
		public ModelAndView searchEmp(@RequestParam("name") String name)
		{
			System.err.println(name);
			List<EmployeePojo> list=si.search(name);
			Map model=new HashMap();
			model.put("list",list);
			return new ModelAndView("View","viewKey",model);		
		}
	
}
