/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.bankws;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import javax.jws.WebService;

@WebService(endpointInterface = "it.sapienza.softeng.bankws.BankIFace")
public class BankImpl implements BankIFace {

    private final Map<Integer, String> clientDB = new TreeMap<Integer, String>();
    private final Map<Integer, String> operationDB = new TreeMap<Integer, String>();
    
    public BankImpl() {
        clientDB.put(1, "Massimo Mecella");
        clientDB.put(2, "Miguel Ceriani");
        clientDB.put(3, "Francesco Leotta");
                
        operationDB.put(1, "[1,1,2019-03-22,130,cena al ristorante]");
        operationDB.put(2, "[2,1,2019-03-19,30,benzina autostrada]");
        operationDB.put(3, "[3,2,2019-03-18,1400,riparazione motorino]");
        operationDB.put(4, "[4,2,2019-03-17,600,festa]");
        operationDB.put(5, "[5,3,2019-03-17,45,benzina autostrada]");
    }

    
    @Override
    public String[] getOperationsByClientID(int ClientID) {
        ArrayList result = new ArrayList(); 
        Iterator it = operationDB.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            String aux = (String)pair.getValue();
            String[] st = aux.split(",");
            if ( Integer.parseInt(st[1]) == ClientID ) result.add(aux);
           }
        return (String[])result.toArray(new String[0]);
     }

    @Override
    public String getOperationDetailsByID(int OpID) {
        return operationDB.get(OpID);
    }
}
