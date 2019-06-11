/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clientjms;

import static com.mycompany.clientjms.ClientOrdini.producer;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.*;
import javax.naming.*;

/**
 *
 * @author biar
 */
public class ClientQuotaz implements MessageListener{
    
   static Session sessionQuotaz = null;
   static Session sessionOrdini = null;
   static MessageProducer producer;
   static MessageConsumer consumerOrdini;
    
    public static void main(String[] args) throws NamingException, JMSException{
        
        /*For the tutorial see:
            https://www.oracle.com/technetwork/articles/java/introjms-1577110.html*/
        
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
        Destination destinationQuotazioni = (Destination)jndiContext.lookup("dynamicTopics/Quotazioni"); 
        Destination destinationOrdini = (Destination)jndiContext.lookup("dynamicTopics/Ordini"); 

        Connection connection = connectionFactory.createConnection(); 
        /*Creating a session. The params are explained in the .tex file*/
        sessionQuotaz = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        /*The producer and the */
        sessionOrdini = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        
        MessageConsumer consumerQuotaz = sessionQuotaz.createConsumer(destinationQuotazioni); 
        producer = sessionOrdini.createProducer(destinationOrdini); 
        //consumerOrdini = sessionOridini.createConsumer(destinationOrdini); 
        
        ClientQuotaz clientQuotaz = new ClientQuotaz();
        ClientOrdini clientOrdini = new ClientOrdini();
        clientOrdini.start();
        /*Each time the Consumer consumer receives a message, the method onMessage(Message) 
        is invoked. This is done to implement asynchronous reception of message. In this way the 
        client is not doing busy waiting wasting CPU cycles */
        consumerQuotaz.setMessageListener(clientQuotaz);
        //consumerOrdini.setMessageListener(new MyListener());
        /*Note that if the connection is not started (line below), nothing works*/
        connection.start();
        
    }

    @Override
    public void onMessage(Message msg) {
        try {
            TextMessage txt = (TextMessage) msg;
            System.out.println("Nome property: " + txt.getStringProperty("Nome") + " Valore property: " + txt.getDoubleProperty("Valore"));
            /*If the quotation is related to Vodafone ..*/
            if(txt.getStringProperty("Nome").equals("Telecom")){
                /*We are going to order some quotations. Note that this is hardcoded 
                just becasue implementing the UI with Swing is a pain (in the ass)!*/
                TextMessage txtMsg = sessionQuotaz.createTextMessage();
                txtMsg.setStringProperty("Utente", "Riccardo Chiaretti");
                txtMsg.setStringProperty("Nome", "Telecom");
                txtMsg.setFloatProperty("Prezzo", 100);
                txtMsg.setIntProperty("Quantita", 10);
                txtMsg.setIntProperty("mytransmission", 1);
                producer.send(txtMsg);
            }
        
        } catch (JMSException ex) {
            Logger.getLogger(ClientQuotaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
