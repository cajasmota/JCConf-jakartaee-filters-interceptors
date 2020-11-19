package com.cajasmota.jcconf.warehouses;

import com.cajasmota.jcconf.common.auth.Secured;
import com.cajasmota.jcconf.warehouses.request.CreateWarehouseRequest;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Secured
@Path("/warehouses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WarehousesController {

    @Inject
    WarehouseService warehouseService;

    @POST
    public Warehouse create(CreateWarehouseRequest request) {
        return warehouseService.create(request.getName(), request.getAddress());
    }

    @PUT
    @Path("/{id}")
    public Warehouse edit(@PathParam("id") Long id, CreateWarehouseRequest request) {
        return warehouseService.edit(id, request.getName(), request.getAddress());
    }
}
