package com.rdvmedical.serviceuser.service.impl;

import com.rdvmedical.serviceuser.domain.dto.SenderDTO;
import com.rdvmedical.serviceuser.domain.entity.Sender;
import com.rdvmedical.serviceuser.repository.SenderRepository;
import com.rdvmedical.serviceuser.service.ISenderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SenderServiceImpl implements ISenderService {
    private final SenderRepository repo;
    public SenderServiceImpl(SenderRepository repo) { this.repo = repo; }

    private SenderDTO toDTO(Sender e){
        SenderDTO d = new SenderDTO();
        d.id = e.getId(); d.name=e.getName(); d.email=e.getEmail(); d.phone=e.getPhone(); d.address=e.getAddress();
        return d;
    }
    private Sender toEntity(SenderDTO d){
        Sender e = new Sender();
        e.setName(d.name); e.setEmail(d.email); e.setPhone(d.phone); e.setAddress(d.address);
        return e;
    }

    @Override public List<SenderDTO> findAll(){ return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList()); }
    @Override public SenderDTO findById(Long id){ return repo.findById(id).map(this::toDTO).orElse(null); }
    @Override public SenderDTO create(SenderDTO dto){ return toDTO(repo.save(toEntity(dto))); }
    @Override public SenderDTO update(Long id, SenderDTO dto){
        return repo.findById(id).map(e -> {
            e.setName(dto.name); e.setEmail(dto.email); e.setPhone(dto.phone); e.setAddress(dto.address);
            return toDTO(repo.save(e));
        }).orElse(null);
    }
    @Override public void delete(Long id){ repo.deleteById(id); }
}
