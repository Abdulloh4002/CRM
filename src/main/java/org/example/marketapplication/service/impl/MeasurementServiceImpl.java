package org.example.marketapplication.service.impl;

import lombok.*;
import org.example.marketapplication.dto.MeasurementDTO;
import org.example.marketapplication.entity.Measurement;
import org.example.marketapplication.mapper.MeasurementMapper;
import org.example.marketapplication.repository.MeasurementRepository;
import org.example.marketapplication.service.MeasurementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class MeasurementServiceImpl implements MeasurementService {
    private final MeasurementRepository repository;
    private final MeasurementMapper mapper;

    @Override
    public MeasurementDTO getMeasurementById(Integer id) {
        return mapper.toDTO(repository.getReferenceById(id));
    }

    @Override
    public List<MeasurementDTO> getAllMeasurements() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public MeasurementDTO createMeasurement(MeasurementDTO measurementDTO) {
        return mapper
                .toDTO(repository
                        .save(mapper
                                .toEntity(measurementDTO)));
    }

    @Override
    public MeasurementDTO updateMeasurement(Integer id, MeasurementDTO measurementDTO) {
        Measurement measurement = repository.getReferenceById(id);
        measurement.setName(measurementDTO.getName());
        return mapper.toDTO(repository.save(measurement));
    }

    @Override
    public void deleteMeasurement(Integer id) {
        repository.delete(repository.getReferenceById(id));

    }
}
