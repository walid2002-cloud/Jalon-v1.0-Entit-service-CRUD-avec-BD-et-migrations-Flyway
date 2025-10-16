// PackageParcel.java
package com.rdvmedical.serviceuser.domain.entity;
import jakarta.persistence.*;

@Entity
@Table(name="package_parcel")
public class PackageParcel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable=false, unique=true, length=40) private String code;
    private Double weightKg;
    private String dimensions; // "30x20x15"
    private Boolean fragile = false;

    @ManyToOne(optional=false) private Order orderRef;

    public Long getId(){return id;}
    public String getCode(){return code;}
    public void setCode(String code){this.code=code;}
    public Double getWeightKg(){return weightKg;}
    public void setWeightKg(Double weightKg){this.weightKg=weightKg;}
    public String getDimensions(){return dimensions;}
    public void setDimensions(String dimensions){this.dimensions=dimensions;}
    public Boolean getFragile(){return fragile;}
    public void setFragile(Boolean fragile){this.fragile=fragile;}
    public Order getOrderRef(){return orderRef;}
    public void setOrderRef(Order orderRef){this.orderRef=orderRef;}
}
