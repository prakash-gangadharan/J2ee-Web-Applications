package com.rest.examples.javatpoint;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * To Test use below url,  - Postman
 * 
 * http://localhost:8080/messenger/webapi/WebServiceControllerTwo/helloWorld
 * http://localhost:8080/messenger/webapi/WebServiceControllerTwo/helloWorld/Welcome%20to%20Rest%20Example
 * http://localhost:8080/messenger/webapi/WebServiceControllerTwo/1991/08/13
 * http://localhost:8080/messenger/webapi/WebServiceControllerTwo?nameKey=prakash&countryKey=India
 * http://localhost:8080/messenger/webapi/WebServiceControllerTwo/customers;nameKey=prakash;countryKey=India
 * http://localhost:8080/messenger/webapi/WebServiceControllerTwo/query
 * http://localhost:8080/messenger/webapi/WebServiceControllerTwo/Consumes
 * 
 */

@Path("WebServiceControllerTwo")
public class WebServiceControllerTwo {
	
	@GET
	@Path("/helloWorld")
	@Produces(MediaType.TEXT_PLAIN)
	public Response helloWorld(){
		
		return Response
				.status(200)
				.entity("Hello World")
				.build();
	}
	
	/**
	 *  JAX-RS @Path, @GET and @PathParam Annotations 
	 */
	@GET
	@Path("helloWorld/{param}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getMsg(@PathParam("param") String msg) {
		
		String output= "Hello, "+msg;
		
		return Response
				.status(200)
				.entity(output)
				.build();
	}
	
	/**
	 *  JAX-RS Multiple @PathParam Annotation 
	 */
	@GET
	@Path("{year}/{month}/{day}")
	public Response getDate(
			@PathParam("year") int year, 
			@PathParam("month") int month, 
			@PathParam("day") int day) {

		String date = year + "/" + month + "/" + day;

		return Response
				.status(200)
				.entity("getDate is called, year/month/day : " + date)
				.build();
	}
	
	/**
	 *  JAX-RS @QueryParam and @GET Annotation 
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getResultByPassingValue(
			@QueryParam("nameKey") String name,
			@QueryParam("countryKey") String country) {

		String output = "Customer name - " + name + ", Country - " + country+ "";
		return Response
				.status(200)
				.entity(output)
				.build();
	}
	
	/**
	 *  JAX-RS @MatrixParam and @GET Annotation 
	 */	
	@GET
	@Path("/customers")
	@Produces(MediaType.TEXT_HTML)
	public Response getResultByPassingValueMatrx(
			@MatrixParam("nameKey") String name,
			@MatrixParam("countryKey") String country) {

		String output = "Customer name - " + name + ", Country - " + country+ "";
		return Response
				.status(200)
				.entity(output)
				.build();
	}
	
	/**
	 *  JAX-RS @FormParam and @POST Annotation 
	 */
	@POST
	@Path("/add")
	public Response addUser(
			@FormParam("id") int id, 
			@FormParam("name") String name, 
			@FormParam("price") float price) {

		return Response
				.status(200)
				.entity(" Product added successfuly!<br> Id: " + id + 
						"<br> Name: " + name + "<br> Price: " + price)
				.build();
	}
	
	/**
	 *  JAX-RS @HeaderParam and @GET Annotation 
	 *  use CountryController.js
	 */
	 @GET
	 @Path("/query")
	 @Produces(MediaType.TEXT_PLAIN)
	 public Response queryHeaderInfo(
			 @HeaderParam("Cache-Control") String ccControl,
			 @HeaderParam("My-Value") String myValue, 
			 @HeaderParam("My-Header") String myHeader,
			 @HeaderParam("User-Agent") String uaStr){

		 	String resp = "Received http headers are Cache-Control: " + ccControl +
							 "\n User-Agent: " + uaStr +
	                        "\n My-Header: "+ myHeader +
	                        "\n My-Value: "+ myValue;

	        return Response
	        		.status(200)
	        		.entity(resp)
	        		.build();
	    }
	 
		/**
		 *  JAX-RS @Consumes through angularJS 
		 *  use CountryController.js
		 */
	    @POST
	    @Path("/Consumes")
	    @Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public Response getUserById(InputStream inputOrder) {
			StringBuilder sb = new StringBuilder();

			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(inputOrder));
				String line = null;
				while ((line = in.readLine()) != null) {
					sb.append(line);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println(" Data Received : " + sb);
			return Response
					.status(200)
					.entity("Your request processed successfully")
					.build();
		}

}
