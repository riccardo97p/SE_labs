/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aaaws;

import javax.xml.ws.Endpoint;

/**
 *
 * @author biar
 */
public class Server {
    
    public static void main(String[] args) throws InterruptedException {
        AAAWSImpl implementor = new AAAWSImpl();
        String address = "http://localhost:8080/AAAWS";
        Endpoint.publish(address, implementor);
        //System.exit(0);
        while(true){
            Thread.sleep(60 * 1000);
        }
    }
}
