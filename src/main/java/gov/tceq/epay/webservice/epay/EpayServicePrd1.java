package gov.tceq.epay.webservice.epay;

import com.ambonare.TCEQForm.service.PropertiesReader;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class was generated by Apache CXF 3.1.6
 * 2016-04-06T18:11:06.638+08:00
 * Generated source version: 3.1.6
 * 
 */
@WebServiceClient(name = "EpayService", 
                  wsdlLocation = "http://intwsprd1.tceq.texas.gov:8080/axis2/services/EpayService.wsdl",
                  targetNamespace = "http://webservice.epay.tceq.gov/epay") 
public class EpayServicePrd1 extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://webservice.epay.tceq.gov/epay", "EpayService");
    public final static QName EpayPort = new QName("http://webservice.epay.tceq.gov/epay", "EpayPort");
    public final static String serviceWsdlUrl = PropertiesReader.getPropertie().get("Epay_Service_Url")+".wsdl";

    static {
        URL url = null;
        try {
            url = new URL(serviceWsdlUrl);
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(EpayServicePrd1.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", serviceWsdlUrl);
        }
        WSDL_LOCATION = url;
    }

    public EpayServicePrd1(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public EpayServicePrd1(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EpayServicePrd1() {
        super(WSDL_LOCATION, SERVICE);
    }

    public EpayServicePrd1(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public EpayServicePrd1(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public EpayServicePrd1(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns EpayPortType
     */
    @WebEndpoint(name = "EpayPort")
    public EpayPortType getEpayPort() {
        return super.getPort(EpayPort, EpayPortType.class);
    }

    /**
     *
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EpayPortType
     */
    @WebEndpoint(name = "EpayPort")
    public EpayPortType getEpayPort(WebServiceFeature... features) {
        return super.getPort(EpayPort, EpayPortType.class, features);
    }

}
