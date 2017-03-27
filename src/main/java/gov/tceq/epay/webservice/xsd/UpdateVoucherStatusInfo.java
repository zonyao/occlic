
package gov.tceq.epay.webservice.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateVoucherStatusInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateVoucherStatusInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SteersProgram" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SteersRefNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="VoucherNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="VoucherStatus" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="StatusComment" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateVoucherStatusInfo", propOrder = {
    "steersProgram",
    "steersRefNum",
    "voucherNumber",
    "voucherStatus",
    "statusComment"
})
public class UpdateVoucherStatusInfo {

    @XmlElement(name = "SteersProgram")
    protected String steersProgram;
    @XmlElement(name = "SteersRefNum")
    protected String steersRefNum;
    @XmlElement(name = "VoucherNumber", required = true)
    protected String voucherNumber;
    @XmlElement(name = "VoucherStatus", required = true)
    protected String voucherStatus;
    @XmlElement(name = "StatusComment", required = true)
    protected String statusComment;

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
     * Gets the value of the steersRefNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSteersRefNum() {
        return steersRefNum;
    }

    /**
     * Sets the value of the steersRefNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSteersRefNum(String value) {
        this.steersRefNum = value;
    }

    /**
     * Gets the value of the voucherNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVoucherNumber() {
        return voucherNumber;
    }

    /**
     * Sets the value of the voucherNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVoucherNumber(String value) {
        this.voucherNumber = value;
    }

    /**
     * Gets the value of the voucherStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVoucherStatus() {
        return voucherStatus;
    }

    /**
     * Sets the value of the voucherStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVoucherStatus(String value) {
        this.voucherStatus = value;
    }

    /**
     * Gets the value of the statusComment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusComment() {
        return statusComment;
    }

    /**
     * Sets the value of the statusComment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusComment(String value) {
        this.statusComment = value;
    }

}
