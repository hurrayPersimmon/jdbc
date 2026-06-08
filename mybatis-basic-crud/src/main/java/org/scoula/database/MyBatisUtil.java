package org.scoula.database;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

// MyBatis 설정 파일을 읽고 SqlSessionFactory를 생성하는 클래스
public class MyBatisUtil {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
// resources 폴더 안의 mybatis-config.xml을 읽는다.
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);

// MyBatis 설정 파일을 기반으로 SqlSessionFactory 생성
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 외부에서 SqlSessionFactory를 사용할 수 있도록 제공
    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}