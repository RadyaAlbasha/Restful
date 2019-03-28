/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenrestfullab21;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Radya
 */
@Path("/employees")
//@Produces(MediaType.APPLICATION_JSON)
public class EmployeeService {
    static Map< String,Employee> employeesData = new HashMap< String,Employee>();

    public EmployeeService() {
        
        employeesData.put("e01", new Employee("e01", "radya", "01062644491", "cairo", 3000));
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployees_JSON()
    {
        Collection<Employee> employeesCollection =employeesData.values();
        List<Employee> employeesList =new ArrayList<>();
        employeesList.addAll(employeesCollection);
        return employeesList;
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployee(@PathParam("id") String id)
    {
        System.out.println(id);
        System.out.println(employeesData.get(id));
        return employeesData.get(id);
    }
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Employee addEmployee(Employee emp)
    {
        employeesData.put(emp.getId(), emp); 
//        System.out.println(employeesData.get(emp.getId()));
        return emp;  
    }
    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Employee updateEmployee(Employee emp)
    {
        employeesData.remove(emp.getId());
        employeesData.put(emp.getId(), emp);  
        return employeesData.get(emp.getId());  
    }
    @DELETE
    @Path("/{id}")
    public void deleteEmployee(@PathParam("id") String id)
    {
        employeesData.remove(id);
        System.out.println("delete done"); 
    }
}
