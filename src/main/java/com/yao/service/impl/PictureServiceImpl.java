package com.yao.service.impl;

import com.yao.pojo.Picture;
import com.yao.mapper.PictureMapper;
import com.yao.service.PictureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yao.service.PictureService;
import com.yao.utils.ResultT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yy
 * @since 2021-12-16
 */
@Service
public class PictureServiceImpl extends ServiceImpl<PictureMapper, Picture> implements PictureService {
    @Autowired
   PictureMapper pictureMapper;

    @Override
    public Integer insertPicture(Picture picture) {
        int i = pictureMapper.insert(picture);
        return i;
    }



    @Override
    public List<Picture> getAllPictureList() {
        List<Picture> pictureList = pictureMapper.selectList(null);
        return pictureList;
    }

    @Override
    public Picture getSinglePicture(Integer id) {

        return pictureMapper.selectById(id);
    }

    @Override
    public Integer updatePictureById(Picture picture) {
        int i = pictureMapper.updateById(picture);
        return i;

    }

    @Override
    public Integer deletePictureById(Integer id) {
        int i = pictureMapper.deleteById(id);
        return i;
    }

    @Override
    public Integer deletePicture(Arrays[] arrays) {
        int a=0;
        for (int i = 0; i < arrays.length; i++) {
             pictureMapper.deleteById((Serializable) arrays[i]);

             a++;
        }

        return a==arrays.length ? 0 :1;

    }


}
