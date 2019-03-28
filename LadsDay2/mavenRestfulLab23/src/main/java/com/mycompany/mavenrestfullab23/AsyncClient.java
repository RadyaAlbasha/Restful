/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenrestfullab23;

import com.sun.jersey.api.client.AsyncWebResource;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.async.TypeListener;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.client.non.blocking.NonBlockingClient;
import com.sun.jersey.client.non.blocking.config.DefaultNonBlockingClientConfig;
import com.sun.jersey.client.non.blocking.config.NonBlockingClientConfig;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author Radya
 */
public class AsyncClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        postClient();
        getClient();

    }

    public static void getClient() {
        ClientConfig cc = new DefaultNonBlockingClientConfig();
        cc.getProperties().put(NonBlockingClientConfig.PROPERTY_THREADPOOL_SIZE, 10);
        Client client = NonBlockingClient.create(cc);
        String getUrl = "http://localhost:8084/mavenRestfulLab21/rest/employees";
        AsyncWebResource awr = client.asyncResource(getUrl);
        AsyncWebResource.Builder builder = awr.accept(MediaType.APPLICATION_JSON);
        builder.get(new TypeListener<ClientResponse>(ClientResponse.class) {
            @Override
            public void onComplete(Future<ClientResponse> future) throws InterruptedException {
                try {
                    ClientResponse response = future.get();
                    if (response.getStatus() != 200) {
                        throw new RuntimeException("HTTP Error: " + response.getStatus());
                    }
                    List<Employee> employees = response.getEntity(new GenericType<List<Employee>>() {
                    });
                    System.out.println("GET");
                    System.out.println("Response from the Server: ");
                    employees.forEach(employee -> System.out.println(employee));
                } catch (ExecutionException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }

    public static void postClient() {
        try {
            ClientConfig cc = new DefaultNonBlockingClientConfig();
            cc.getProperties().put(NonBlockingClientConfig.PROPERTY_THREADPOOL_SIZE, 10);
            Client client = NonBlockingClient.create(cc);
            String postUrl = "http://localhost:8084/mavenRestfulLab21/rest/employees/add";
            AsyncWebResource awr = client.asyncResource(postUrl);
            AsyncWebResource.Builder builder = awr.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON);
            Employee newEmployee = new Employee("e03", "Amr", "01116243075", "maady", (float) 5000.0);
            ObjectMapper mapper = new ObjectMapper();
            String request = mapper.writeValueAsString(newEmployee);
            builder.post(new TypeListener<ClientResponse>(ClientResponse.class) {
                @Override
                public void onComplete(Future<ClientResponse> future) throws InterruptedException {
                    try {
                        ClientResponse response = future.get();
                        if (response.getStatus() != 200) {
                            throw new RuntimeException("HTTP Error: " + response.getStatus());
                        }
                    } catch (ExecutionException ex) {
                        ex.printStackTrace();
                    }
                }
            },request);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
