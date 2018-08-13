package com.hand.infra.mapper;

import com.hand.infra.util.Country;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface CommonCountryMapper extends Mapper<Country> {
}