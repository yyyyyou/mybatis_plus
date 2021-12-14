package com.yao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yao.mapper.UserMapper;
import com.yao.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class WrapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("name")
                .isNotNull("email")
                .ge("age",3);
        userMapper.selectList(wrapper).forEach(System.out::println);
        }
        @Test
        void test1(){
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.between("age",15,30);
            Integer count = userMapper.selectCount(wrapper);
            System.out.println(count);
        }
        @Test
        void test2(){
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.notLike("name","a")
                    .likeLeft("email","t");
            List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
            maps.forEach(System.out::println);
        }

        @Test
    void test3(){
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.inSql("id","select id from user where id<25");
            userMapper.selectObjs(wrapper).forEach(System.out::println);
        }
    }

