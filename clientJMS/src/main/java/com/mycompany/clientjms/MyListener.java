/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clientjms;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.*;

/**
 *
 * @author biar
 */
public class MyListener implements MessageListener{

    @Override
    public void onMessage(Message msg) {
        TextMessage txt = (TextMessage) msg;
        try {
            if (txt.getStringProperty("Utente").equals("Riccardo Chiaretti")){
                System.out.println(txt.getBooleanProperty("Status"));
            }
        } catch (JMSException ex) {
            Logger.getLogger(MyListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
