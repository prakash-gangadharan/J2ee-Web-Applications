package com.vogella.jersey.first;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class TestRESTJerseyClient {

	public static void main(String[] args) {
		
		TestRESTJerseyClient obRESTJerseyClient = new TestRESTJerseyClient();
		
		obRESTJerseyClient.getFtoCResponse();
		obRESTJerseyClient.getCtoFResponse();

	}

	private void getFtoCResponse() {
		try {
 
			Client client = Client.create();
			WebResource webResource2 = client.resource("http://localhost:8083/REST-JAX-RS-Jersey/rest/ftocservice/98");
			ClientResponse response2 = webResource2.accept("application/json").get(ClientResponse.class);
			if (response2.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response2.getStatus());
			}
 
			String output2 = response2.getEntity(String.class);
			System.out.println("\n============getFtoCResponse============");
			System.out.println(output2);
 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void getCtoFResponse() {
		try {
 
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8083/REST-JAX-RS-Jersey/rest/ctofservice/35");
			ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class);
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}
 
			String output = response.getEntity(String.class);
			System.out.println("============getCtoFResponse============");
			System.out.println(output);
 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
