/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myserver;

import javax.xml.ws.Endpoint;

/**
 *
 * @author biar
 */
public class myServer {
    public static void main(String[] args) throws InterruptedException{
        AAAWSImpl implementor = new AAAWSImpl();
        String address = "http://localhost:8080/myServer";
        Endpoint.publish(address, implementor);
        while(true) 
            Thread.sleep(60*1000);
    }
}
