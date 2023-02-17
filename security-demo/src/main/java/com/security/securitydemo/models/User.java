package com.security.securitydemo.models;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_tbl")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Cacheable
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String userName;
    private String password;
    private String email;
    @OneToOne
    private Address address;

}
