package com.lemonfish.mapper;

import com.diboot.core.mapper.BaseCrudMapper;
import com.lemonfish.pojo.entity.Week;
import org.apache.ibatis.annotations.Mapper;

/**
* 教学周Mapper
* @author Lemonfish
* @version 1.0
* @date 2020-03-25
 * Copyright © Chao Zhang
*/
@Mapper
public interface WeekMapper extends BaseCrudMapper<Week> {

}

