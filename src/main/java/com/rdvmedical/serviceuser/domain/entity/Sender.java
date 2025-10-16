// Sender.java
package com.rdvmedical.serviceuser.domain.entity;
import jakarta.persistence.*;

@Entity
public class Sender {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable=false, length=100) private String name;
    @Column(length=120, unique=true) private String email;
    @Column(length=30) private String phone;
    @Column(length=255) private String address;

    public Long getId(){return id;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}
    public String getPhone(){return phone;}
    public void setPhone(String phone){this.phone=phone;}
    public String getAddress(){return address;}
    public void setAddress(String address){this.address=address;}
}
