//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.15 at 12:03:20 PM MSK 
//


package ru.smarteps.scl;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for tLDevice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tLDevice">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.iec.ch/61850/2006/SCL}tUnNaming">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.iec.ch/61850/2006/SCL}LN0"/>
 *         &lt;element ref="{http://www.iec.ch/61850/2006/SCL}LN" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AccessControl" type="{http://www.iec.ch/61850/2006/SCL}tAccessControl" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="inst" use="required" type="{http://www.iec.ch/61850/2006/SCL}tName" />
 *       &lt;attribute name="ldName" type="{http://www.iec.ch/61850/2006/SCL}tRestrLdName" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tLDevice", propOrder = {
    "ln0",
    "ln",
    "accessControl"
})
public class TLDevice
    extends TUnNaming
{

    @XmlElement(name = "LN0", required = true)
    protected LN0 ln0;
    @XmlElement(name = "LN")
    protected List<TLN> ln;
    @XmlElement(name = "AccessControl")
    protected TAccessControl accessControl;
    @XmlAttribute(name = "inst", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String inst;
    @XmlAttribute(name = "ldName")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String ldName;

    /**
     * Gets the value of the ln0 property.
     * 
     * @return
     *     possible object is
     *     {@link LN0 }
     *     
     */
    public LN0 getLN0() {
        return ln0;
    }

    /**
     * Sets the value of the ln0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link LN0 }
     *     
     */
    public void setLN0(LN0 value) {
        this.ln0 = value;
    }

    /**
     * Gets the value of the ln property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ln property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLN().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TLN }
     * 
     * 
     */
    public List<TLN> getLN() {
        if (ln == null) {
            ln = new ArrayList<TLN>();
        }
        return this.ln;
    }

    /**
     * Gets the value of the accessControl property.
     * 
     * @return
     *     possible object is
     *     {@link TAccessControl }
     *     
     */
    public TAccessControl getAccessControl() {
        return accessControl;
    }

    /**
     * Sets the value of the accessControl property.
     * 
     * @param value
     *     allowed object is
     *     {@link TAccessControl }
     *     
     */
    public void setAccessControl(TAccessControl value) {
        this.accessControl = value;
    }

    /**
     * Gets the value of the inst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInst() {
        return inst;
    }

    /**
     * Sets the value of the inst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInst(String value) {
        this.inst = value;
    }

    /**
     * Gets the value of the ldName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLdName() {
        return ldName;
    }

    /**
     * Sets the value of the ldName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLdName(String value) {
        this.ldName = value;
    }

}
