package org.example.marketapplication.mapper;

import java.util.List;

public interface EntityMapper<D,E>{
    D toDTO(E e);
    E toEntity(D d);
    List<D> toDTOList(List<E> es);
}
