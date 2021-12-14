package com.yao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yao.mapper.UserMapper;
import com.yao.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }
    //插入测试
    @Test
    public void testInsert(){
        User user = new User();
        user.setName("有有有有有有有");
        user.setAge(12);
        user.setEmail("12313231@qq.com");
        int result = userMapper.insert(user);
        System.out.println(result);
        System.out.println(user);

    }
    //更新测试
    @Test
    public void testUpdate(){
                    User user = new User();
            user.setAge(16);
            user.setName("wangxiaogou");
            user.setId(1l);
            userMapper.updateById(user);
                }
    @Test
    public void testlocker(){
        User user = userMapper.selectById(1l);
        user.setName("aa");

        User user2 = userMapper.selectById(1l);
        user2.setName("cc");
        userMapper.updateById(user2);
        userMapper.updateById(user);

    }
    @Test
    public void testSelect1(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }
    @Test
    public void selectByMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("email","test4@baomidou.com");

        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    //测试分页查询
    @Test
    public void testF(){
        Page<User> page = new Page<>(0,5);
        userMapper.selectPage(page,null);

       page.getRecords().forEach(System.out::println);
       System.out.println(page.getTotal());

    }
    //删除
    @Test
    public  void testDel(){
     //   userMapper.deleteById(1456154465308811266l);

       // userMapper.deleteBatchIds(Arrays.asList("1456162959219036162","1456165061248991233","1456165213674201089"));
        HashMap<String, Object> map = new HashMap<>();
        map.put("id","2");
        userMapper.deleteByMap(map);
    }


}
