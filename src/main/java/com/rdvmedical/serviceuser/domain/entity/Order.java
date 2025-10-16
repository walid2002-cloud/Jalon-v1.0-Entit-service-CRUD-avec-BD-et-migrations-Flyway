// Order.java
package com.rdvmedical.serviceuser.domain.entity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="orders")
public class Order {
    public enum OrderState { CREATED, PAID, SHIPPED, DELIVERED }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable=false, unique=true, length=40) private String orderNumber;
    @Column(nullable=false) private LocalDateTime createdAt = LocalDateTime.now();
    @Column(precision=12, scale=2) private BigDecimal totalAmount;
    @Enumerated(EnumType.STRING) @Column(length=20, nullable=false)
    private OrderState state = OrderState.CREATED;

    @ManyToOne(optional=false) private Sender sender;
    @ManyToOne(optional=false) private Recipient recipient;

    public Long getId(){return id;}
    public String getOrderNumber(){return orderNumber;}
    public void setOrderNumber(String orderNumber){this.orderNumber=orderNumber;}
    public LocalDateTime getCreatedAt(){return createdAt;}
    public BigDecimal getTotalAmount(){return totalAmount;}
    public void setTotalAmount(BigDecimal totalAmount){this.totalAmount=totalAmount;}
    public OrderState getState(){return state;}
    public void setState(OrderState state){this.state=state;}
    public Sender getSender(){return sender;}
    public void setSender(Sender sender){this.sender=sender;}
    public Recipient getRecipient(){return recipient;}
    public void setRecipient(Recipient recipient){this.recipient=recipient;}
}
