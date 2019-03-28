/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenrestfullab1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author Radya
 */
@Path("/helloWorld")
public class HelloWorld {
    @GET
    public String sayHello()
    {
        String greeting ="Hello World!!!!";
        return greeting;
    }
}
