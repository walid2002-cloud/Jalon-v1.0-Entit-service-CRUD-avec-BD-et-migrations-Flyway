package com.rdvmedical.serviceuser.service.impl;

import com.rdvmedical.serviceuser.domain.dto.OrderDTO;
import com.rdvmedical.serviceuser.domain.entity.*;
import com.rdvmedical.serviceuser.repository.*;
import com.rdvmedical.serviceuser.service.IOrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements IOrderService {
    private final OrderRepository orderRepo;
    private final SenderRepository senderRepo;
    private final RecipientRepository recipientRepo;

    public OrderServiceImpl(OrderRepository orderRepo, SenderRepository senderRepo, RecipientRepository recipientRepo){
        this.orderRepo=orderRepo; this.senderRepo=senderRepo; this.recipientRepo=recipientRepo;
    }

    private OrderDTO toDTO(Order e){
        OrderDTO d = new OrderDTO();
        d.id=e.getId(); d.orderNumber=e.getOrderNumber(); d.createdAt=e.getCreatedAt();
        d.totalAmount=e.getTotalAmount(); d.state=e.getState().name();
        d.senderId = e.getSender()!=null ? e.getSender().getId() : null;
        d.recipientId = e.getRecipient()!=null ? e.getRecipient().getId() : null;
        return d;
    }

    @Override public List<OrderDTO> findAll(){ return orderRepo.findAll().stream().map(this::toDTO).collect(Collectors.toList()); }
    @Override public OrderDTO findById(Long id){ return orderRepo.findById(id).map(this::toDTO).orElse(null); }

    @Override public OrderDTO create(OrderDTO dto){
        Order o = new Order();
        o.setOrderNumber(dto.orderNumber);
        if(dto.state!=null) o.setState(Order.OrderState.valueOf(dto.state));
        if(dto.senderId!=null) o.setSender(senderRepo.findById(dto.senderId).orElseThrow());
        if(dto.recipientId!=null) o.setRecipient(recipientRepo.findById(dto.recipientId).orElseThrow());
        if(dto.totalAmount!=null) o.setTotalAmount(dto.totalAmount);
        return toDTO(orderRepo.save(o));
    }

    @Override public OrderDTO update(Long id, OrderDTO dto){
        return orderRepo.findById(id).map(o -> {
            if(dto.orderNumber!=null) o.setOrderNumber(dto.orderNumber);
            if(dto.state!=null) o.setState(Order.OrderState.valueOf(dto.state));
            if(dto.senderId!=null) o.setSender(senderRepo.findById(dto.senderId).orElseThrow());
            if(dto.recipientId!=null) o.setRecipient(recipientRepo.findById(dto.recipientId).orElseThrow());
            if(dto.totalAmount!=null) o.setTotalAmount(dto.totalAmount);
            return toDTO(orderRepo.save(o));
        }).orElse(null);
    }

    @Override public void delete(Long id){ orderRepo.deleteById(id); }
}
