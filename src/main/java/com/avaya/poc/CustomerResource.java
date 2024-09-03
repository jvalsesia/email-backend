package com.avaya.poc;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

import org.jboss.logging.Logger;

@Path("/api/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {
    private static final Logger LOGGER = Logger.getLogger(CustomerResource.class.getName());
    private final CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GET
    public List<Customer> getAllCustomers() {
        return customerService.getAll();
    }

    @POST
    public Response createCustomer(Customer customer) {
        Customer savedCustomer = customerService.create(customer);
        LOGGER.info("Customer created: " + savedCustomer.id);
        return Response.status(Response.Status.CREATED).entity(savedCustomer).build();
    }
}