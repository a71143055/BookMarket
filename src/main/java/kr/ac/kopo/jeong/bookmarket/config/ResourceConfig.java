package kr.ac.kopo.jeong.bookmarket.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
public class ResourceConfig {
    @Value("${file.uploadDir}")
    String fileDir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/BookMarket/images/**").addResourceLocations("file://"+fileDir).setCachePeriod(60*60*24*365);
    }
}
