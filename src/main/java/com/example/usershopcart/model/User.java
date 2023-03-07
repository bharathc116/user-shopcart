package com.example.usershopcart.model;

import com.example.usershopcart.constants.AccountStatus;
import com.example.usershopcart.constants.GenderType;
import com.example.usershopcart.constants.UserRoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.security.auth.message.callback.PasswordValidationCallback;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user_shop")

public class User  {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

     private String name;


    private String email;



    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id",referencedColumnName = "id")
    private Address address;

    private Long phone_number;
@Temporal(TemporalType.DATE)
    private Date dob;
    @Enumerated(EnumType.STRING)
    private GenderType genderType;
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
    @Temporal(TemporalType.TIMESTAMP)
    private  Date accountCreationDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginDate;
    @Enumerated(EnumType.STRING)
 private UserRoleType userRoleType;

    public User(Integer id, String email) {
        this.id=id;
        this.email=email;

    }


    public boolean isPresent() {
        return true;
    }



}
