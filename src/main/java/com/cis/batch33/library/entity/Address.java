package com.cis.batch33.library.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="address")
@Data
public class Address {
    @Id
    private int addressId;
    private String line1;
    private String line2;
    private String city;
    private String state;
    private Integer zip;
    @OneToMany(mappedBy = "address")
    private List<LibraryMember> members;
}
// select * from Address a join library_Member l on a.id=l.address_id
        // where a.address_id = ?


// POJO ENTITY DTO VO BO