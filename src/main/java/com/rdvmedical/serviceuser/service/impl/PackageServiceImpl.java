package com.rdvmedical.serviceuser.service.impl;

import com.rdvmedical.serviceuser.domain.dto.PackageDTO;
import com.rdvmedical.serviceuser.domain.entity.PackageParcel;
import com.rdvmedical.serviceuser.repository.PackageRepository;
import com.rdvmedical.serviceuser.repository.OrderRepository;
import com.rdvmedical.serviceuser.service.IPackageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PackageServiceImpl implements IPackageService {
    private final PackageRepository repo;
    private final OrderRepository orderRepo;
    public PackageServiceImpl(PackageRepository repo, OrderRepository orderRepo){ this.repo=repo; this.orderRepo=orderRepo; }

    private PackageDTO toDTO(PackageParcel e){
        PackageDTO d=new PackageDTO();
        d.id=e.getId(); d.code=e.getCode(); d.weightKg=e.getWeightKg(); d.dimensions=e.getDimensions(); d.fragile=e.getFragile();
        d.orderId = e.getOrderRef()!=null ? e.getOrderRef().getId() : null;
        return d;
    }

    @Override public List<PackageDTO> findAll(){ return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList()); }
    @Override public PackageDTO findById(Long id){ return repo.findById(id).map(this::toDTO).orElse(null); }
    @Override public PackageDTO create(PackageDTO dto){
        PackageParcel e = new PackageParcel();
        e.setCode(dto.code); e.setWeightKg(dto.weightKg); e.setDimensions(dto.dimensions); e.setFragile(Boolean.TRUE.equals(dto.fragile));
        if(dto.orderId!=null) e.setOrderRef(orderRepo.findById(dto.orderId).orElseThrow());
        return toDTO(repo.save(e));
    }
    @Override public PackageDTO update(Long id, PackageDTO dto){
        return repo.findById(id).map(e -> {
            if(dto.code!=null) e.setCode(dto.code);
            if(dto.weightKg!=null) e.setWeightKg(dto.weightKg);
            if(dto.dimensions!=null) e.setDimensions(dto.dimensions);
            if(dto.fragile!=null) e.setFragile(dto.fragile);
            if(dto.orderId!=null) e.setOrderRef(orderRepo.findById(dto.orderId).orElseThrow());
            return toDTO(repo.save(e));
        }).orElse(null);
    }
    @Override public void delete(Long id){ repo.deleteById(id); }
}
