/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clientjms;

import static com.mycompany.clientjms.ClientQuotaz.sessionQuotaz;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.*;
import javax.naming.*;

/**
 *
 * @author biar
 */
public class ClientOrdini implements MessageListener{

   Session sessionOrdini = null;
   static MessageProducer producer;
    
    
   public void start() throws NamingException, JMSException{
       /*The Java Naming and Directory Interface (JNDI)
        locates an existing JMS connection factory.*/
        Properties props = new Properties(); 
        /*Constant that holds the name of the environment property for specifying 
        the initial context factory to use. The value of the property should be 
        the fully qualified class name of the factory class that will create an 
        initial context */
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        /*Specifying configuration information for the service provider to use. 
        The value of the property should contain a URL string */
        props.setProperty(Context.PROVIDER_URL,"tcp://127.0.0.1:61616"); 
        Context jndiContext = new InitialContext(props);
        
        /*We need to subscribe to a topic so, we need to lookup for a TopicConnectionFactory. 
        If a point-to-point connection is needed, it is possible to use QueueConnectionFactory*/
        ConnectionFactory connectionFactory = (ConnectionFactory)jndiContext.lookup("TopicConnectionFactory"); 
        /*Quotazioni is the name of the topic to which we need to subscribe*/
        Destination destinationOrdini = (Destination)jndiContext.lookup("dynamicTopics/Ordini"); 
        
        Connection connection = connectionFactory.createConnection(); 
        /*Creating a session. The params are explained in the .tex file*/
        sessionOrdini = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageConsumer consumerOrdini = sessionOrdini.createConsumer(destinationOrdini); 
        
        consumerOrdini.setMessageListener(this);
        //consumerOrdini.setMessageListener(new MyListener());
        /*Note that if the connection is not started (line below), nothing works*/
        connection.start();
   }

    @Override
    public void onMessage(Message msg) {
        try {
            TextMessage txt = (TextMessage) msg;
            if (txt.getStringProperty("Utente").equals("Riccardo Chiaretti") && txt.getObjectProperty("Status") != null){
                System.out.println("Bid accepted: " + txt.getBooleanProperty("Status")); 
            }
        } catch (JMSException ex) {
            Logger.getLogger(ClientOrdini.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
