//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.15 at 12:03:20 PM MSK 
//


package CodeProcessing.SclBodies;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for tSubNetwork complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tSubNetwork">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.iec.ch/61850/2006/SCL}tNaming">
 *       &lt;sequence>
 *         &lt;element name="BitRate" type="{http://www.iec.ch/61850/2006/SCL}tBitRateInMbPerSec" minOccurs="0"/>
 *         &lt;element name="ConnectedAP" type="{http://www.iec.ch/61850/2006/SCL}tConnectedAP" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}normalizedString" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tSubNetwork", propOrder = {
    "bitRate",
    "connectedAP"
})
public class TSubNetwork
    extends TNaming
{

    @XmlElement(name = "BitRate")
    protected TBitRateInMbPerSec bitRate;
    @XmlElement(name = "ConnectedAP", required = true)
    protected List<TConnectedAP> connectedAP;
    @XmlAttribute(name = "type")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String type;

    /**
     * Gets the value of the bitRate property.
     * 
     * @return
     *     possible object is
     *     {@link TBitRateInMbPerSec }
     *     
     */
    public TBitRateInMbPerSec getBitRate() {
        return bitRate;
    }

    /**
     * Sets the value of the bitRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link TBitRateInMbPerSec }
     *     
     */
    public void setBitRate(TBitRateInMbPerSec value) {
        this.bitRate = value;
    }

    /**
     * Gets the value of the connectedAP property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the connectedAP property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConnectedAP().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TConnectedAP }
     * 
     * 
     */
    public List<TConnectedAP> getConnectedAP() {
        if (connectedAP == null) {
            connectedAP = new ArrayList<TConnectedAP>();
        }
        return this.connectedAP;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

}
