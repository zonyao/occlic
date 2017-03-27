
package gov.tceq.epay.webservice.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UserInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IdaUserName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="CallingApplication" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserInfo", propOrder = {
    "idaUserName",
    "callingApplication"
})
public class UserInfo {

    @XmlElement(name = "IdaUserName", required = true)
    protected String idaUserName;
    @XmlElement(name = "CallingApplication", required = true)
    protected String callingApplication;

    /**
     * Gets the value of the idaUserName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdaUserName() {
        return idaUserName;
    }

    /**
     * Sets the value of the idaUserName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdaUserName(String value) {
        this.idaUserName = value;
    }

    /**
     * Gets the value of the callingApplication property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallingApplication() {
        return callingApplication;
    }

    /**
     * Sets the value of the callingApplication property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallingApplication(String value) {
        this.callingApplication = value;
    }

}
