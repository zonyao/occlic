
package gov.tceq.epay.webservice.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ShoppingCartInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ShoppingCartInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FeeDisplayName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="CN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CustomerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CustomerAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CustomerCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CustomerState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CustomerZip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CustomerZipPlus4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CustomerStateTaxId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BillName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BillAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BillCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BillState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BillZip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BillZipPlus4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ReName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SiteLocationDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SiteAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SiteCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SiteState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SiteZip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SiteZipPlus4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AdditionalId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ProjectNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SteersReferenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="VoucherComment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EpayInterfaceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SteersProgram" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShoppingCartInfo", propOrder = {
    "feeDisplayName",
    "feeAmount",
    "cn",
    "customerName",
    "customerAddress",
    "customerCity",
    "customerState",
    "customerZip",
    "customerZipPlus4",
    "customerStateTaxId",
    "billName",
    "billAddress",
    "billCity",
    "billState",
    "billZip",
    "billZipPlus4",
    "rn",
    "reName",
    "siteLocationDescription",
    "siteAddress",
    "siteCity",
    "siteState",
    "siteZip",
    "siteZipPlus4",
    "additionalId",
    "projectNumber",
    "steersReferenceNumber",
    "voucherComment",
    "epayInterfaceCode",
    "steersProgram"
})
public class ShoppingCartInfo {

    @XmlElement(name = "FeeDisplayName")
    protected String feeDisplayName;
    @XmlElement(name = "FeeAmount")
    protected Double feeAmount;
    @XmlElement(name = "CN")
    protected String cn;
    @XmlElement(name = "CustomerName")
    protected String customerName;
    @XmlElement(name = "CustomerAddress")
    protected String customerAddress;
    @XmlElement(name = "CustomerCity")
    protected String customerCity;
    @XmlElement(name = "CustomerState")
    protected String customerState;
    @XmlElement(name = "CustomerZip")
    protected String customerZip;
    @XmlElement(name = "CustomerZipPlus4")
    protected String customerZipPlus4;
    @XmlElement(name = "CustomerStateTaxId")
    protected String customerStateTaxId;
    @XmlElement(name = "BillName")
    protected String billName;
    @XmlElement(name = "BillAddress")
    protected String billAddress;
    @XmlElement(name = "BillCity")
    protected String billCity;
    @XmlElement(name = "BillState")
    protected String billState;
    @XmlElement(name = "BillZip")
    protected String billZip;
    @XmlElement(name = "BillZipPlus4")
    protected String billZipPlus4;
    @XmlElement(name = "RN")
    protected String rn;
    @XmlElement(name = "ReName")
    protected String reName;
    @XmlElement(name = "SiteLocationDescription")
    protected String siteLocationDescription;
    @XmlElement(name = "SiteAddress")
    protected String siteAddress;
    @XmlElement(name = "SiteCity")
    protected String siteCity;
    @XmlElement(name = "SiteState")
    protected String siteState;
    @XmlElement(name = "SiteZip")
    protected String siteZip;
    @XmlElement(name = "SiteZipPlus4")
    protected String siteZipPlus4;
    @XmlElement(name = "AdditionalId")
    protected String additionalId;
    @XmlElement(name = "ProjectNumber")
    protected String projectNumber;
    @XmlElement(name = "SteersReferenceNumber")
    protected String steersReferenceNumber;
    @XmlElement(name = "VoucherComment")
    protected String voucherComment;
    @XmlElement(name = "EpayInterfaceCode")
    protected String epayInterfaceCode;
    @XmlElement(name = "SteersProgram")
    protected String steersProgram;

