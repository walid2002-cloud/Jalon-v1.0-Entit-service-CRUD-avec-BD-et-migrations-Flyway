// Vehicle.java
package com.rdvmedical.serviceuser.domain.entity;
import jakarta.persistence.*;

@Entity
public class Vehicle {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable=false, unique=true, length=20) private String plateNumber;
    @Column(length=40) private String type; // VAN, BIKE, TRUCK
    private Double capacityKg;

    public Long getId(){return id;}
    public String getPlateNumber(){return plateNumber;}
    public void setPlateNumber(String plateNumber){this.plateNumber=plateNumber;}
    public String getType(){return type;}
    public void setType(String type){this.type=type;}
    public Double getCapacityKg(){return capacityKg;}
    public void setCapacityKg(Double capacityKg){this.capacityKg=capacityKg;}
}
