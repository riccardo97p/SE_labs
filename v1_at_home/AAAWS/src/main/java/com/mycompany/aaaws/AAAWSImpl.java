/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aaaws;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author biar
 */

@WebService(endpointInterface = "com.mycompany.aaaws.AAAWSIFace")
public class AAAWSImpl implements AAAWSIFace {
    
    @Override
    public java.util.List<java.lang.String> getClients(){
        List<String> l = new ArrayList();
        l.add("1,Massimo Mecella");
        l.add("2,Maurizio Lenzerini");
        l.add("3,Giuseppe De Giacomo");
        
        return l;
    }
}
