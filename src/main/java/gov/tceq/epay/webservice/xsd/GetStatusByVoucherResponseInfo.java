
package gov.tceq.epay.webservice.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for GetStatusByVoucherResponseInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetStatusByVoucherResponseInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SteersProgram" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="SteersReferenceNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="VoucherStatus" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="VoucherNumTxt" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="FeeCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="FeeAmount" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="PaidDt" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="TraceNumTxt" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="PayTypTxt" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="PayorNameTxt" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetStatusByVoucherResponseInfo", propOrder = {
    "steersProgram",
    "steersReferenceNumber",
    "voucherStatus",
    "voucherNumTxt",
    "feeCode",
    "feeAmount",
    "paidDt",
    "traceNumTxt",
    "payTypTxt",
    "payorNameTxt"
})
public class GetStatusByVoucherResponseInfo {

    @XmlElement(name = "SteersProgram", required = true)
    protected String steersProgram;
    @XmlElement(name = "SteersReferenceNumber", required = true)
    protected String steersReferenceNumber;
    @XmlElement(name = "VoucherStatus", required = true)
    protected String voucherStatus;
    @XmlElement(name = "VoucherNumTxt", required = true)
    protected String voucherNumTxt;
    @XmlElement(name = "FeeCode", required = true)
    protected String feeCode;
    @XmlElement(name = "FeeAmount", required = true)
    protected String feeAmount;
    @XmlElement(name = "PaidDt", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar paidDt;
    @XmlElement(name = "TraceNumTxt", required = true)
    protected String traceNumTxt;
    @XmlElement(name = "PayTypTxt", required = true)
    protected String payTypTxt;
    @XmlElement(name = "PayorNameTxt", required = true)
    protected String payorNameTxt;

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
     * Gets the value of the voucherNumTxt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVoucherNumTxt() {
        return voucherNumTxt;
    }

    /**
     * Sets the value of the voucherNumTxt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVoucherNumTxt(String value) {
        this.voucherNumTxt = value;
    }

    /**
     * Gets the value of the feeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeCode() {
        return feeCode;
    }

    /**
     * Sets the value of the feeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeCode(String value) {
        this.feeCode = value;
    }

    /**
     * Gets the value of the feeAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeAmount() {
        return feeAmount;
    }

    /**
     * Sets the value of the feeAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeAmount(String value) {
        this.feeAmount = value;
    }

    /**
     * Gets the value of the paidDt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPaidDt() {
        return paidDt;
    }

    /**
     * Sets the value of the paidDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPaidDt(XMLGregorianCalendar value) {
        this.paidDt = value;
    }

    /**
     * Gets the value of the traceNumTxt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTraceNumTxt() {
        return traceNumTxt;
    }

    /**
     * Sets the value of the traceNumTxt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTraceNumTxt(String value) {
        this.traceNumTxt = value;
    }

    /**
     * Gets the value of the payTypTxt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayTypTxt() {
        return payTypTxt;
    }

    /**
     * Sets the value of the payTypTxt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayTypTxt(String value) {
        this.payTypTxt = value;
    }

    /**
     * Gets the value of the payorNameTxt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayorNameTxt() {
        return payorNameTxt;
    }

    /**
     * Sets the value of the payorNameTxt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayorNameTxt(String value) {
        this.payorNameTxt = value;
    }

}
