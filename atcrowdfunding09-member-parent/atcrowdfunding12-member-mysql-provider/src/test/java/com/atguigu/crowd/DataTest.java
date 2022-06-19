package com.atguigu.crowd;

import com.atguigu.crowd.mapper.MemberMapper;
import com.atguigu.crowd.po.MemberPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataTest {

    private Logger logger = LoggerFactory.getLogger(DataTest.class);

    @Autowired
    private DataSource dataSource;

    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void testDataSource() throws SQLException {
        Connection connection = dataSource.getConnection();
        logger.info("connection:"+connection.toString());
    }

    @Test
    public void testInsertData(){
        MemberPO memberPO = new MemberPO();
        memberPO.setLoginAcct("jack");
        memberPO.setUserPswd("123456");
        memberPO.setUserName("杰克");
        memberPO.setEmail("jack@qq.com");
        memberPO.setAcctType(1);
        memberPO.setAuthStatus(1);
        memberPO.setRealName("杰克");
        memberPO.setCardNum("12345");
        memberMapper.insertSelective(memberPO);
    }
}
