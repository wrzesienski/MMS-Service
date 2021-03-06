//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.15 at 12:03:20 PM MSK 
//


package CodeProcessing.SclBodies;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.smarteps.ru.smarteps.scl package.
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Communication_QNAME = new QName("http://www.iec.ch/61850/2006/SCL", "Communication");
    private final static QName _IED_QNAME = new QName("http://www.iec.ch/61850/2006/SCL", "IED");
    private final static QName _Substation_QNAME = new QName("http://www.iec.ch/61850/2006/SCL", "Substation");
    private final static QName _LN_QNAME = new QName("http://www.iec.ch/61850/2006/SCL", "LN");
    private final static QName _DataTypeTemplates_QNAME = new QName("http://www.iec.ch/61850/2006/SCL", "DataTypeTemplates");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.smarteps.ru.smarteps.scl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TServices }
     * 
     */
    public TServices createTServices() {
        return new TServices();
    }

    /**
     * Create an instance of {@link TServer }
     * 
     */
    public TServer createTServer() {
        return new TServer();
    }

    /**
     * Create an instance of {@link TSampledValueControl }
     * 
     */
    public TSampledValueControl createTSampledValueControl() {
        return new TSampledValueControl();
    }

    /**
     * Create an instance of {@link TReportControl }
     * 
     */
    public TReportControl createTReportControl() {
        return new TReportControl();
    }

    /**
     * Create an instance of {@link THeader }
     * 
     */
    public THeader createTHeader() {
        return new THeader();
    }

    /**
     * Create an instance of {@link TSubstation }
     * 
     */
    public TSubstation createTSubstation() {
        return new TSubstation();
    }

    /**
     * Create an instance of {@link TLN }
     * 
     */
    public TLN createTLN() {
        return new TLN();
    }

    /**
     * Create an instance of {@link TDataTypeTemplates }
     * 
     */
    public TDataTypeTemplates createTDataTypeTemplates() {
        return new TDataTypeTemplates();
    }

    /**
     * Create an instance of {@link TIED }
     * 
     */
    public TIED createTIED() {
        return new TIED();
    }

    /**
     * Create an instance of {@link SCL }
     * 
     */
    public SCL createSCL() {
        return new SCL();
    }

    /**
     * Create an instance of {@link TText }
     * 
     */
    public TText createTText() {
        return new TText();
    }

    /**
     * Create an instance of {@link TPrivate }
     * 
     */
    public TPrivate createTPrivate() {
        return new TPrivate();
    }

    /**
     * Create an instance of {@link TCommunication }
     * 
     */
    public TCommunication createTCommunication() {
        return new TCommunication();
    }

    /**
     * Create an instance of {@link LN0 }
     * 
     */
    public LN0 createLN0() {
        return new LN0();
    }

    /**
     * Create an instance of {@link TLN0 }
     * 
     */
    public TLN0 createTLN0() {
        return new TLN0();
    }

    /**
     * Create an instance of {@link TDataSet }
     * 
     */
    public TDataSet createTDataSet() {
        return new TDataSet();
    }

    /**
     * Create an instance of {@link TLogControl }
     * 
     */
    public TLogControl createTLogControl() {
        return new TLogControl();
    }

    /**
     * Create an instance of {@link TDOI }
     * 
     */
    public TDOI createTDOI() {
        return new TDOI();
    }

    /**
     * Create an instance of {@link TInputs }
     * 
     */
    public TInputs createTInputs() {
        return new TInputs();
    }

    /**
     * Create an instance of {@link TGSEControl }
     * 
     */
    public TGSEControl createTGSEControl() {
        return new TGSEControl();
    }

    /**
     * Create an instance of {@link TSettingControl }
     * 
     */
    public TSettingControl createTSettingControl() {
        return new TSettingControl();
    }

    /**
     * Create an instance of {@link TSCLControl }
     * 
     */
    public TSCLControl createTSCLControl() {
        return new TSCLControl();
    }

    /**
     * Create an instance of {@link TLog }
     * 
     */
    public TLog createTLog() {
        return new TLog();
    }

    /**
     * Create an instance of {@link TPOSIAPTitle }
     * 
     */
    public TPOSIAPTitle createTPOSIAPTitle() {
        return new TPOSIAPTitle();
    }

    /**
     * Create an instance of {@link TEnumType }
     * 
     */
    public TEnumType createTEnumType() {
        return new TEnumType();
    }

    /**
     * Create an instance of {@link TDOType }
     * 
     */
    public TDOType createTDOType() {
        return new TDOType();
    }

    /**
     * Create an instance of {@link TSDI }
     * 
     */
    public TSDI createTSDI() {
        return new TSDI();
    }

    /**
     * Create an instance of {@link TReportSettings }
     * 
     */
    public TReportSettings createTReportSettings() {
        return new TReportSettings();
    }

    /**
     * Create an instance of {@link TPOSIPSEL }
     * 
     */
    public TPOSIPSEL createTPOSIPSEL() {
        return new TPOSIPSEL();
    }

    /**
     * Create an instance of {@link TPVLANID }
     * 
     */
    public TPVLANID createTPVLANID() {
        return new TPVLANID();
    }

    /**
     * Create an instance of {@link TSDO }
     * 
     */
    public TSDO createTSDO() {
        return new TSDO();
    }

    /**
     * Create an instance of {@link TClientLN }
     * 
     */
    public TClientLN createTClientLN() {
        return new TClientLN();
    }

    /**
     * Create an instance of {@link TEnumVal }
     * 
     */
    public TEnumVal createTEnumVal() {
        return new TEnumVal();
    }

    /**
     * Create an instance of {@link TConductingEquipment }
     * 
     */
    public TConductingEquipment createTConductingEquipment() {
        return new TConductingEquipment();
    }

    /**
     * Create an instance of {@link TPhysConn }
     * 
     */
    public TPhysConn createTPhysConn() {
        return new TPhysConn();
    }

    /**
     * Create an instance of {@link TServiceWithMax }
     * 
     */
    public TServiceWithMax createTServiceWithMax() {
        return new TServiceWithMax();
    }

    /**
     * Create an instance of {@link TBay }
     * 
     */
    public TBay createTBay() {
        return new TBay();
    }

    /**
     * Create an instance of {@link TServiceWithMaxAndModify }
     * 
     */
    public TServiceWithMaxAndModify createTServiceWithMaxAndModify() {
        return new TServiceWithMaxAndModify();
    }

    /**
     * Create an instance of {@link TAddress }
     * 
     */
    public TAddress createTAddress() {
        return new TAddress();
    }

    /**
     * Create an instance of {@link TVal }
     * 
     */
    public TVal createTVal() {
        return new TVal();
    }

    /**
     * Create an instance of {@link TLNode }
     * 
     */
    public TLNode createTLNode() {
        return new TLNode();
    }

    /**
     * Create an instance of {@link TPOSISSEL }
     * 
     */
    public TPOSISSEL createTPOSISSEL() {
        return new TPOSISSEL();
    }

    /**
     * Create an instance of {@link TTransformerWinding }
     * 
     */
    public TTransformerWinding createTTransformerWinding() {
        return new TTransformerWinding();
    }

    /**
     * Create an instance of {@link TValueWithUnit }
     * 
     */
    public TValueWithUnit createTValueWithUnit() {
        return new TValueWithUnit();
    }

    /**
     * Create an instance of {@link TFunction }
     * 
     */
    public TFunction createTFunction() {
        return new TFunction();
    }

    /**
     * Create an instance of {@link TPOSIAPInvoke }
     * 
     */
    public TPOSIAPInvoke createTPOSIAPInvoke() {
        return new TPOSIAPInvoke();
    }

    /**
     * Create an instance of {@link TPVLANPRIORITY }
     * 
     */
    public TPVLANPRIORITY createTPVLANPRIORITY() {
        return new TPVLANPRIORITY();
    }

    /**
     * Create an instance of {@link TDAI }
     * 
     */
    public TDAI createTDAI() {
        return new TDAI();
    }

    /**
     * Create an instance of {@link TGeneralEquipment }
     * 
     */
    public TGeneralEquipment createTGeneralEquipment() {
        return new TGeneralEquipment();
    }

    /**
     * Create an instance of {@link TLogSettings }
     * 
     */
    public TLogSettings createTLogSettings() {
        return new TLogSettings();
    }

    /**
     * Create an instance of {@link TPOSINSAP }
     * 
     */
    public TPOSINSAP createTPOSINSAP() {
        return new TPOSINSAP();
    }

    /**
     * Create an instance of {@link TConnectedAP }
     * 
     */
    public TConnectedAP createTConnectedAP() {
        return new TConnectedAP();
    }

    /**
     * Create an instance of {@link TConnectivityNode }
     * 
     */
    public TConnectivityNode createTConnectivityNode() {
        return new TConnectivityNode();
    }

    /**
     * Create an instance of {@link TTapChanger }
     * 
     */
    public TTapChanger createTTapChanger() {
        return new TTapChanger();
    }

    /**
     * Create an instance of {@link TP }
     * 
     */
    public TP createTP() {
        return new TP();
    }

    /**
     * Create an instance of {@link TPIP }
     * 
     */
    public TPIP createTPIP() {
        return new TPIP();
    }

    /**
     * Create an instance of {@link TTerminal }
     * 
     */
    public TTerminal createTTerminal() {
        return new TTerminal();
    }

    /**
     * Create an instance of {@link TSubNetwork }
     * 
     */
    public TSubNetwork createTSubNetwork() {
        return new TSubNetwork();
    }

    /**
     * Create an instance of {@link TPIPGATEWAY }
     * 
     */
    public TPIPGATEWAY createTPIPGATEWAY() {
        return new TPIPGATEWAY();
    }

    /**
     * Create an instance of {@link TPOSIAEQualifier }
     * 
     */
    public TPOSIAEQualifier createTPOSIAEQualifier() {
        return new TPOSIAEQualifier();
    }

    /**
     * Create an instance of {@link THitem }
     * 
     */
    public THitem createTHitem() {
        return new THitem();
    }

    /**
     * Create an instance of {@link TSMV }
     * 
     */
    public TSMV createTSMV() {
        return new TSMV();
    }

    /**
     * Create an instance of {@link TBDA }
     * 
     */
    public TBDA createTBDA() {
        return new TBDA();
    }

    /**
     * Create an instance of {@link TControlWithIEDName }
     * 
     */
    public TControlWithIEDName createTControlWithIEDName() {
        return new TControlWithIEDName();
    }

    /**
     * Create an instance of {@link TConfLNs }
     * 
     */
    public TConfLNs createTConfLNs() {
        return new TConfLNs();
    }

    /**
     * Create an instance of {@link TBitRateInMbPerSec }
     * 
     */
    public TBitRateInMbPerSec createTBitRateInMbPerSec() {
        return new TBitRateInMbPerSec();
    }

    /**
     * Create an instance of {@link TRptEnabled }
     * 
     */
    public TRptEnabled createTRptEnabled() {
        return new TRptEnabled();
    }

    /**
     * Create an instance of {@link TSMVSettings }
     * 
     */
    public TSMVSettings createTSMVSettings() {
        return new TSMVSettings();
    }

    /**
     * Create an instance of {@link TPOSITSEL }
     * 
     */
    public TPOSITSEL createTPOSITSEL() {
        return new TPOSITSEL();
    }

    /**
     * Create an instance of {@link TPIPSUBNET }
     * 
     */
    public TPIPSUBNET createTPIPSUBNET() {
        return new TPIPSUBNET();
    }

    /**
     * Create an instance of {@link TServiceYesNo }
     * 
     */
    public TServiceYesNo createTServiceYesNo() {
        return new TServiceYesNo();
    }

    /**
     * Create an instance of {@link TServiceWithMaxAndMaxAttributesAndModify }
     * 
     */
    public TServiceWithMaxAndMaxAttributesAndModify createTServiceWithMaxAndMaxAttributesAndModify() {
        return new TServiceWithMaxAndMaxAttributesAndModify();
    }

    /**
     * Create an instance of {@link TGSESettings }
     * 
     */
    public TGSESettings createTGSESettings() {
        return new TGSESettings();
    }

    /**
     * Create an instance of {@link TExtRef }
     * 
     */
    public TExtRef createTExtRef() {
        return new TExtRef();
    }

    /**
     * Create an instance of {@link TPOSIAEInvoke }
     * 
     */
    public TPOSIAEInvoke createTPOSIAEInvoke() {
        return new TPOSIAEInvoke();
    }

    /**
     * Create an instance of {@link TClientServices }
     * 
     */
    public TClientServices createTClientServices() {
        return new TClientServices();
    }

    /**
     * Create an instance of {@link TSubFunction }
     * 
     */
    public TSubFunction createTSubFunction() {
        return new TSubFunction();
    }

    /**
     * Create an instance of {@link TLNodeType }
     * 
     */
    public TLNodeType createTLNodeType() {
        return new TLNodeType();
    }

    /**
     * Create an instance of {@link TVoltage }
     * 
     */
    public TVoltage createTVoltage() {
        return new TVoltage();
    }

    /**
     * Create an instance of {@link TPowerTransformer }
     * 
     */
    public TPowerTransformer createTPowerTransformer() {
        return new TPowerTransformer();
    }

    /**
     * Create an instance of {@link TVoltageLevel }
     * 
     */
    public TVoltageLevel createTVoltageLevel() {
        return new TVoltageLevel();
    }

    /**
     * Create an instance of {@link TPMACAddress }
     * 
     */
    public TPMACAddress createTPMACAddress() {
        return new TPMACAddress();
    }

    /**
     * Create an instance of {@link TGSE }
     * 
     */
    public TGSE createTGSE() {
        return new TGSE();
    }

    /**
     * Create an instance of {@link TFCCB }
     * 
     */
    public TFCCB createTFCCB() {
        return new TFCCB();
    }

    /**
     * Create an instance of {@link TDAType }
     * 
     */
    public TDAType createTDAType() {
        return new TDAType();
    }

    /**
     * Create an instance of {@link TAssociation }
     * 
     */
    public TAssociation createTAssociation() {
        return new TAssociation();
    }

    /**
     * Create an instance of {@link TDurationInSec }
     * 
     */
    public TDurationInSec createTDurationInSec() {
        return new TDurationInSec();
    }

    /**
     * Create an instance of {@link TServiceWithMaxAndMaxAttributes }
     * 
     */
    public TServiceWithMaxAndMaxAttributes createTServiceWithMaxAndMaxAttributes() {
        return new TServiceWithMaxAndMaxAttributes();
    }

    /**
     * Create an instance of {@link TPAPPID }
     * 
     */
    public TPAPPID createTPAPPID() {
        return new TPAPPID();
    }

    /**
     * Create an instance of {@link TFCDA }
     * 
     */
    public TFCDA createTFCDA() {
        return new TFCDA();
    }

    /**
     * Create an instance of {@link TDA }
     * 
     */
    public TDA createTDA() {
        return new TDA();
    }

    /**
     * Create an instance of {@link TAccessPoint }
     * 
     */
    public TAccessPoint createTAccessPoint() {
        return new TAccessPoint();
    }

    /**
     * Create an instance of {@link TAccessControl }
     * 
     */
    public TAccessControl createTAccessControl() {
        return new TAccessControl();
    }

    /**
     * Create an instance of {@link TDurationInMilliSec }
     * 
     */
    public TDurationInMilliSec createTDurationInMilliSec() {
        return new TDurationInMilliSec();
    }

    /**
     * Create an instance of {@link TSubEquipment }
     * 
     */
    public TSubEquipment createTSubEquipment() {
        return new TSubEquipment();
    }

    /**
     * Create an instance of {@link TTrgOps }
     * 
     */
    public TTrgOps createTTrgOps() {
        return new TTrgOps();
    }

    /**
     * Create an instance of {@link TDO }
     * 
     */
    public TDO createTDO() {
        return new TDO();
    }

    /**
     * Create an instance of {@link TLDevice }
     * 
     */
    public TLDevice createTLDevice() {
        return new TLDevice();
    }

    /**
     * Create an instance of {@link TServices.SettingGroups }
     * 
     */
    public TServices.SettingGroups createTServicesSettingGroups() {
        return new TServices.SettingGroups();
    }

    /**
     * Create an instance of {@link TServer.Authentication }
     * 
     */
    public TServer.Authentication createTServerAuthentication() {
        return new TServer.Authentication();
    }

    /**
     * Create an instance of {@link TSampledValueControl.SmvOpts }
     * 
     */
    public TSampledValueControl.SmvOpts createTSampledValueControlSmvOpts() {
        return new TSampledValueControl.SmvOpts();
    }

    /**
     * Create an instance of {@link TReportControl.OptFields }
     * 
     */
    public TReportControl.OptFields createTReportControlOptFields() {
        return new TReportControl.OptFields();
    }

    /**
     * Create an instance of {@link THeader.History }
     * 
     */
    public THeader.History createTHeaderHistory() {
        return new THeader.History();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TCommunication }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.iec.ch/61850/2006/SCL", name = "Communication")
    public JAXBElement<TCommunication> createCommunication(TCommunication value) {
        return new JAXBElement<TCommunication>(_Communication_QNAME, TCommunication.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TIED }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.iec.ch/61850/2006/SCL", name = "IED")
    public JAXBElement<TIED> createIED(TIED value) {
        return new JAXBElement<TIED>(_IED_QNAME, TIED.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TSubstation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.iec.ch/61850/2006/SCL", name = "Substation")
    public JAXBElement<TSubstation> createSubstation(TSubstation value) {
        return new JAXBElement<TSubstation>(_Substation_QNAME, TSubstation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TLN }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.iec.ch/61850/2006/SCL", name = "LN")
    public JAXBElement<TLN> createLN(TLN value) {
        return new JAXBElement<TLN>(_LN_QNAME, TLN.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TDataTypeTemplates }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.iec.ch/61850/2006/SCL", name = "DataTypeTemplates")
    public JAXBElement<TDataTypeTemplates> createDataTypeTemplates(TDataTypeTemplates value) {
        return new JAXBElement<TDataTypeTemplates>(_DataTypeTemplates_QNAME, TDataTypeTemplates.class, null, value);
    }

}
