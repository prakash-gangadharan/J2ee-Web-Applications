package com.rest.examples.javatpoint;

import static com.rest.examples.constants.Constants.employees;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.examples.bean.Employee;
import com.rest.examples.bean.Order;

/**
 * To Test use below url
 * 
 * http://localhost:8080/messenger/webapi/WebServiceControllerOne/helloWorld
 * http://localhost:8080/messenger/webapi/WebServiceControllerOne/hello/Welcome%20to%20Rest%20Example
 * http://localhost:8080/messenger/webapi/WebServiceControllerOne/employees
 * http://localhost:8080/messenger/webapi/WebServiceControllerOne/employee/11111
 * http://localhost:8080/messenger/webapi/WebServiceControllerOne/json/employees/
 * http://localhost:8080/messenger/webapi/WebServiceControllerOne/json/employee/11111
 * 
 * http://localhost:8081/messenger/webapi/WebServiceControllerOne/order
 *
 *		 {"customer":"prakash",
		  "address":"new street",
		  "amount":"200"}
		  
 * http://localhost:8081/messenger/webapi/WebServiceControllerOne/order/121
 */

@Path("/WebServiceControllerOne")
public class WebServiceControllerOne {
	
	@GET
	@Path("/helloWorld")
	@Produces(MediaType.TEXT_PLAIN)
	public String helloWorld(){
		return "Hello word, This is rest example.";
		
	}
	
	@GET
	@Path("/hello/{message}")
	@Produces(MediaType.TEXT_PLAIN)
	public String ShowMessage(@PathParam("message") String msg){
		return msg;
		
	}
	
	@GET
	@Path("/employees")
	@Produces(MediaType.APPLICATION_XML)
	public List<Employee> listEmployees(){
		return new ArrayList<Employee>(employees.values());
		
	}
	
	@GET
	@Path("/employee/{employeeID}")
	@Produces(MediaType.APPLICATION_XML)
	public Employee getEmployee(@PathParam("employeeID") String employeeID){
		 return employees.get(employeeID); 
	}
	
    @GET
    @Path("/json/employees/")
    /*@Produces("application/xml,application/json")*/
    @Produces(MediaType.APPLICATION_JSON+","+MediaType.APPLICATION_XML)
    public List<Employee> listEmployeesJSON(){
        return new ArrayList<Employee>(employees.values());
    }
    
    @GET
    @Path("/json/employee/{employeeID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployeeJSON(@PathParam("employeeID")String employeeId){
        return employees.get(employeeId);        
    }
    
    @POST
    @Path("/order")
    @Consumes(MediaType.APPLICATION_JSON)
    public String getUserById(Order inputOrder){
         
        System.out.println("Received order from :"+inputOrder.getCustomer());
        System.out.println("Order worth: "+inputOrder.getAmount());
        System.out.println("Customer address: "+inputOrder.getAddress());
         
        return "Your order is in-progress";
    }
    
    @GET
    @Path("/order/{orderNo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Order produceCountryDetailsinJSON(@PathParam("orderNo") String orderNo) {
 
        /*
         * PASSING orderNo AS AN INPUT, SO WRITE SOME BACKEND RELATED STUFF AND
         * FIND THE orderNo DETAILS WITH THAT ID. AND FINALLY SET THOSE RETRIEVED VALUES TO
         * THE Country OBJECT AND RETURN IT, HOWEVER IT WILL RETURN IN JSON FORMAT :-)
         * */
        
    	Order order = new Order();
    	
    	order.setCustomer("Prakash");
    	order.setAddress("New Street");
    	order.setAmount(orderNo);
    	
        return order;
    }
}
