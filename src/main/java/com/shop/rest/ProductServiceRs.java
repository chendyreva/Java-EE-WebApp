package com.shop.rest;

import javax.ejb.Local;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Local
@Path("/v1/product")
public interface ProductServiceRs {

    @PUT
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    void insert(ProductRepr product);

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    void update(ProductRepr product);

    @DELETE
    @Path("/{id}/id")
    void delete(@PathParam("id") long id);

    @GET
    @Path("/{id}/id")
    @Produces(MediaType.APPLICATION_JSON)
    ProductRepr findById(@PathParam("id") long id);

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    List<ProductRepr> findAll();
}
