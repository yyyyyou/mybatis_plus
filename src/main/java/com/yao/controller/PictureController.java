package com.yao.controller;


import com.yao.pojo.Picture;
import com.yao.service.PictureService;
import com.yao.utils.ResultData;
import com.yao.utils.ResultT;
import jdk.nashorn.internal.runtime.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yy
 * @since 2021-12-16
 */
@RestController
@RequestMapping("/picture/picture")
public class PictureController {
    @Autowired
    PictureService pictureService;
    @PostMapping("/insert")
    public ResultT insertPicture(Picture picture){
        Picture picture1 = new Picture(12, "BAT", "WWW.BAT.COM", "YY", null, null, 0, 1);

        return new ResultT(pictureService.insertPicture(picture));
    }

    @GetMapping("/getALL")
    public ResultT getPicture(){

        return new ResultT(pictureService.getAllPictureList());
    }
    @GetMapping("/getSingle/{id}")
    public ResultT getSinglePicture(@PathVariable Integer id){

        return new ResultT(pictureService.getSinglePicture(id));
    }
    @GetMapping("/get1")
    public ResultData getPicture1(){

        return ResultData.fail().data("数据",pictureService.getAllPictureList());
    }
    @GetMapping("/get2")
    public ResultT getPicture2(){

        return new ResultT("500","错误" );
    }


    @PutMapping("/update")
    public ResultT updatePictureById(Picture picture){
        Integer i = pictureService.updatePictureById(picture);
        if (i>0){
            return new ResultT(pictureService.getSinglePicture(picture.getId()),"成功，更改的行数为"+i);
        }else
            return new ResultT("500","更改错误，更改的行数为"+i);
    }

    @DeleteMapping("/delete/{id}")
    public ResultT deletePictureById(@PathVariable Integer id){
        return pictureService.deletePictureById(id) > 0 ?new ResultT().ResultSuccess("删除成功") : new ResultT().ResultError("删除失败") ;

    }


}

