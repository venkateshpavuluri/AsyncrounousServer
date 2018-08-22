package com.asynch.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

@Path("/tax")
public class TaxReturnService {
	@GET
	@Path("/async/{taxseetno}")
	@Produces(MediaType.TEXT_PLAIN)
	public void  taxFilling(@PathParam("taxseetno")String taxseetno,@Suspended AsyncResponse asyncResponse ) {
	//	AsyncResponse asyncResponse=request.get
		 String respose=null;
		new Thread() {
			public void run()
			{
				System.out.println("Thread started");
				try {
					Thread.sleep(8000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread ended");
				asyncResponse.resume(Response.ok().entity("Asyncronus response").build());
				
				//respose= "tyhread based asyncronous response";
			}
		}.start();
		
		
		
		
	}

}
