//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.15 at 12:03:20 PM MSK 
//


package ru.smarteps.scl;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for tControlWithIEDName complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tControlWithIEDName">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.iec.ch/61850/2006/SCL}tControl">
 *       &lt;sequence>
 *         &lt;element name="IEDName" type="{http://www.iec.ch/61850/2006/SCL}tName" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="confRev" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tControlWithIEDName", propOrder = {
    "iedName"
})
@XmlSeeAlso({
    TGSEControl.class,
    TSampledValueControl.class
})
public class TControlWithIEDName
    extends TControl
{

    @XmlElement(name = "IEDName")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected List<String> iedName;
    @XmlAttribute(name = "confRev")
    @XmlSchemaType(name = "unsignedInt")
    protected Long confRev;

    /**
     * Gets the value of the iedName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the iedName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIEDName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getIEDName() {
        if (iedName == null) {
            iedName = new ArrayList<String>();
        }
        return this.iedName;
    }

    /**
     * Gets the value of the confRev property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getConfRev() {
        return confRev;
    }

    /**
     * Sets the value of the confRev property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setConfRev(Long value) {
        this.confRev = value;
    }

}
