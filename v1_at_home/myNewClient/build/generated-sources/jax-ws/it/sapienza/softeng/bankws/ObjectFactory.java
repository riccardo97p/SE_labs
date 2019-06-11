
package it.sapienza.softeng.bankws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.sapienza.softeng.bankws package. 
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

    private final static QName _GetOperationDetailsByID_QNAME = new QName("http://bankws.softeng.sapienza.it/", "getOperationDetailsByID");
    private final static QName _GetOperationDetailsByIDResponse_QNAME = new QName("http://bankws.softeng.sapienza.it/", "getOperationDetailsByIDResponse");
    private final static QName _GetOperationsByClientID_QNAME = new QName("http://bankws.softeng.sapienza.it/", "getOperationsByClientID");
    private final static QName _GetOperationsByClientIDResponse_QNAME = new QName("http://bankws.softeng.sapienza.it/", "getOperationsByClientIDResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.sapienza.softeng.bankws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetOperationsByClientIDResponse }
     * 
     */
    public GetOperationsByClientIDResponse createGetOperationsByClientIDResponse() {
        return new GetOperationsByClientIDResponse();
    }

    /**
     * Create an instance of {@link GetOperationsByClientID }
     * 
     */
    public GetOperationsByClientID createGetOperationsByClientID() {
        return new GetOperationsByClientID();
    }

    /**
     * Create an instance of {@link GetOperationDetailsByID }
     * 
     */
    public GetOperationDetailsByID createGetOperationDetailsByID() {
        return new GetOperationDetailsByID();
    }

    /**
     * Create an instance of {@link GetOperationDetailsByIDResponse }
     * 
     */
    public GetOperationDetailsByIDResponse createGetOperationDetailsByIDResponse() {
        return new GetOperationDetailsByIDResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOperationDetailsByID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bankws.softeng.sapienza.it/", name = "getOperationDetailsByID")
    public JAXBElement<GetOperationDetailsByID> createGetOperationDetailsByID(GetOperationDetailsByID value) {
        return new JAXBElement<GetOperationDetailsByID>(_GetOperationDetailsByID_QNAME, GetOperationDetailsByID.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOperationDetailsByIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bankws.softeng.sapienza.it/", name = "getOperationDetailsByIDResponse")
    public JAXBElement<GetOperationDetailsByIDResponse> createGetOperationDetailsByIDResponse(GetOperationDetailsByIDResponse value) {
        return new JAXBElement<GetOperationDetailsByIDResponse>(_GetOperationDetailsByIDResponse_QNAME, GetOperationDetailsByIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOperationsByClientID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bankws.softeng.sapienza.it/", name = "getOperationsByClientID")
    public JAXBElement<GetOperationsByClientID> createGetOperationsByClientID(GetOperationsByClientID value) {
        return new JAXBElement<GetOperationsByClientID>(_GetOperationsByClientID_QNAME, GetOperationsByClientID.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOperationsByClientIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bankws.softeng.sapienza.it/", name = "getOperationsByClientIDResponse")
    public JAXBElement<GetOperationsByClientIDResponse> createGetOperationsByClientIDResponse(GetOperationsByClientIDResponse value) {
        return new JAXBElement<GetOperationsByClientIDResponse>(_GetOperationsByClientIDResponse_QNAME, GetOperationsByClientIDResponse.class, null, value);
    }

}
