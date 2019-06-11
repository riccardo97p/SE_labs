/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myserver;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author biar
 */
public class MyAdapter extends XmlAdapter<String, Student>{

    @Override
    public Student unmarshal(String v) throws Exception {
        return Student.parse(v);
    }

    @Override
    public String marshal(Student v) throws Exception {
        return v.toString();
    }
    
}
