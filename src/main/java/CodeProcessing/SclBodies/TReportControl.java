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


/**
 * <p>Java class for tReportControl complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tReportControl">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.iec.ch/61850/2006/SCL}tControlWithTriggerOpt">
 *       &lt;sequence>
 *         &lt;element name="OptFields">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attGroup ref="{http://www.iec.ch/61850/2006/SCL}agOptFields"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="RptEnabled" type="{http://www.iec.ch/61850/2006/SCL}tRptEnabled" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="rptID" use="required" type="{http://www.iec.ch/61850/2006/SCL}tName" />
 *       &lt;attribute name="confRev" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *       &lt;attribute name="buffered" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="bufTime" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" default="0" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tReportControl", propOrder = {
    "optFields",
    "rptEnabled"
})
public class TReportControl
    extends TControlWithTriggerOpt
{

    @XmlElement(name = "OptFields", required = true)
    protected TReportControl.OptFields optFields;
    @XmlElement(name = "RptEnabled")
    protected TRptEnabled rptEnabled;
    @XmlAttribute(name = "rptID", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String rptID;
    @XmlAttribute(name = "confRev", required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected long confRev;
    @XmlAttribute(name = "buffered")
    protected Boolean buffered;
    @XmlAttribute(name = "bufTime")
    @XmlSchemaType(name = "unsignedInt")
    protected Long bufTime;

    /**
     * Gets the value of the optFields property.
     *
     * @return
     *     possible object is
     *     {@link TReportControl.OptFields }
     *
     */
    public TReportControl.OptFields getOptFields() {
        return optFields;
    }

    /**
     * Sets the value of the optFields property.
     *
     * @param value
     *     allowed object is
     *     {@link TReportControl.OptFields }
     *
     */
    public void setOptFields(TReportControl.OptFields value) {
        this.optFields = value;
    }

    /**
     * Gets the value of the rptEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link TRptEnabled }
     *     
     */
    public TRptEnabled getRptEnabled() {
        return rptEnabled;
    }

    /**
     * Sets the value of the rptEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link TRptEnabled }
     *     
     */
    public void setRptEnabled(TRptEnabled value) {
        this.rptEnabled = value;
    }

    /**
     * Gets the value of the rptID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRptID() {
        return rptID;
    }

    /**
     * Sets the value of the rptID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRptID(String value) {
        this.rptID = value;
    }

    /**
     * Gets the value of the confRev property.
     * 
     */
    public long getConfRev() {
        return confRev;
    }

    /**
     * Sets the value of the confRev property.
     * 
     */
    public void setConfRev(long value) {
        this.confRev = value;
    }

    /**
     * Gets the value of the buffered property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isBuffered() {
        if (buffered == null) {
            return false;
        } else {
            return buffered;
        }
    }

    /**
     * Sets the value of the buffered property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBuffered(Boolean value) {
        this.buffered = value;
    }

    /**
     * Gets the value of the bufTime property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public long getBufTime() {
        if (bufTime == null) {
            return  0L;
        } else {
            return bufTime;
        }
    }

    /**
     * Sets the value of the bufTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBufTime(Long value) {
        this.bufTime = value;
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
     *       &lt;attGroup ref="{http://www.iec.ch/61850/2006/SCL}agOptFields"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class OptFields {

        @XmlAttribute(name = "seqNum")
        protected Boolean seqNum;
        @XmlAttribute(name = "timeStamp")
        protected Boolean timeStamp;
        @XmlAttribute(name = "dataSet")
        protected Boolean dataSet;
        @XmlAttribute(name = "reasonCode")
        protected Boolean reasonCode;
        @XmlAttribute(name = "dataRef")
        protected Boolean dataRef;
        @XmlAttribute(name = "bufOvfl")
        protected Boolean bufOvfl;
        @XmlAttribute(name = "entryID")
        protected Boolean entryID;
        @XmlAttribute(name = "configRef")
        protected Boolean configRef;

        /**
         * Gets the value of the seqNum property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public boolean isSeqNum() {
            if (seqNum == null) {
                return false;
            } else {
                return seqNum;
            }
        }

        /**
         * Sets the value of the seqNum property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setSeqNum(Boolean value) {
            this.seqNum = value;
        }

        /**
         * Gets the value of the timeStamp property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public boolean isTimeStamp() {
            if (timeStamp == null) {
                return false;
            } else {
                return timeStamp;
            }
        }

        /**
         * Sets the value of the timeStamp property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setTimeStamp(Boolean value) {
            this.timeStamp = value;
        }

        /**
         * Gets the value of the dataSet property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public boolean isDataSet() {
            if (dataSet == null) {
                return false;
            } else {
                return dataSet;
            }
        }

        /**
         * Sets the value of the dataSet property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setDataSet(Boolean value) {
            this.dataSet = value;
        }

        /**
         * Gets the value of the reasonCode property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public boolean isReasonCode() {
            if (reasonCode == null) {
                return false;
            } else {
                return reasonCode;
            }
        }

        /**
         * Sets the value of the reasonCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setReasonCode(Boolean value) {
            this.reasonCode = value;
        }

        /**
         * Gets the value of the dataRef property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public boolean isDataRef() {
            if (dataRef == null) {
                return false;
            } else {
                return dataRef;
            }
        }

        /**
         * Sets the value of the dataRef property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setDataRef(Boolean value) {
            this.dataRef = value;
        }

        /**
         * Gets the value of the bufOvfl property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public boolean isBufOvfl() {
            if (bufOvfl == null) {
                return false;
            } else {
                return bufOvfl;
            }
        }

        /**
         * Sets the value of the bufOvfl property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setBufOvfl(Boolean value) {
            this.bufOvfl = value;
        }

        /**
         * Gets the value of the entryID property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public boolean isEntryID() {
            if (entryID == null) {
                return false;
            } else {
                return entryID;
            }
        }

        /**
         * Sets the value of the entryID property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setEntryID(Boolean value) {
            this.entryID = value;
        }

        /**
         * Gets the value of the configRef property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public boolean isConfigRef() {
            if (configRef == null) {
                return false;
            } else {
                return configRef;
            }
        }

        /**
         * Sets the value of the configRef property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setConfigRef(Boolean value) {
            this.configRef = value;
        }

    }

}
