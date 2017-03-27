
package gov.tceq.epay.webservice.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetStatusInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetStatusInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SteersProgram" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="SteersReferenceNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetStatusInfo", propOrder = {
    "steersProgram",
    "steersReferenceNumber"
})
public class GetStatusInfo {

    @XmlElement(name = "SteersProgram", required = true)
    protected String steersProgram;
    @XmlElement(name = "SteersReferenceNumber", required = true)
    protected String steersReferenceNumber;

    /**
     * Gets the value of the steersProgram property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSteersProgram() {
        return steersProgram;
    }

    /**
     * Sets the value of the steersProgram property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSteersProgram(String value) {
        this.steersProgram = value;
    }

    /**
     * Gets the value of the steersReferenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSteersReferenceNumber() {
        return steersReferenceNumber;
    }

    /**
     * Sets the value of the steersReferenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSteersReferenceNumber(String value) {
        this.steersReferenceNumber = value;
    }

}
