package com.ruoyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 *
 * @author ruoyi
 */
@SpringBootApplication(
        exclude = {DataSourceAutoConfiguration.class},
        scanBasePackages = {"com.ruoyi", "com.cyl"}
)
public class RuoYiApplication {
    public static void main(String[] args) {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(RuoYiApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  wms启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                "http://localhost:8080/swagger-ui/index.html#");
    }
}
