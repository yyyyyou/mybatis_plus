package com.yao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yao.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
public interface UserMapper extends BaseMapper<User> {
}
