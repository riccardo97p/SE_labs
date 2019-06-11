/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mynewclient;

import java.util.List;

/**
 *
 * @author biar
 */
public class MyNewClient {

    /**
     * @param args the command line arguments
     * 
     * goal:
     * all the names of all clients who have performed an 
     * operation in the last days with description "benzina autostrada"
     * 
     */
    public static void main(String[] args) {
        /**
        String s = getOperationDetailsByID(1);
        System.out.println(s);
        
        List<String> clients;
        
        clients = getClients();
        System.out.println(clients);
        **/
        
        List<String> clients, operations;
        String[] parsed_client;
        int clientID;
        int isGasoline = 0;
        
        System.out.println("Start operation...");
        clients = getClients();
        for (String client : clients){
            parsed_client = client.split(",");
            clientID = Integer.parseInt(parsed_client[0]);
            operations = getOperationsByClientID(clientID);
            isGasoline = checkDescription(operations);
            if (isGasoline == 1)
                System.out.println("> " + parsed_client[1]);
        }
        
        System.out.println("Finished!");
    }

    private static int checkDescription(java.util.List<java.lang.String> op){
        String[] parsed_op;
        String description, date;
        String target = "benzina autostrada";
        
        for (String operation : op){
            parsed_op = operation.split(",");
            description = parsed_op[4];
            description = description.substring(0, description.length() - 1); // I have to remove the last character "]"
            date = parsed_op[2];
            if (isRecent(date)==1 && description.equals(target))
                return 1;
        } 
        return 0;
    }
    
    private static int isRecent(String date){
        int currentDay = 22; //hard coded, whatever...
        String[] parsed_date = date.split("-");
        int day = Integer.parseInt(parsed_date[2]);
        
        if (day + 7 >= currentDay) // more than 1 week is not recent
            return 1;
        return 0;
    }
    
    private static java.util.List<java.lang.String> getClients() {
        com.mycompany.aaaws.AAAWSImplService service = new com.mycompany.aaaws.AAAWSImplService();
        com.mycompany.aaaws.AAAWSIFace port = service.getAAAWSImplPort();
        return port.getClients();
    }

    private static java.util.List<java.lang.String> getOperationsByClientID(int arg0) {
        it.sapienza.softeng.bankws.BankImplService service = new it.sapienza.softeng.bankws.BankImplService();
        it.sapienza.softeng.bankws.BankIFace port = service.getBankImplPort();
        return port.getOperationsByClientID(arg0);
    }

    private static String getOperationDetailsByID(int arg0) {
        it.sapienza.softeng.bankws.BankImplService service = new it.sapienza.softeng.bankws.BankImplService();
        it.sapienza.softeng.bankws.BankIFace port = service.getBankImplPort();
        return port.getOperationDetailsByID(arg0);
    }
    
}
