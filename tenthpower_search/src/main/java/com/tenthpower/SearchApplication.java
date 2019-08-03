package com.tenthpower;

import com.tenthpower.util.IdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 搜索
 * @EnableEurekaClient这个注解只用于Eureka做为服务发现组件，而@EnableDiscoveryClient则可用于所有的服务发现组件
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SearchApplication {
    private static final Logger log = LoggerFactory.getLogger(SearchApplication.class);

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(SearchApplication.class);
        Environment env = app.run(args).getEnvironment();
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        log.info(
                "\n----------------------------------------------------------\n\t"
                        + "Application '{}' is running! Access URLs:\n\t" + "Local: \t\t{}://localhost:{}\n\t"
                        + "External: \t{}://{}:{}\n\t"
                        + "Profile(s): \t{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"), protocol, env.getProperty("server.port"), protocol,
                InetAddress.getLocalHost().getHostAddress(), env.getProperty("server.port"), env.getActiveProfiles());

        String configServerStatus = env.getProperty("configserver.status");
        log.info(
                "\n----------------------------------------------------------\n\t"
                        + "Config Server: \t{}\n----------------------------------------------------------",
                configServerStatus == null ? "Not found or not setup for this application" : configServerStatus);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
