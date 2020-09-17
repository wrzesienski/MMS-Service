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
 * <p>Java class for tHeader complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tHeader">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Text" type="{http://www.iec.ch/61850/2006/SCL}tText" minOccurs="0"/>
 *         &lt;element name="History" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Hitem" type="{http://www.iec.ch/61850/2006/SCL}tHitem" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}normalizedString" />
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}normalizedString" />
 *       &lt;attribute name="revision" type="{http://www.w3.org/2001/XMLSchema}normalizedString" default="" />
 *       &lt;attribute name="toolID" type="{http://www.w3.org/2001/XMLSchema}normalizedString" />
 *       &lt;attribute name="nameStructure" default="IEDName">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}Name">
 *             &lt;enumeration value="IEDName"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tHeader", propOrder = {
    "text",
    "history"
})
public class THeader {

    @XmlElement(name = "Text")
    protected TText text;
    @XmlElement(name = "History")
    protected THeader.History history;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String id;
    @XmlAttribute(name = "version")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String version;
    @XmlAttribute(name = "revision")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String revision;
    @XmlAttribute(name = "toolID")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String toolID;
    @XmlAttribute(name = "nameStructure")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String nameStructure;

    /**
     * Gets the value of the text property.
     *
     * @return
     *     possible object is
     *     {@link TText }
     *
     */
    public TText getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     *
     * @param value
     *     allowed object is
     *     {@link TText }
     *
     */
    public void setText(TText value) {
        this.text = value;
    }

    /**
     * Gets the value of the history property.
     *
     * @return
     *     possible object is
     *     {@link THeader.History }
     *
     */
    public THeader.History getHistory() {
        return history;
    }

    /**
     * Sets the value of the history property.
     *
     * @param value
     *     allowed object is
     *     {@link THeader.History }
     *
     */
    public void setHistory(THeader.History value) {
        this.history = value;
    }

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
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the revision property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRevision() {
        if (revision == null) {
            return "";
        } else {
            return revision;
        }
    }

    /**
     * Sets the value of the revision property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRevision(String value) {
        this.revision = value;
    }

    /**
     * Gets the value of the toolID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToolID() {
        return toolID;
    }

    /**
     * Sets the value of the toolID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToolID(String value) {
        this.toolID = value;
    }

    /**
     * Gets the value of the nameStructure property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameStructure() {
        if (nameStructure == null) {
            return "IEDName";
        } else {
            return nameStructure;
        }
    }

    /**
     * Sets the value of the nameStructure property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameStructure(String value) {
        this.nameStructure = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Hitem" type="{http://www.iec.ch/61850/2006/SCL}tHitem" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "hitem"
    })
    public static class History {

        @XmlElement(name = "Hitem", required = true)
        protected List<THitem> hitem;

        /**
         * Gets the value of the hitem property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the hitem property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getHitem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link THitem }
         * 
         * 
         */
        public List<THitem> getHitem() {
            if (hitem == null) {
                hitem = new ArrayList<THitem>();
            }
            return this.hitem;
        }

    }

}
