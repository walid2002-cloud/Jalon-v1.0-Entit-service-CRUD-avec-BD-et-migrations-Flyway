package com.rdvmedical.serviceuser.service.impl;

import com.rdvmedical.serviceuser.domain.dto.RecipientDTO;
import com.rdvmedical.serviceuser.domain.entity.Recipient;
import com.rdvmedical.serviceuser.repository.RecipientRepository;
import com.rdvmedical.serviceuser.service.IRecipientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipientServiceImpl implements IRecipientService {
    private final RecipientRepository repo;
    public RecipientServiceImpl(RecipientRepository repo){ this.repo = repo; }

    private RecipientDTO toDTO(Recipient e){
        RecipientDTO d = new RecipientDTO();
        d.id=e.getId(); d.name=e.getName(); d.email=e.getEmail(); d.phone=e.getPhone(); d.address=e.getAddress();
        return d;
    }
    private Recipient toEntity(RecipientDTO d){
        Recipient e = new Recipient();
        e.setName(d.name); e.setEmail(d.email); e.setPhone(d.phone); e.setAddress(d.address);
        return e;
    }

    @Override public List<RecipientDTO> findAll(){ return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList()); }
    @Override public RecipientDTO findById(Long id){ return repo.findById(id).map(this::toDTO).orElse(null); }
    @Override public RecipientDTO create(RecipientDTO dto){ return toDTO(repo.save(toEntity(dto))); }
    @Override public RecipientDTO update(Long id, RecipientDTO dto){
        return repo.findById(id).map(e -> {
            e.setName(dto.name); e.setEmail(dto.email); e.setPhone(dto.phone); e.setAddress(dto.address);
            return toDTO(repo.save(e));
        }).orElse(null);
    }
    @Override public void delete(Long id){ repo.deleteById(id); }
}
