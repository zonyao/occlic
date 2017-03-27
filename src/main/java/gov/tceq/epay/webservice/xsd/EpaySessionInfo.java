
package gov.tceq.epay.webservice.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EpaySessionInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EpaySessionInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ActorName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ActorEmail" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="CfSecId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="CfTokenId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="HrefReturnUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EpaySessionInfo", propOrder = {
    "actorName",
    "actorEmail",
    "cfSecId",
    "cfTokenId",
    "hrefReturnUrl"
})
public class EpaySessionInfo {

    @XmlElement(name = "ActorName", required = true)
    protected String actorName;
    @XmlElement(name = "ActorEmail", required = true)
    protected String actorEmail;
    @XmlElement(name = "CfSecId")
    protected long cfSecId;
    @XmlElement(name = "CfTokenId")
    protected long cfTokenId;
    @XmlElement(name = "HrefReturnUrl")
    protected String hrefReturnUrl;

    /**
     * Gets the value of the actorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActorName() {
        return actorName;
    }

    /**
     * Sets the value of the actorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActorName(String value) {
        this.actorName = value;
    }

    /**
     * Gets the value of the actorEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActorEmail() {
        return actorEmail;
    }

    /**
     * Sets the value of the actorEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActorEmail(String value) {
        this.actorEmail = value;
    }

    /**
     * Gets the value of the cfSecId property.
     * 
     */
    public long getCfSecId() {
        return cfSecId;
    }

    /**
     * Sets the value of the cfSecId property.
     * 
     */
    public void setCfSecId(long value) {
        this.cfSecId = value;
    }

    /**
     * Gets the value of the cfTokenId property.
     * 
     */
    public long getCfTokenId() {
        return cfTokenId;
    }

    /**
     * Sets the value of the cfTokenId property.
     * 
     */
    public void setCfTokenId(long value) {
        this.cfTokenId = value;
    }

    /**
     * Gets the value of the hrefReturnUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHrefReturnUrl() {
        return hrefReturnUrl;
    }

    /**
     * Sets the value of the hrefReturnUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHrefReturnUrl(String value) {
        this.hrefReturnUrl = value;
    }

}
