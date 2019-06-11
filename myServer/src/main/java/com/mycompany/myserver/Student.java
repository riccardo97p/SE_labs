/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myserver;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author biar
 */
@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    
    @XmlElement
    String matr;
    
    public Student(){}


    public void setMatr(String matr) {
        this.matr = matr;
    }

    public String getMatr() {
        return matr;
    }

    static Student parse(String v) {
        Student s = new Student();
        s.setMatr(v);
        return s;
    }

    @Override
    public String toString() {
        return matr;
    }
    
    
}
