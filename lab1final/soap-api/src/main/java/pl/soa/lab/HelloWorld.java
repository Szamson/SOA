package pl.soa.lab;


import org.jboss.ejb3.annotation.SecurityDomain;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.logging.Logger;


@Stateless
@WebService
@SecurityDomain("lab1-security-domain")
@DeclareRoles({"TestRole","Testers"})
//@WebContext(authMethod="BASIC",  secureWSDLAccess=true)


public class HelloWorld {

    public final static Logger LOGGER = Logger.getLogger(HelloWorld.class.getName());
    @RolesAllowed({"TestRole","Testers"})
    @WebMethod(action = "greet_sb")
    @WebResult(name = "Hello")
    public String hello(@WebParam(name = "name") String name){
        LOGGER.info("hello in console "+ name );
        return "hello "+ name;
    }
}
