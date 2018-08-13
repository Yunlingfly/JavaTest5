package com.hand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Hello world!
 */
@SpringBootApplication
// 因为配置通用mapper，改为tk.mybatis.spring.annotation.MapperScan
@MapperScan("com.hand.infra.mapper")
@ServletComponentScan
public class App {
    public static void main(String[] args) {
        App app=new App();
        app.createConnection();;
        SpringApplication.run(App.class, args);
    }

    // 测试连接是否可用
    public void createConnection() {
        boolean flag = true;
        Connection connection=null;

        try {
            Class.forName(System.getenv("DRIVERCLASSNAME"));
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        while (flag) {
//            System.out.println("try connect");
            try {
                connection = DriverManager.getConnection(System.getenv("URL"), System.getenv("USERNAME"), System.getenv("PASSWORD"));
                flag = false;
            }
            catch (Exception e) {
                flag = true;
            }
        }
    }
}