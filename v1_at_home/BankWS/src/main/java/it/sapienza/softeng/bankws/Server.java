/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.bankws;

import javax.xml.ws.Endpoint;

public class Server {

    public static void main(String args[]) throws InterruptedException {
        BankImpl implementor = new BankImpl();
        String address = "http://localhost:1024/BankInterface";
        Endpoint.publish(address, implementor);
        while(true) {}
        //Thread.sleep(60 * 1000);
        //System.exit(0);
    }
}
