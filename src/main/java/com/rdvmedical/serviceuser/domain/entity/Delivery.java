// Delivery.java
package com.rdvmedical.serviceuser.domain.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Delivery {
    public enum DeliveryStatus { ASSIGNED, IN_PROGRESS, ATTEMPTED, DELIVERED, FAILED }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private LocalDateTime scheduledAt;
    private LocalDateTime deliveredAt;
    @Enumerated(EnumType.STRING) @Column(length=20, nullable=false)
    private DeliveryStatus status = DeliveryStatus.ASSIGNED;

    @ManyToOne(optional=false) private Order orderRef;
    @ManyToOne(optional=false) private Driver driver;
    @ManyToOne(optional=false) private Vehicle vehicle;

    public Long getId(){return id;}
    public LocalDateTime getScheduledAt(){return scheduledAt;}
    public void setScheduledAt(LocalDateTime scheduledAt){this.scheduledAt=scheduledAt;}
    public LocalDateTime getDeliveredAt(){return deliveredAt;}
    public void setDeliveredAt(LocalDateTime deliveredAt){this.deliveredAt=deliveredAt;}
    public DeliveryStatus getStatus(){return status;}
    public void setStatus(DeliveryStatus status){this.status=status;}
    public Order getOrderRef(){return orderRef;}
    public void setOrderRef(Order orderRef){this.orderRef=orderRef;}
    public Driver getDriver(){return driver;}
    public void setDriver(Driver driver){this.driver=driver;}
    public Vehicle getVehicle(){return vehicle;}
    public void setVehicle(Vehicle vehicle){this.vehicle=vehicle;}
}
