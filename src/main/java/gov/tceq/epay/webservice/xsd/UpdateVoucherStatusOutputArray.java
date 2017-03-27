
package gov.tceq.epay.webservice.xsd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateVoucherStatusOutputArray complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateVoucherStatusOutputArray"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="UpdateVoucherStatusOutput" type="{http://webservice.epay.tceq.gov/xsd}UpdateVoucherStatusInfo" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateVoucherStatusOutputArray", propOrder = {
    "updateVoucherStatusOutput"
})
public class UpdateVoucherStatusOutputArray {

    @XmlElement(name = "UpdateVoucherStatusOutput", required = true)
    protected List<UpdateVoucherStatusInfo> updateVoucherStatusOutput;

    /**
     * Gets the value of the updateVoucherStatusOutput property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the updateVoucherStatusOutput property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUpdateVoucherStatusOutput().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UpdateVoucherStatusInfo }
     * 
     * 
     */
    public List<UpdateVoucherStatusInfo> getUpdateVoucherStatusOutput() {
        if (updateVoucherStatusOutput == null) {
            updateVoucherStatusOutput = new ArrayList<UpdateVoucherStatusInfo>();
        }
        return this.updateVoucherStatusOutput;
    }

}
