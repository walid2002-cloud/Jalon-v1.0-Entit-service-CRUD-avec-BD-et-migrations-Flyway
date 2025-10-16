// OrderDTO.java
package com.rdvmedical.serviceuser.domain.dto;
import java.math.BigDecimal; import java.time.LocalDateTime;
public class OrderDTO {
    public Long id; public String orderNumber; public LocalDateTime createdAt; public BigDecimal totalAmount; public String state;
    public Long senderId; public Long recipientId;
}