    /**
     * Gets the value of the feeDisplayName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeDisplayName() {
        return feeDisplayName;
    }

    /**
     * Sets the value of the feeDisplayName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeDisplayName(String value) {
        this.feeDisplayName = value;
    }

    /**
     * Gets the value of the feeAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getFeeAmount() {
        return feeAmount;
    }

    /**
     * Sets the value of the feeAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setFeeAmount(Double value) {
        this.feeAmount = value;
    }

    /**
     * Gets the value of the cn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCN() {
        return cn;
    }

    /**
     * Sets the value of the cn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCN(String value) {
        this.cn = value;
    }

    /**
     * Gets the value of the customerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets the value of the customerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerName(String value) {
        this.customerName = value;
    }

    /**
     * Gets the value of the customerAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerAddress() {
        return customerAddress;
    }

    /**
     * Sets the value of the customerAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerAddress(String value) {
        this.customerAddress = value;
    }

    /**
     * Gets the value of the customerCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerCity() {
        return customerCity;
    }

    /**
     * Sets the value of the customerCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerCity(String value) {
        this.customerCity = value;
    }

    /**
     * Gets the value of the customerState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerState() {
        return customerState;
    }

    /**
     * Sets the value of the customerState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerState(String value) {
        this.customerState = value;
    }

    /**
     * Gets the value of the customerZip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerZip() {
        return customerZip;
    }

    /**
     * Sets the value of the customerZip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerZip(String value) {
        this.customerZip = value;
    }

    /**
     * Gets the value of the customerZipPlus4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerZipPlus4() {
        return customerZipPlus4;
    }

    /**
     * Sets the value of the customerZipPlus4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerZipPlus4(String value) {
        this.customerZipPlus4 = value;
    }

    /**
     * Gets the value of the customerStateTaxId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerStateTaxId() {
        return customerStateTaxId;
    }

    /**
     * Sets the value of the customerStateTaxId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerStateTaxId(String value) {
        this.customerStateTaxId = value;
    }

    /**
     * Gets the value of the billName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillName() {
        return billName;
    }

    /**
     * Sets the value of the billName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillName(String value) {
        this.billName = value;
    }

    /**
     * Gets the value of the billAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillAddress() {
        return billAddress;
    }

    /**
     * Sets the value of the billAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillAddress(String value) {
        this.billAddress = value;
    }

    /**
     * Gets the value of the billCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillCity() {
        return billCity;
    }

    /**
     * Sets the value of the billCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillCity(String value) {
        this.billCity = value;
    }

    /**
     * Gets the value of the billState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillState() {
        return billState;
    }

    /**
     * Sets the value of the billState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillState(String value) {
        this.billState = value;
    }

    /**
     * Gets the value of the billZip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillZip() {
        return billZip;
    }

    /**
     * Sets the value of the billZip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillZip(String value) {
        this.billZip = value;
    }

    /**
     * Gets the value of the billZipPlus4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillZipPlus4() {
        return billZipPlus4;
    }

    /**
     * Sets the value of the billZipPlus4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillZipPlus4(String value) {
        this.billZipPlus4 = value;
    }

    /**
     * Gets the value of the rn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRN() {
        return rn;
    }

    /**
     * Sets the value of the rn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRN(String value) {
        this.rn = value;
    }

    /**
     * Gets the value of the reName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReName() {
        return reName;
    }

    /**
     * Sets the value of the reName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReName(String value) {
        this.reName = value;
    }

    /**
     * Gets the value of the siteLocationDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiteLocationDescription() {
        return siteLocationDescription;
    }

    /**
     * Sets the value of the siteLocationDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiteLocationDescription(String value) {
        this.siteLocationDescription = value;
    }

    /**
     * Gets the value of the siteAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiteAddress() {
        return siteAddress;
    }

    /**
     * Sets the value of the siteAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiteAddress(String value) {
        this.siteAddress = value;
    }

    /**
     * Gets the value of the siteCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiteCity() {
        return siteCity;
    }

    /**
     * Sets the value of the siteCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiteCity(String value) {
        this.siteCity = value;
    }

    /**
     * Gets the value of the siteState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiteState() {
        return siteState;
    }

    /**
     * Sets the value of the siteState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiteState(String value) {
        this.siteState = value;
    }

    /**
     * Gets the value of the siteZip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiteZip() {
        return siteZip;
    }

    /**
     * Sets the value of the siteZip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiteZip(String value) {
        this.siteZip = value;
    }

    /**
     * Gets the value of the siteZipPlus4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiteZipPlus4() {
        return siteZipPlus4;
    }

    /**
     * Sets the value of the siteZipPlus4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiteZipPlus4(String value) {
        this.siteZipPlus4 = value;
    }

    /**
     * Gets the value of the additionalId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalId() {
        return additionalId;
    }

    /**
     * Sets the value of the additionalId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalId(String value) {
        this.additionalId = value;
    }

    /**
     * Gets the value of the projectNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProjectNumber() {
        return projectNumber;
    }

    /**
     * Sets the value of the projectNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProjectNumber(String value) {
        this.projectNumber = value;
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
     * Gets the value of the voucherComment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVoucherComment() {
        return voucherComment;
    }

    /**
     * Sets the value of the voucherComment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVoucherComment(String value) {
        this.voucherComment = value;
    }

    /**
     * Gets the value of the epayInterfaceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEpayInterfaceCode() {
        return epayInterfaceCode;
    }

    /**
     * Sets the value of the epayInterfaceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEpayInterfaceCode(String value) {
        this.epayInterfaceCode = value;
    }

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

}
