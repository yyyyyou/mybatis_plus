package com.yao.service;

import com.yao.pojo.Picture;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yao.utils.ResultT;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yy
 * @since 2021-12-16
 */
@Service
public interface PictureService extends IService<Picture> {

  Integer insertPicture(Picture picture);
 
    List<Picture> getAllPictureList();

    Picture getSinglePicture(Integer id);

    Integer updatePictureById(Picture picture);

    Integer deletePictureById(Integer id);
}
