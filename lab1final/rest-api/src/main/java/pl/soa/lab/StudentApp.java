package pl.soa.lab;

import io.swagger.jaxrs.config.BeanConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class StudentApp extends Application {

    public StudentApp(){
        BeanConfig beanConfig = new BeanConfig();

        beanConfig.setVersion("1.0.0");
        beanConfig.setTitle("StudentApp API");
        beanConfig.setBasePath("/lab1final-web/api");
        beanConfig.setResourcePackage("pl.soa.lab");
        beanConfig.setScan(true);
    }
}
