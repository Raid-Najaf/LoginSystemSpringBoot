package com.webshop.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    @Email(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$", message = "Must be a valid email address!!")
    private String email;

    @Column(length = 100)
    @NotBlank(message = "Must enter Password !!")
    @Size(min = 6, message = "Password must be between 6-12 characters !!")
    private String password;

    @NotBlank(message = "Must enter Address !!")
    private String address;

    private String adress2;

    @NotBlank(message = "Must enter City !!")
    private String city;

    @NotBlank(message = "Must select a State !!")
    private String state;

    @NotBlank(message = "Must enter ZipCode !!")
    private String zipCode;

    @AssertTrue(message = "Must accept terms and conditions !!")
    private boolean agreed;

    private String role;

}
