package com.batrawy.stc.clinicmanagementsystem.mapper;

import com.batrawy.stc.clinicmanagementsystem.dto.BaseDTO;
import com.batrawy.stc.clinicmanagementsystem.model.BaseEntity;

import java.util.List;
import java.util.Set;

public interface BaseMapper<D extends BaseDTO, E extends BaseEntity> {

    D toDTO(E entity);

    E toEntity(D dto);

    List<E> toListEntity(List<D> dto);

    Set<E> toSetEntity(Set<D> dto);

    List<D> toListDTO(List<E> entities);

    Set<D> toSetDTO(Set<E> entities);

}
