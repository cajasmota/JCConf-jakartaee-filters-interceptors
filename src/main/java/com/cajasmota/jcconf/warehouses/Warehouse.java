package com.cajasmota.jcconf.warehouses;


import com.cajasmota.jcconf.common.db.BaseModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "warehouse")
public class Warehouse extends BaseModel {

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

}
