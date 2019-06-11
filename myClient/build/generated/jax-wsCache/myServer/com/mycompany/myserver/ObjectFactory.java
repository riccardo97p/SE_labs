
package com.mycompany.myserver;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mycompany.myserver package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetClients_QNAME = new QName("http://myserver.mycompany.com/", "getClients");
    private final static QName _GetClientsResponse_QNAME = new QName("http://myserver.mycompany.com/", "getClientsResponse");
    private final static QName _GetPerson_QNAME = new QName("http://myserver.mycompany.com/", "getPerson");
    private final static QName _GetPersonResponse_QNAME = new QName("http://myserver.mycompany.com/", "getPersonResponse");
    private final static QName _Person_QNAME = new QName("http://myserver.mycompany.com/", "person");
    private final static QName _Student_QNAME = new QName("http://myserver.mycompany.com/", "student");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mycompany.myserver
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPerson }
     * 
     */
    public GetPerson createGetPerson() {
        return new GetPerson();
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link GetPersonResponse }
     * 
     */
    public GetPersonResponse createGetPersonResponse() {
        return new GetPersonResponse();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link GetClients }
     * 
     */
    public GetClients createGetClients() {
        return new GetClients();
    }

    /**
     * Create an instance of {@link GetClientsResponse }
     * 
     */
    public GetClientsResponse createGetClientsResponse() {
        return new GetClientsResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClients }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myserver.mycompany.com/", name = "getClients")
    public JAXBElement<GetClients> createGetClients(GetClients value) {
        return new JAXBElement<GetClients>(_GetClients_QNAME, GetClients.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClientsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myserver.mycompany.com/", name = "getClientsResponse")
    public JAXBElement<GetClientsResponse> createGetClientsResponse(GetClientsResponse value) {
        return new JAXBElement<GetClientsResponse>(_GetClientsResponse_QNAME, GetClientsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myserver.mycompany.com/", name = "getPerson")
    public JAXBElement<GetPerson> createGetPerson(GetPerson value) {
        return new JAXBElement<GetPerson>(_GetPerson_QNAME, GetPerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myserver.mycompany.com/", name = "getPersonResponse")
    public JAXBElement<GetPersonResponse> createGetPersonResponse(GetPersonResponse value) {
        return new JAXBElement<GetPersonResponse>(_GetPersonResponse_QNAME, GetPersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Person }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myserver.mycompany.com/", name = "person")
    public JAXBElement<Person> createPerson(Person value) {
        return new JAXBElement<Person>(_Person_QNAME, Person.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Student }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myserver.mycompany.com/", name = "student")
    public JAXBElement<Student> createStudent(Student value) {
        return new JAXBElement<Student>(_Student_QNAME, Student.class, null, value);
    }

}
