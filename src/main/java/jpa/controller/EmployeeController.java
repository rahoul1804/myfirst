package jpa.controller;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

import jpa.ajax.component.CountryPojo;
import jpa.ajax.component.StatePojo;
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
		
//				
		@RequestMapping(value="/viewToController")
		public ModelAndView view()
		{
			List<EmployeePojo> list=si.findEmpAll();
			
			int cont=list.size()/3;
			ModelAndView m=new ModelAndView("View");
			m.addObject("cont", cont);
			m.addObject("list", list);
			return m;
			//return new ModelAndView("View","list",list);
			
		}
//		
		
		
		 
		
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
		//byName//
		@RequestMapping(value="/searchByName")
		public ModelAndView searchEmp(@RequestParam("name") String name/*,BindingResult result*/)
		{
			/*if(result.hasErrors())
			{
				String msg="hellll";
				return new ModelAndView("index" ,"key",msg);	
			}
			else*/
			System.err.println(name);
			List<EmployeePojo> list=si.searchEmpByNameService(name);
			Map model=new HashMap();
			model.put("list",list);
			return new ModelAndView("View","list",list);		
		}
		//byId//
				@RequestMapping(value="/searchById")
				public ModelAndView searchEmpID(@RequestParam("id") int id)
				{
					System.err.println(id);
					List<EmployeePojo> list=si.searchEmpByIdService(id);
					System.err.println("after serv");
					Map model=new HashMap();
					model.put("list",list);
					System.err.println(model);
					return new ModelAndView("View","list",list);		
				}
	          //search by id and name//
				@RequestMapping(value="/searchByIdAndName")
				public ModelAndView searchEmpID(@RequestParam("id") int i,@RequestParam("name") String s)
				{
					//System.err.println(id);
					List<EmployeePojo> list=si.searchEmpByIdAndNameService(i, s);
					System.err.println("after serv");
					Map model=new HashMap();
					model.put("list",list);
					System.err.println(model);
					return new ModelAndView("View","list",list);		
				}
				
			//search MErge Id Name//
				 //search by id and name//
				/*@RequestMapping(value="/searchByIdAndNameMerge")
				public ModelAndView searchEmpIDMerge(@RequestParam("id") String i ,@RequestParam("name") String s)
				{
					//System.err.println(id);
					List<EmployeePojo> list=si.searchEmpMergeService(i, s);
					System.err.println("after serv");
					Map model=new HashMap();
					model.put("list",list);
					System.err.println(model);
					return new ModelAndView("View","viewKey",model);		
				}
				*/
				/*@RequestMapping(value="/search")
				public ModelAndView login(@RequestParam("name") String s,@RequestParam("branch") String s1)
				{
					
					System.err.println(s);
					System.err.println(s1);
					List<Student> list=ser.search(s,s1);
					Map model=new HashMap();
					model.put("list",list);
					return new ModelAndView("viewstu","model",model);
					
						
				}*/
		
		//---------------login----------------//
		
		@RequestMapping("/loginToController")
		public ModelAndView getEmployeeDetails(HttpServletRequest request,HttpServletResponse response,EmployeePojo student ) 
		{
			
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		{
		List<EmployeePojo> list=si.findEmpAll();
		
		//EmployeePojo list1=si.getEmployeeById(id);
		
		ModelAndView mv=new ModelAndView();
		Map model=new HashMap();
		
		
		Iterator<EmployeePojo> it=list.iterator();
		while(it.hasNext()) 
		{
			EmployeePojo em=it.next();
			
			if((em.getName().equals(name))&&(em.getPassword().equals(password)))
		 	  {
				model.put("id", em.getId());
				model.put("name", em.getName());
				model.put("age", em.getAge());
				model.put("country",em.getCountry());
				model.put("password",em.getPassword());
				model.put("state",em.getState());
								
				mv.addObject("model",model);
				mv.setViewName("loginResultPage");
				return mv;
		         }
	        }
		  {
			System.err.println("outside");

			   request.setAttribute("error","Invalid Username and Password");
				return new ModelAndView("index");
			}
		

		}
	   }
		
		
		
		//-------pagination-----
		@RequestMapping(value="/viewToController/{pageid}")  
	    public ModelAndView view(@PathVariable int pageid ,@ModelAttribute("employeePojo") EmployeePojo employeePojo)
	    {  
			//-------next -prev------//
			int p=pageid-1;
			   if(p==0)
			   {
				   p = p+1;
			   }
			 //-------end next -prev------//
			   int  n = pageid+1;
			
	        int total=3;  
	        if(pageid==1)
	        { }  
	        else
	        {  
	            pageid=(pageid-1)*total+1;  
	        }
	       // DaoImplimenatation d=new DaoImplimenatation();
	        
	        List<EmployeePojo> list=si.getEmpByPage(pageid, total);
	       List<EmployeePojo> listFindAll=si.findEmpAll();
	          //----forloop 123----/
	        int cnt=listFindAll.size()/3;
	        //---- end forloop 123----/
			ModelAndView m=new ModelAndView("ViewPagination");
			m.addObject("cnt", cnt);
			m.addObject("list", list);
			m.addObject("pre",p);
			m.addObject("nxt", n);
			return m;
	        
	        // List<EmployeePojo> list=d.getEmployeesByPage(pageid,total);  
	          
	      //  return new ModelAndView("View","list",list);
	    }  
		
		
		//------------ Country And State ajax __-----//

		@ResponseBody
		@RequestMapping(value ="/getCountryData",  method = RequestMethod.GET)
		public String ajaxmethod(HttpServletRequest request,HttpServletResponse response) throws JsonProcessingException
		{
			System.err.println("inside ajax");
			
			String s=request.getParameter("cid");
			
			System.out.println(s);
			
			System.out.println("service");
			
			Gson gson=new Gson();
			
			System.out.println("gasonnn");

			 List<StatePojo> smw=si.getAllstates(s);
			 
			 System.out.println(smw);
			 
			 
			return gson.toJson(smw);
			
		}
		
		//==================  registerpage request AT same time country loaded======================
		
		@RequestMapping("/regPageRequst")
		public ModelAndView showform() 
		{
			 List<CountryPojo> model= si.getAllCountries();
			 ModelAndView mav=new ModelAndView("regPage");
			   mav.addObject("model", model);
			   mav.addObject("command", new EmployeePojo());
			   return mav;
		//return new ModelAndView("register", "model", new Student());
		}	
		
		
		//============== Excel Sheet ===================
		@RequestMapping("/downloadExcelSheet")
		public ModelAndView excelCreator()
		{
			System.err.println("Excellllllll");
			
			List<EmployeePojo> list = si.findEmpAll();

			try {
				XSSFWorkbook workbook = new XSSFWorkbook();

				XSSFSheet sheet = workbook.createSheet("Empsheet");
				
				String[] headers = { "id", "age", "country", "name", "password", "state", "date"};

				int rownum = 0;
				for (EmployeePojo emp : list) 
				{
					//---for printing headers----//
					if (rownum == 0) 
					{
						Row header = sheet.createRow(0);
						for (int i = 0; i < headers.length; i++)
						{
							header.createCell(i).setCellValue(headers[i]);

						}

						//-----end header------//
					}
					Row row = sheet.createRow(++rownum);
					createList(emp, row);
					
					int noOfrows=list.size();

				}
				//-------dynamic path----//
				 
				//-------------------------//
				
				FileOutputStream out = new FileOutputStream("/home/rahul/Desktop/EmployeeExcelList.xlsx"); 
				workbook.write(out);
				out.close();

			} 
			catch (Exception e) {
				
				e.printStackTrace();
			}

			return new ModelAndView("ExcellSuccess", "success", "DownloadedSuccessFully");

		}

		private static void createList(EmployeePojo cust, Row row) 
		{
			Cell cell = row.createCell(0);
			cell.setCellValue(cust.getId());

			cell = row.createCell(1);
			cell.setCellValue(cust.getAge());
			
			cell = row.createCell(2);
			cell.setCellValue(cust.getCountry());
			
			cell = row.createCell(3);
			cell.setCellValue(cust.getName());
			
			cell = row.createCell(4);
			cell.setCellValue(cust.getPassword());
			
			cell = row.createCell(5);
			//cell.setCellValue("state");
			cell.setCellValue(cust.getDate());
								
			cell = row.createCell(8);
			//cell.setCellValue("date");
			cell.setCellValue(cust.getDate());
			
			
		}
		
		
		//----------name Ajax--------------//
		@ResponseBody
		@RequestMapping(value="/nameSearchfromDb" , method = RequestMethod.GET)
		public String nameSearchMethod(HttpServletRequest request,HttpServletResponse response) throws JsonProcessingException
		{
            System.err.println("inside ajax");
			
			String s=request.getParameter("name");
			System.out.println(s);
			
			if(s.equals(""))
			{
				
				return "";
			}
			else 
			{
				
		
			List<EmployeePojo> list=si.searchEmpByNameService(s);
			
		if(list.isEmpty())
		{
			
			return "name Available";
		}
		
			return "name not available";
		}
		
		}
		
		
		
		
}
