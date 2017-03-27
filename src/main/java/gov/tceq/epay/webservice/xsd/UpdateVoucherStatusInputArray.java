
package gov.tceq.epay.webservice.xsd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateVoucherStatusInputArray complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateVoucherStatusInputArray"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="UpdateVoucherStatusInput" type="{http://webservice.epay.tceq.gov/xsd}UpdateVoucherStatusInfo" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateVoucherStatusInputArray", propOrder = {
    "updateVoucherStatusInput"
})
public class UpdateVoucherStatusInputArray {

    @XmlElement(name = "UpdateVoucherStatusInput", required = true)
    protected List<UpdateVoucherStatusInfo> updateVoucherStatusInput;

    /**
     * Gets the value of the updateVoucherStatusInput property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the updateVoucherStatusInput property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUpdateVoucherStatusInput().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UpdateVoucherStatusInfo }
     * 
     * 
     */
    public List<UpdateVoucherStatusInfo> getUpdateVoucherStatusInput() {
        if (updateVoucherStatusInput == null) {
            updateVoucherStatusInput = new ArrayList<UpdateVoucherStatusInfo>();
        }
        return this.updateVoucherStatusInput;
    }

}
