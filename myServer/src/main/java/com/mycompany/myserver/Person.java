/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myserver;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author biar
 */

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
    
    @XmlElement
    int id;
    
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    @XmlElement
    String name;
    
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @XmlElement
    public Student s;
    
    
    public Student getstudent() {
        return s;
    }

    @XmlJavaTypeAdapter(MyAdapter.class)
    public void setstudent(Student s) {
        this.s = s;
    }
    
}
