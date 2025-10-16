// DeliveryDTO.java
package com.rdvmedical.serviceuser.domain.dto;
import java.time.LocalDateTime;
public class DeliveryDTO {
    public Long id; public String status; public LocalDateTime scheduledAt; public LocalDateTime deliveredAt;
    public Long orderId; public Long driverId; public Long vehicleId;
}
