package com.example.atcrowdfunding08springboot;

import com.example.atcrowdfunding08springboot.config.Student;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class Atcrowdfunding08SpringbootApplicationTests {

    Logger logger = LoggerFactory.getLogger(Atcrowdfunding08SpringbootApplicationTests.class);

    @Autowired
    private Student student;

    @Test
    public void testReadYaml() {

        logger.info(student.toString());

    }

}
