
package gov.tceq.epay.webservice.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EpayUserLogin complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EpayUserLogin"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Header" type="{http://webservice.epay.tceq.gov/xsd}Header"/&gt;
 *         &lt;element name="UserInfo" type="{http://webservice.epay.tceq.gov/xsd}UserInfo"/&gt;
 *         &lt;element name="EpayActor" type="{http://webservice.epay.tceq.gov/xsd}EpaySessionInfo"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EpayUserLogin", propOrder = {
    "header",
    "userInfo",
    "epayActor"
})
public class EpayUserLogin {

    @XmlElement(name = "Header", required = true)
    protected Header header;
    @XmlElement(name = "UserInfo", required = true)
    protected UserInfo userInfo;
    @XmlElement(name = "EpayActor", required = true)
    protected EpaySessionInfo epayActor;

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link Header }
     *     
     */
    public Header getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link Header }
     *     
     */
    public void setHeader(Header value) {
        this.header = value;
    }

    /**
     * Gets the value of the userInfo property.
     * 
     * @return
     *     possible object is
     *     {@link UserInfo }
     *     
     */
    public UserInfo getUserInfo() {
        return userInfo;
    }

    /**
     * Sets the value of the userInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserInfo }
     *     
     */
    public void setUserInfo(UserInfo value) {
        this.userInfo = value;
    }

    /**
     * Gets the value of the epayActor property.
     * 
     * @return
     *     possible object is
     *     {@link EpaySessionInfo }
     *     
     */
    public EpaySessionInfo getEpayActor() {
        return epayActor;
    }

    /**
     * Sets the value of the epayActor property.
     * 
     * @param value
     *     allowed object is
     *     {@link EpaySessionInfo }
     *     
     */
    public void setEpayActor(EpaySessionInfo value) {
        this.epayActor = value;
    }

}
