package org.example.marketapplication.mapper;


import java.util.List;

public interface MainMapper<RQ, RS, E>{
    RS toDTO(E e);
    E toEntity(RQ rq);
    List<RS> toListDTO(List<E> es);
    List<E> toListEntity(List<RQ> rq);

}
