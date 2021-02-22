package com.javastudio.tutorial.resource;

import com.javastudio.tutorial.api.dto.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/1")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {
    private Logger logger = LoggerFactory.getLogger(ProductResource.class);

    @GET
    public Response hello() {
        Product product = new Product();
        product.setName("Hossein");
        return Response.ok().entity(product).build();
    }

}
