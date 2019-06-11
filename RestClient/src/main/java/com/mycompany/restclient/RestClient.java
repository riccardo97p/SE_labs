/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restclient;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import javax.ws.rs.client.*;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXB;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author biar
 */
public class RestClient {
    static Client client;
    private static CloseableHttpClient clientxml;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException {
        // TODO code application logic here
        client = ClientBuilder.newClient();
        clientxml = HttpClients.createDefault();

        Course c1 = new Course();
        c1.setId(5);
        c1.setName("Eh");
        ArrayList<Student> newStudent = new ArrayList<>();
        Student s1 = new Student();
        s1.setId(2); s1.setName("antonio");
        newStudent.add(s1);
        c1.setStudents(newStudent);
        Response r = updateCourse(c1, 1);
        System.out.println(r.getStatus());
        
        Course c2 = new Course();
        c2.setId(3);
        c2.setName("ccc");
        ArrayList<Student> newStudent2 = new ArrayList<>();
        Student s2 = new Student();
        s2.setId(2); s2.setName("dd");
        newStudent2.add(s2);
        c2.setStudents(newStudent2);
        Response r2 = updateCourse(c2, 1);
        System.out.println(r2.getStatus());
        
        Student s3 = new Student();
        s3.setId(10); s3.setName("Riccardo");
        Response r3 = createStudentInCourse(s3, 2);
        System.out.println(r3.getStatus());
        
        Response r4 = deleteStudentInCourse(2, 10);
        System.out.println(r4.getStatus());
        
        HttpResponse rep = createStudentXml(1);
        System.out.println(rep.getStatusLine().getStatusCode());
        
        HttpResponse rep2 = updateCourseXml();
        System.out.println(rep2.getStatusLine().getStatusCode());
    }

    public static Response createStudentInCourse(Student newStudent, int courseId){
        WebTarget webTarget = client.target("http://localhost:8080/course/courses/" + String.valueOf(courseId) + "/students");
        Invocation.Builder builder = webTarget.request("text/xml");
        return builder.post(Entity.entity(newStudent, MediaType.TEXT_XML));
    }
    
    public static void getCourse(int id){
        WebTarget webTarget  = client.target("http://localhost:8080/course/");
        WebTarget depWebTarget = webTarget.path("courses/" + String.valueOf(id));
        Invocation.Builder builder = depWebTarget.request("text/xml");
        Course dep = builder.accept(MediaType.TEXT_XML).get(Course.class);
        System.out.println(dep.getId());
    }
    
    public static Response updateCourse(Course newCourse, int oldId){
        
       WebTarget webTarget = client.target("http://localhost:8080/course/courses/" + String.valueOf(oldId));
       Invocation.Builder builder = webTarget.request("text/xml");
       return builder.put(Entity.entity(newCourse, MediaType.TEXT_XML));
    }
    
    public static Response deleteStudentInCourse(int courseId, int studentId){
        WebTarget webTarget  = client.target("http://localhost:8080/course/");
        WebTarget depWebTarget = webTarget.path("courses/" + String.valueOf(courseId) + "/students/" + String.valueOf(studentId));
        Invocation.Builder builder = depWebTarget.request();
        return builder.delete();
    }
    
    public static HttpResponse createStudentXml(int courseId) throws IOException{
        RestClient c = new RestClient();
        HttpPost httpPost = new HttpPost("http://localhost:8080/course/courses/" + String.valueOf(courseId) + "/students");
        InputStream resourceStream = c.getClass().getClassLoader().getResourceAsStream("student.xml");
        if (resourceStream == null)
            System.out.println("Male");
        httpPost.setEntity(new InputStreamEntity(resourceStream));
        httpPost.setHeader("Content-Type", "text/xml");
        return clientxml.execute(httpPost);
    }
    
    public static HttpResponse updateCourseXml() throws IOException{
        RestClient c = new RestClient();
        HttpPut httpPut = new HttpPut("http://localhost:8080/course/courses/" + "2");
        InputStream resourceStream = c.getClass().getClassLoader().getResourceAsStream("course.xml");
        httpPut.setEntity(new InputStreamEntity(resourceStream));
        httpPut.setHeader("Content-Type", "text/xml");
        return clientxml.execute(httpPut);
    }
}