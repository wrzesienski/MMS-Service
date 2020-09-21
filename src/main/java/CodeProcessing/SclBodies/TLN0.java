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
 * <p>Java class for tLN0 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tLN0">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.iec.ch/61850/2006/SCL}tAnyLN">
 *       &lt;sequence>
 *         &lt;element name="GSEControl" type="{http://www.iec.ch/61850/2006/SCL}tGSEControl" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SampledValueControl" type="{http://www.iec.ch/61850/2006/SCL}tSampledValueControl" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SettingControl" type="{http://www.iec.ch/61850/2006/SCL}tSettingControl" minOccurs="0"/>
 *         &lt;element name="SCLControl" type="{http://www.iec.ch/61850/2006/SCL}tSCLControl" minOccurs="0"/>
 *         &lt;element name="Log" type="{http://www.iec.ch/61850/2006/SCL}tLog" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="lnClass" use="required" type="{http://www.iec.ch/61850/2006/SCL}tLNClassEnum" fixed="LLN0" />
 *       &lt;attribute name="inst" use="required" type="{http://www.w3.org/2001/XMLSchema}normalizedString" fixed="" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tLN0", propOrder = {
    "gseControl",
    "sampledValueControl",
    "settingControl",
    "sclControl",
    "log"
})
@XmlSeeAlso({
    LN0 .class
})
public class TLN0
    extends TAnyLN
{

    @XmlElement(name = "GSEControl")
    protected List<TGSEControl> gseControl;
    @XmlElement(name = "SampledValueControl")
    protected List<TSampledValueControl> sampledValueControl;
    @XmlElement(name = "SettingControl")
    protected TSettingControl settingControl;
    @XmlElement(name = "SCLControl")
    protected TSCLControl sclControl;
    @XmlElement(name = "Log")
    protected TLog log;
    @XmlAttribute(name = "lnClass", required = true)
    protected List<String> lnClass;
    @XmlAttribute(name = "inst", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String inst;

    /**
     * Gets the value of the gseControl property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the gseControl property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGSEControl().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TGSEControl }
     * 
     * 
     */
    public List<TGSEControl> getGSEControl() {
        if (gseControl == null) {
            gseControl = new ArrayList<TGSEControl>();
        }
        return this.gseControl;
    }

    /**
     * Gets the value of the sampledValueControl property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sampledValueControl property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSampledValueControl().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TSampledValueControl }
     * 
     * 
     */
    public List<TSampledValueControl> getSampledValueControl() {
        if (sampledValueControl == null) {
            sampledValueControl = new ArrayList<TSampledValueControl>();
        }
        return this.sampledValueControl;
    }

    /**
     * Gets the value of the settingControl property.
     * 
     * @return
     *     possible object is
     *     {@link TSettingControl }
     *     
     */
    public TSettingControl getSettingControl() {
        return settingControl;
    }

    /**
     * Sets the value of the settingControl property.
     * 
     * @param value
     *     allowed object is
     *     {@link TSettingControl }
     *     
     */
    public void setSettingControl(TSettingControl value) {
        this.settingControl = value;
    }

    /**
     * Gets the value of the sclControl property.
     * 
     * @return
     *     possible object is
     *     {@link TSCLControl }
     *     
     */
    public TSCLControl getSCLControl() {
        return sclControl;
    }

    /**
     * Sets the value of the sclControl property.
     * 
     * @param value
     *     allowed object is
     *     {@link TSCLControl }
     *     
     */
    public void setSCLControl(TSCLControl value) {
        this.sclControl = value;
    }

    /**
     * Gets the value of the log property.
     * 
     * @return
     *     possible object is
     *     {@link TLog }
     *     
     */
    public TLog getLog() {
        return log;
    }

    /**
     * Sets the value of the log property.
     * 
     * @param value
     *     allowed object is
     *     {@link TLog }
     *     
     */
    public void setLog(TLog value) {
        this.log = value;
    }

    /**
     * Gets the value of the lnClass property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lnClass property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLnClass().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getLnClass() {
        if (lnClass == null) {
            lnClass = new ArrayList<String>();
        }
        return this.lnClass;
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
        if (inst == null) {
            return "";
        } else {
            return inst;
        }
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

}