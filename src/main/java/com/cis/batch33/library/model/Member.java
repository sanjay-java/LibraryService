package com.cis.batch33.library.model;

import lombok.Data;

import java.util.List;

@Data
public class Member {

    private long memberId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private Long phoneNumber;
    private String memberShipLevel;
    private AddressDTO address;
    private List<CheckoutDTO> checkouts;
}
// dependencies are correct - pom.xml
// connection properties -
// create entity class and repository
// Autowire in service class and update service methods


// GET , PUT DELETE POST
// book and member

