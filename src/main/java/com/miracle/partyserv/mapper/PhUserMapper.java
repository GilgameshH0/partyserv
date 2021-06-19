package com.miracle.partyserv.mapper;

import com.miracle.partyserv.Dto.SavePhUserDto;
import com.miracle.partyserv.model.PhUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PhUserMapper {
    private final ModelMapper mapper;

    public PhUserMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public PhUser toEntity(SavePhUserDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, PhUser.class);
    }

}
