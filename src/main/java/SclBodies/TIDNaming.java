//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.15 at 12:03:20 PM MSK 
//


package SclBodies;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for tIDNaming complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tIDNaming">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.iec.ch/61850/2006/SCL}tBaseElement">
 *       &lt;attGroup ref="{http://www.iec.ch/61850/2006/SCL}agDesc"/>
 *       &lt;attribute name="id" use="required" type="{http://www.iec.ch/61850/2006/SCL}tName" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tIDNaming")
@XmlSeeAlso({
    TEnumType.class,
    TDOType.class,
    TLNodeType.class,
    TDAType.class
})
public abstract class TIDNaming
    extends TBaseElement
{

    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String id;
    @XmlAttribute(name = "desc")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String desc;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the desc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Sets the value of the desc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesc(String value) {
        this.desc = value;
    }

}
