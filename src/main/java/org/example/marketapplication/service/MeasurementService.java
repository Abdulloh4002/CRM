package org.example.marketapplication.service;

import org.example.marketapplication.dto.MeasurementDTO;

import java.util.List;

public interface MeasurementService {
    MeasurementDTO getMeasurementById(Integer id);
    List<MeasurementDTO> getAllMeasurements();
    MeasurementDTO createMeasurement(MeasurementDTO measurementDTO);
    MeasurementDTO updateMeasurement(Integer id, MeasurementDTO measurementDTO);
    void deleteMeasurement(Integer id);
}
