<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<SCL xmlns="http://www.iec.ch/61850/2006/SCL">
    <Private type="Siemens-SclLib-V5-Version">V03.10.02.000</Private>
    <Private type="Siemens-SclLib-V5-EditTime">05.05.2019 14:23:08</Private>
    <Private type="Siemens-Configurator-Version">V5.80 HF1</Private>
    <Header id="PSI" version="3" revision="5" toolID="IEC 61850 System Configurator, Version: V5.80 HF1" nameStructure="IEDName">
        <Text>PIG</Text>
        <History>
            <Hitem version="1" revision="1" when="18.04.2019 20:42:58" who="SCL Manager" what="Modifications" why="Improvements"/>
            <Hitem version="2" revision="2" when="18.04.2019 20:53:58" who="SCL Manager" what="Modifications" why="Improvements"/>
            <Hitem version="3" revision="3" when="18.04.2019 20:59:44" who="SCL Manager" what="Modifications" why="Improvements"/>
            <Hitem version="3" revision="4" when="Thursday, April 18, 2019 9:01:57 PM" who="Licenced User: NRU MPEI IDianaM Machine: MICROSOFTI User: diana" what="Automatic archive done at : C:\Users\diana\Desktop\PIG\Archive\_20190418_210157.sz" why="IEC 61850 System Configurator Automatic Startup: Insert Comment"/>
            <Hitem version="3" revision="5" when="Thursday, April 18, 2019 9:01:57 PM" who="Licenced User: NRU MPEI IDianaM Machine: MICROSOFTI User: diana" what="Station is upgraded from SCL Manager to V5.80 HF1." why="IEC 61850 System Configurator Automatic Startup: Insert Comment"/>
        </History>
    </Header>
    <IED name="ied1">
        <Services>
            <Service name="GetNameList"/>
        </Services>
        <AccessPoint name="accessPoint1">
            <Server>
                <Authentication/>
                <LDevice inst="lDevice1">
                    <LN0 lnClass="LLN0" inst="" lnType="LLN01">
                        <DataSet name="dataset1" desc="">
                            <FCDA ldInst="lDevice1" lnClass="MMXU" lnInst="1" doName="TotW" fc="MX"/>
                            <FCDA ldInst="lDevice1" lnClass="MMXU" lnInst="1" doName="W.phsA" daName="cVal.mag.f" fc="MX"/>
                        </DataSet>
                        <ReportControl rptID="urcb1" confRev="0" bufTime="0" intgPd="5000" datSet="dataset1" name="urcb1">
                            <TrgOps dchg="true" qchg="true" dupd="true" period="true"/>
                            <OptFields seqNum="true" timeStamp="true" dataSet="true" reasonCode="true" dataRef="false" bufOvfl="false" entryID="true" configRef="true"/>
                            <RptEnabled max="3"/>
                        </ReportControl>
                        <ReportControl confRev="0" bufTime="0" intgPd="0" datSet="dataset1" name="urcb2">
                            <TrgOps/>
                            <OptFields/>
                        </ReportControl>
                        <DOI name="Mod">
                            <DAI name="ctlModel">
<Val>status-only</Val>
                            </DAI>
                        </DOI>
                    </LN0>
                    <LN lnClass="SIMG" inst="1" prefix="" lnType="SIMG1">
                        <ReportControl confRev="0" bufTime="0" intgPd="0" datSet="PresAlm" name="urcb3"/>
                        <ReportControl confRev="0" bufTime="0" intgPd="0" datSet="DenAlm" name="urcb4"/>
                        <ReportControl confRev="0" bufTime="0" intgPd="0" datSet="TempAlm" name="urcb5"/>
                        <LogControl name="ExpModel" desc="anything"/>
                        <DOI name="Pres">
                            <DAI name="instMag">
<Val></Val>
                            </DAI>
                        </DOI>
                        <DOI name="Den">
                            <DAI name="instMag">
<Val></Val>
                            </DAI>
                        </DOI>
                        <DOI name="Temp">
                            <DAI name="instMag">
<Val></Val>
                            </DAI>
                        </DOI>
                        <DOI name="PresAlm">
                            <DAI name="stVal">
<Val></Val>
                            </DAI>
                        </DOI>
                        <DOI name="DenAlm">
                            <DAI name="stVal">
<Val></Val>
                            </DAI>
                        </DOI>
                        <DOI name="TempAlm">
                            <DAI name="stVal">
<Val></Val>
                            </DAI>
                        </DOI>
                        <Inputs desc="anything" name="ExpModel"/>
                    </LN>
                    <LN lnClass="PDIS" inst="1" prefix="" lnType="PDIS1">
                        <ReportControl confRev="0" bufTime="0" intgPd="0" datSet="Str" name="urcb2"/>
                        <LogControl name="ExpModel" desc="anything"/>
                        <DOI name="BlkZn">
                            <DAI name="instMag">
<Val></Val>
                            </DAI>
                        </DOI>
                        <DOI name="CutTrip">
                            <DAI name="instMag">
<Val></Val>
                            </DAI>
                        </DOI>
                        <DOI name="Str">
                            <DAI name="instMag">
<Val></Val>
                            </DAI>
                        </DOI>
                        <Inputs desc="anything" name="ExpModel"/>
                    </LN>
                    <LN lnClass="CSWI" inst="1" prefix="" lnType="CSWI1">
                        <ReportControl confRev="0" bufTime="0" intgPd="0" datSet="Mod" name="urcb2"/>
                        <DOI name="Mod">
                            <DAI name="ctlVal">
<Val>1</Val>
                            </DAI>
                        </DOI>
                        <DOI name="OpOpn">
                            <DAI name="ctlVal">
<Val>1</Val>
                            </DAI>
                        </DOI>
                        <DOI name="OpCls">
                            <DAI name="ctlVal">
<Val>1</Val>
                            </DAI>
                        </DOI>
                    </LN>
                </LDevice>
            </Server>
        </AccessPoint>
    </IED>
</SCL>
