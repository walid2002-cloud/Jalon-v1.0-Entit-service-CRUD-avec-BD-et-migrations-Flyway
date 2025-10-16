package com.rdvmedical.serviceuser.service.impl;

import com.rdvmedical.serviceuser.domain.dto.VehicleDTO;
import com.rdvmedical.serviceuser.domain.entity.Vehicle;
import com.rdvmedical.serviceuser.repository.VehicleRepository;
import com.rdvmedical.serviceuser.service.IVehicleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService {
    private final VehicleRepository repo;
    public VehicleServiceImpl(VehicleRepository repo){ this.repo = repo; }

    private VehicleDTO toDTO(Vehicle e){ VehicleDTO d=new VehicleDTO(); d.id=e.getId(); d.plateNumber=e.getPlateNumber(); d.type=e.getType(); d.capacityKg=e.getCapacityKg(); return d; }
    private Vehicle toEntity(VehicleDTO d){ Vehicle e=new Vehicle(); e.setPlateNumber(d.plateNumber); e.setType(d.type); e.setCapacityKg(d.capacityKg); return e; }

    @Override public List<VehicleDTO> findAll(){ return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList()); }
    @Override public VehicleDTO findById(Long id){ return repo.findById(id).map(this::toDTO).orElse(null); }
    @Override public VehicleDTO create(VehicleDTO dto){ return toDTO(repo.save(toEntity(dto))); }
    @Override public VehicleDTO update(Long id, VehicleDTO dto){
        return repo.findById(id).map(e->{ if(dto.plateNumber!=null) e.setPlateNumber(dto.plateNumber);
            if(dto.type!=null) e.setType(dto.type); if(dto.capacityKg!=null) e.setCapacityKg(dto.capacityKg);
            return toDTO(repo.save(e)); }).orElse(null);
    }
    @Override public void delete(Long id){ repo.deleteById(id); }
}
