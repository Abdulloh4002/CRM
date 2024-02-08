package org.example.marketapplication.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.marketapplication.dto.MeasurementDTO;
import org.example.marketapplication.service.MeasurementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("measurement")
@RequiredArgsConstructor
public class MeasurementController {


    private final MeasurementService service;

    @GetMapping
    public List<MeasurementDTO> getAllMeasurements(){
        return service.getAllMeasurements();
    }

    @GetMapping("{id}")
    public MeasurementDTO getMeasurement(@PathVariable Integer id){

        return service.getMeasurementById(id);
    }

    @PostMapping
    public MeasurementDTO createMeasurement(@RequestBody MeasurementDTO measurementDTO){

        return service.createMeasurement(measurementDTO);
    }

    @PutMapping("{id}")
    public MeasurementDTO updateMeasurement(@PathVariable Integer id, @RequestBody MeasurementDTO measurementDTO ){

        return service.updateMeasurement(id, measurementDTO);

    }

    @DeleteMapping("{id}")
    public void deleteMeasurement(@PathVariable Integer id){

        service.deleteMeasurement(id);
    }
}
