package org.example.marketapplication.mapper;

import org.example.marketapplication.dto.MeasurementDTO;
import org.example.marketapplication.entity.Measurement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MeasurementMapper extends EntityMapper<MeasurementDTO, Measurement> {
}
