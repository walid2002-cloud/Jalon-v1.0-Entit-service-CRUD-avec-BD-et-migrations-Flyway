// Driver.java
package com.rdvmedical.serviceuser.domain.entity;
import jakarta.persistence.*;

@Entity
public class Driver {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable=false, length=100) private String name;
    @Column(length=30, unique=true) private String licenseNumber;

    public Long getId(){return id;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public String getLicenseNumber(){return licenseNumber;}
    public void setLicenseNumber(String licenseNumber){this.licenseNumber=licenseNumber;}
}

