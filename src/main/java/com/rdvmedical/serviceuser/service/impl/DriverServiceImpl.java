package com.rdvmedical.serviceuser.service.impl;

import com.rdvmedical.serviceuser.domain.dto.DriverDTO;
import com.rdvmedical.serviceuser.domain.entity.Driver;
import com.rdvmedical.serviceuser.repository.DriverRepository;
import com.rdvmedical.serviceuser.service.IDriverService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverServiceImpl implements IDriverService {
    private final DriverRepository repo;
    public DriverServiceImpl(DriverRepository repo){ this.repo = repo; }

    private DriverDTO toDTO(Driver e){ DriverDTO d=new DriverDTO(); d.id=e.getId(); d.name=e.getName(); d.licenseNumber=e.getLicenseNumber(); return d; }
    private Driver toEntity(DriverDTO d){ Driver e=new Driver(); e.setName(d.name); e.setLicenseNumber(d.licenseNumber); return e; }

    @Override public List<DriverDTO> findAll(){ return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList()); }
    @Override public DriverDTO findById(Long id){ return repo.findById(id).map(this::toDTO).orElse(null); }
    @Override public DriverDTO create(DriverDTO dto){ return toDTO(repo.save(toEntity(dto))); }
    @Override public DriverDTO update(Long id, DriverDTO dto){
        return repo.findById(id).map(e->{ e.setName(dto.name); e.setLicenseNumber(dto.licenseNumber); return toDTO(repo.save(e)); }).orElse(null);
    }
    @Override public void delete(Long id){ repo.deleteById(id); }
}
