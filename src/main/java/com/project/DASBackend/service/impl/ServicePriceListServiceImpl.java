package com.project.DASBackend.service.impl;

import com.project.DASBackend.dto.ServicePriceListDto;
import com.project.DASBackend.entity.ServicePriceList;
import com.project.DASBackend.mapper.ServicePriceListMapper;
import com.project.DASBackend.repository.ServicePriceListRepository;
import com.project.DASBackend.service.ServicePriceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicePriceListServiceImpl implements ServicePriceListService {

    @Autowired
    private ServicePriceListRepository servicePriceListRepository;

    @Override
    public ServicePriceListDto createServicePriceList(ServicePriceListDto servicePriceListDto) {
        ServicePriceList servicePriceList = ServicePriceListMapper.toEntity(servicePriceListDto);
        servicePriceList = servicePriceListRepository.save(servicePriceList);
        return ServicePriceListMapper.toDto(servicePriceList);
    }

    @Override
    public ServicePriceListDto getServicePriceListById(Integer servicePriceId) {
        ServicePriceList servicePriceList = servicePriceListRepository.findById(servicePriceId).orElse(null);
        return ServicePriceListMapper.toDto(servicePriceList);
    }

    @Override
    public List<ServicePriceListDto> getAllServicePriceLists() {
        List<ServicePriceList> servicePriceLists = servicePriceListRepository.findAll();
        return servicePriceLists.stream().map(ServicePriceListMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ServicePriceListDto updateServicePriceList(Integer servicePriceId, ServicePriceListDto servicePriceListDto) {
        ServicePriceList servicePriceList = ServicePriceListMapper.toEntity(servicePriceListDto);
        servicePriceList.setServicePriceId(servicePriceId);
        servicePriceList = servicePriceListRepository.save(servicePriceList);
        return ServicePriceListMapper.toDto(servicePriceList);
    }

    @Override
    public void deleteServicePriceList(Integer servicePriceId) {
        servicePriceListRepository.deleteById(servicePriceId);
    }
}
