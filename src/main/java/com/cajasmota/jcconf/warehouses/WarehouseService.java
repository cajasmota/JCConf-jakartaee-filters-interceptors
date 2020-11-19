package com.cajasmota.jcconf.warehouses;

import com.cajasmota.jcconf.common.exceptions.WSException;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
public class WarehouseService {

    @PersistenceContext
    EntityManager db;

    public Warehouse create(String name, String address) {
        Warehouse warehouse = new Warehouse();
        warehouse.setName(name);
        warehouse.setAddress(address);

        db.persist(warehouse);
        return warehouse;
    }

    public Warehouse edit(Long id, String name, String address) {
        Warehouse warehouse = db.find(Warehouse.class, id);
        if(warehouse == null){
            throw new WSException("Warehouse not found");
        }

        warehouse.setName(name);
        warehouse.setAddress(address);

        return warehouse;
    }
}
