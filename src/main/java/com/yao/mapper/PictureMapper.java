package com.yao.mapper;

import com.yao.pojo.Picture;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yy
 * @since 2021-12-16
 */
@Repository
@Mapper
public interface PictureMapper extends BaseMapper<Picture> {

}
