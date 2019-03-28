/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenrestfullab2;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Radya
 */
@Path("/calculator")
public class Calculator {
    @GET
    @Path("/add")
    public String add(@QueryParam("num1") String num1 , @QueryParam("num2") String num2)
    {
        int number1= Integer.parseInt(num1);
        int number2= Integer.parseInt(num2);
        Integer res = number1+number2;
        return res.toString();
    }
    
    @GET
    @Path("/sub")
    public String sub(@QueryParam("num1") String num1 , @QueryParam("num2") String num2)
    {
        int number1= Integer.parseInt(num1);
        int number2= Integer.parseInt(num2);
        Integer res = number1-number2;
        return res.toString();
    }
    
    @GET
    @Path("/mul")
    public String mul(@QueryParam("num1") String num1 , @QueryParam("num2") String num2)
    {
        int number1= Integer.parseInt(num1);
        int number2= Integer.parseInt(num2);
        Integer res = number1*number2;
        return res.toString();
    }
    
    @GET
    @Path("/div")
    public String div(@QueryParam("num1") String num1 , @QueryParam("num2") String num2)
    {
        int number1= Integer.parseInt(num1);
        int number2= Integer.parseInt(num2);
        Integer res ;
        if(number2 !=0)
        {
             res = number1/number2;
            return res.toString();
        }
        else
            return "Can't divide by Zero !!";
       
    }
}
