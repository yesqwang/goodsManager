package goods;

import goods.filter.FilterForPermission;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

@MapperScan("goods.mapper")
@Import({DataSourceAutoConfiguration.class,FilterForPermission.class})
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class GoodsApplication{//  extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class, args);
    }

    /*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(GoodsApplication.class);
    }*/
}
