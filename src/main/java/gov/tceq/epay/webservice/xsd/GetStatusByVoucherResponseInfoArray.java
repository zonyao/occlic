
package gov.tceq.epay.webservice.xsd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetStatusByVoucherResponseInfoArray complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetStatusByVoucherResponseInfoArray"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GetStatusByVoucherResponseInfo" type="{http://webservice.epay.tceq.gov/xsd}GetStatusByVoucherResponseInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetStatusByVoucherResponseInfoArray", propOrder = {
    "getStatusByVoucherResponseInfo"
})
public class GetStatusByVoucherResponseInfoArray {

    @XmlElement(name = "GetStatusByVoucherResponseInfo")
    protected List<GetStatusByVoucherResponseInfo> getStatusByVoucherResponseInfo;

    /**
     * Gets the value of the getStatusByVoucherResponseInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the getStatusByVoucherResponseInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetStatusByVoucherResponseInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetStatusByVoucherResponseInfo }
     * 
     * 
     */
    public List<GetStatusByVoucherResponseInfo> getGetStatusByVoucherResponseInfo() {
        if (getStatusByVoucherResponseInfo == null) {
            getStatusByVoucherResponseInfo = new ArrayList<GetStatusByVoucherResponseInfo>();
        }
        return this.getStatusByVoucherResponseInfo;
    }

}
