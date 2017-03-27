
package gov.tceq.epay.webservice.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EpayLoadBilledFees complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EpayLoadBilledFees"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Header" type="{http://webservice.epay.tceq.gov/xsd}Header"/&gt;
 *         &lt;element name="UserInfo" type="{http://webservice.epay.tceq.gov/xsd}UserInfo"/&gt;
 *         &lt;element name="UserId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="ActorIpAddress" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ArNumList" type="{http://webservice.epay.tceq.gov/xsd}ArNumArray"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EpayLoadBilledFees", propOrder = {
    "header",
    "userInfo",
    "userId",
    "actorIpAddress",
    "arNumList"
})
public class EpayLoadBilledFees {

    @XmlElement(name = "Header", required = true)
    protected Header header;
    @XmlElement(name = "UserInfo", required = true)
    protected UserInfo userInfo;
    @XmlElement(name = "UserId")
    protected long userId;
    @XmlElement(name = "ActorIpAddress", required = true)
    protected String actorIpAddress;
    @XmlElement(name = "ArNumList", required = true)
    protected ArNumArray arNumList;

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
     * Gets the value of the userId property.
     * 
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     */
    public void setUserId(long value) {
        this.userId = value;
    }

    /**
     * Gets the value of the actorIpAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActorIpAddress() {
        return actorIpAddress;
    }

    /**
     * Sets the value of the actorIpAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActorIpAddress(String value) {
        this.actorIpAddress = value;
    }

    /**
     * Gets the value of the arNumList property.
     * 
     * @return
     *     possible object is
     *     {@link ArNumArray }
     *     
     */
    public ArNumArray getArNumList() {
        return arNumList;
    }

    /**
     * Sets the value of the arNumList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArNumArray }
     *     
     */
    public void setArNumList(ArNumArray value) {
        this.arNumList = value;
    }

}
