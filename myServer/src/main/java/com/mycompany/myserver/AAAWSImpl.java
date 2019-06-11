/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myserver;

import java.util.*;

/**
 *
 * @author biar
 */
public class AAAWSImpl implements AAAWSIFace {

    @Override
    public List<String> getClients() {
        /*List<String> elements = new ArrayList();
        elements.add("1, Massimo Mecella");
        elements.add("2, Miguel Ceriani");
        elements.add(("3, Francesco Leotta"));
        return elements;*/
        Person p1 = new Person();
        p1.setId(1);
        p1.setName("Antonio");
        Person p2 = new Person();
        p2.setId(2);
        p2.setName("wdvno");
        Person p3 = new Person();
        p3.setId(3);
        p3.setName("owfe");

        return null;
    }

    @Override
    public Person getPerson(int id) {

        Person p1 = new Person();
        p1.setId(1);
        p1.setName("Antonio");
        Student s1 = new Student();
        s1.setMatr("123");
        p1.setstudent(s1);
        Person p2 = new Person();
        p2.setId(2);
        Student s2 = new Student();
        s2.setMatr("345");
        p2.setstudent(s2);
        p2.setName("wdvno");
        Person p3 = new Person();
        Student s3 = new Student();
        s3.setMatr("345");
        p3.setstudent(s3);
        p3.setId(3);
        p3.setName("owfe");

        switch (id) {
            case 1:
                return p1;
            case 2:
                return p2;
            case 3:
                return p3;
        }
        
        return null;
    }

}
