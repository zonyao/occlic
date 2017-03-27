
package gov.tceq.epay.webservice.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EpayLoadShoppingCartResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EpayLoadShoppingCartResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="HeaderResponse" type="{http://webservice.epay.tceq.gov/xsd}HeaderResponse"/&gt;
 *         &lt;element name="SuccessCode" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="SuccessText" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ShoppingCartList" type="{http://webservice.epay.tceq.gov/xsd}ShoppingCartInfoArray"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EpayLoadShoppingCartResponse", propOrder = {
    "headerResponse",
    "successCode",
    "successText",
    "shoppingCartList"
})
public class EpayLoadShoppingCartResponse {

    @XmlElement(name = "HeaderResponse", required = true)
    protected HeaderResponse headerResponse;
    @XmlElement(name = "SuccessCode")
    protected int successCode;
    @XmlElement(name = "SuccessText", required = true)
    protected String successText;
    @XmlElement(name = "ShoppingCartList", required = true)
    protected ShoppingCartInfoArray shoppingCartList;

    /**
     * Gets the value of the headerResponse property.
     * 
     * @return
     *     possible object is
     *     {@link HeaderResponse }
     *     
     */
    public HeaderResponse getHeaderResponse() {
        return headerResponse;
    }

    /**
     * Sets the value of the headerResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderResponse }
     *     
     */
    public void setHeaderResponse(HeaderResponse value) {
        this.headerResponse = value;
    }

    /**
     * Gets the value of the successCode property.
     * 
     */
    public int getSuccessCode() {
        return successCode;
    }

    /**
     * Sets the value of the successCode property.
     * 
     */
    public void setSuccessCode(int value) {
        this.successCode = value;
    }

    /**
     * Gets the value of the successText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuccessText() {
        return successText;
    }

    /**
     * Sets the value of the successText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuccessText(String value) {
        this.successText = value;
    }

    /**
     * Gets the value of the shoppingCartList property.
     * 
     * @return
     *     possible object is
     *     {@link ShoppingCartInfoArray }
     *     
     */
    public ShoppingCartInfoArray getShoppingCartList() {
        return shoppingCartList;
    }

    /**
     * Sets the value of the shoppingCartList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShoppingCartInfoArray }
     *     
     */
    public void setShoppingCartList(ShoppingCartInfoArray value) {
        this.shoppingCartList = value;
    }

}
