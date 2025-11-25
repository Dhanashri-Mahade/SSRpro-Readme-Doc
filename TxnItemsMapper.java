package com.siliconmount.ssrpro.mapper;


import com.siliconmount.ssrpro.dto.TxnItemMtsDTO;
import com.siliconmount.ssrpro.dto.TxnItemsDTO;
import com.siliconmount.ssrpro.entity.TxnItemMtsEntity;
import com.siliconmount.ssrpro.entity.TxnItemsEntity;
import com.siliconmount.ssrpro.entity.TxnSubworkEntity;
import com.siliconmount.ssrpro.entity.TxnWorkorderEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TxnItemsMapper {

    TxnItemsMapper INSTANCE = Mappers.getMapper(TxnItemsMapper.class);

    TxnItemsDTO toDTO(TxnItemsEntity entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TxnItemsEntity toEntity(TxnItemsDTO dto, @MappingTarget TxnItemsEntity TxnItemsEntity);

    TxnItemsEntity toEntity(TxnItemsDTO dto);

}

