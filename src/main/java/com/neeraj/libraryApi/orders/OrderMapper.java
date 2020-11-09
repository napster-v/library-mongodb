package com.neeraj.libraryApi.orders;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDTO toDto(Order order);

    Order toModel(OrderDTO orderDTOo);

    List<OrderDTO> toListDto(List<Order> orders);
}
