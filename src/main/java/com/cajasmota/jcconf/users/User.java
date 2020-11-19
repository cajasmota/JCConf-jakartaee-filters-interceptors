package com.cajasmota.jcconf.users;

import com.cajasmota.jcconf.common.db.BaseModel;
import lombok.Data;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name = "All Users",
                query = "SELECT u FROM User u"
        ),
        @NamedQuery(
                name = "User by Email",
                query = "SELECT u FROM User u WHERE u.email=:email"
        )
})

@Data
@Entity
@Table(name = "user")
public class User extends BaseModel {

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

}
