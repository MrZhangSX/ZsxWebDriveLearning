package zsx;

import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@MapperScan("zsx.dao")
@SpringBootApplication
public class zsxApplication {
    public static void main(String[] args) {
        log.info("Start service");
        SpringApplication.run(zsxApplication.class, args);
    }
}

