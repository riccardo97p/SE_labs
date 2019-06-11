/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclient;

import com.mycompany.myserver.Person;
import java.util.*;

/**
 *
 * @author biar
 */
public class MyClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //String: "Massimo Mecella"; Integer[]: [1, 4, 5, ...]
        Map<String, List<String>> map = new HashMap<>();
        List<String[]> splittedClients = new ArrayList();
        
        Person p = getPerson(1);
        Student sw = p.getStu();
        System.out.println(p.getName() + sw.getMatr());
        
        /*List<String> clients = getClients();
        List<String> outCostumer = new ArrayList(); //Costumers having "benzina autostrada"
        Calendar cal = Calendar.getInstance();
        int today = cal.get(Calendar.DAY_OF_MONTH);
        
        clients.stream().forEach((client) -> {
            //id_fullname[0]: client id; id_fullname[1]: fullname
            //Each pair of items contains a id_fullname for a different client
            splittedClients.add(client.split(","));
        });
        
        String[] idFullnameTemp;
        for (int i = 0; i < splittedClients.size(); i++){
            //idFullnameTemp[0]: client id (string); idFullnameTemp[1]: fullname (string)
            idFullnameTemp = splittedClients.get(i);
            map.put(idFullnameTemp[1], getOperationsByClientID(Integer.parseInt(idFullnameTemp[0])));
        }
        
        Iterator it = map.entrySet().iterator();
        List<String> mapValueTemp;
        String[] strTemp;
        while (it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            mapValueTemp = (List<String>)pair.getValue();
            for (String op : mapValueTemp){
                strTemp = op.split(","); //strTemp[2] is the full date
                if (today - extractOpDay(strTemp[2]) <= 20){ //if the operation was done before than one week ago
                    //Remember to remove "]" at the end
                    if (strTemp[4].substring(0, strTemp[4].length()-1).equals("benzina autostrada"))
                        outCostumer.add((String)pair.getKey());
                }
            }
        }
        System.out.println(outCostumer);*/
    }

    
    
    private static int extractOpDay(String opDate) {
        String day = opDate.split("-")[2];
        return Integer.parseInt(day);
    }

    private static Person getPerson(int arg0) {
        com.mycompany.myserver.AAAWSImplService service = new com.mycompany.myserver.AAAWSImplService();
        com.mycompany.myserver.AAAWSIFace port = service.getAAAWSImplPort();
        return port.getPerson(arg0);
    }


}
