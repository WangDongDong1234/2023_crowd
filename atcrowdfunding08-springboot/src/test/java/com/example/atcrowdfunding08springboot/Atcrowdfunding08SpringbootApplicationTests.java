package com.example.atcrowdfunding08springboot;

import com.example.atcrowdfunding08springboot.config.Student;
import com.example.atcrowdfunding08springboot.entity.AdminEntity;
import com.example.atcrowdfunding08springboot.mapper.AdminMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class Atcrowdfunding08SpringbootApplicationTests {

    Logger logger = LoggerFactory.getLogger(Atcrowdfunding08SpringbootApplicationTests.class);

    @Autowired
    private Student student;

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 仅支持简单类型
     */
    @Value("${atguigu.best.wishes}")
    private String wishes;

//    @Autowired
//    private RedisTemplate<String,String > redisTemplate;

    @Test
    public void testReadYaml() {

        logger.debug(student.toString());
        logger.debug("wishes:"+wishes);

    }

    @Test
    public void testMybatis(){
        AdminEntity adminEntity= adminMapper.selectByPrimaryKey(31);
        logger.debug("adminEntity:"+adminEntity);
    }

    /**
     * 该测试类需要把redis启动起来
     */
    @Test
    public void testRedis(){
//        redisTemplate.opsForValue().set("hello","world");
//        System.out.println(redisTemplate.opsForValue().get("hello"));
    }
}
