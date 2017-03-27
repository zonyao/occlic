
package gov.tceq.epay.webservice.xsd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetStatusResponseInfoArray complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetStatusResponseInfoArray"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GetStatusResponseInfo" type="{http://webservice.epay.tceq.gov/xsd}GetStatusResponseInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetStatusResponseInfoArray", propOrder = {
    "getStatusResponseInfo"
})
public class GetStatusResponseInfoArray {

    @XmlElement(name = "GetStatusResponseInfo")
    protected List<GetStatusResponseInfo> getStatusResponseInfo;

    /**
     * Gets the value of the getStatusResponseInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the getStatusResponseInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetStatusResponseInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetStatusResponseInfo }
     * 
     * 
     */
    public List<GetStatusResponseInfo> getGetStatusResponseInfo() {
        if (getStatusResponseInfo == null) {
            getStatusResponseInfo = new ArrayList<GetStatusResponseInfo>();
        }
        return this.getStatusResponseInfo;
    }

}
