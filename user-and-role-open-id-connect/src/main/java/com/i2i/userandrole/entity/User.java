package com.i2i.userandrole.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.repository.Query;

@Data
@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name="User.name",query="select u from User u where u.name = :name")
})
public class User extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    private String name;

}
