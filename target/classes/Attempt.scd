<?xml version="1.0" encoding="UTF-8"?>
<SCL xmlns:sxy="http://www.iec.ch/61850/2006/SCLcoordinates" xmlns="http://www.iec.ch/61850/2006/SCL">
	<Private type="Siemens-SclLib-V5-Version">V03.10.02.000</Private>
	<Private type="Siemens-SclLib-V5-EditTime">05.05.2019 14:23:08</Private>
	<Private type="Siemens-Configurator-Version">V5.80 HF1</Private>
	<Header id="PSI" version="3" revision="5" toolID="IEC 61850 System Configurator, Version: V5.80 HF1" nameStructure="IEDName">
		<Text>PIG</Text>
		<History>
			<Hitem version="1" revision="1" when="18.04.2019 20:42:58" who="SCL Manager" what="Modifications" why="Improvements" />
			<Hitem version="2" revision="2" when="18.04.2019 20:53:58" who="SCL Manager" what="Modifications" why="Improvements" />
			<Hitem version="3" revision="3" when="18.04.2019 20:59:44" who="SCL Manager" what="Modifications" why="Improvements" />
			<Hitem version="3" revision="4" when="Thursday, April 18, 2019 9:01:57 PM" who="Licenced User: NRU MPEI IDianaM Machine: MICROSOFTI User: diana" what="Automatic archive done at : C:\Users\diana\Desktop\PIG\Archive\_20190418_210157.sz" why="IEC 61850 System Configurator Automatic Startup: Insert Comment" />
			<Hitem version="3" revision="5" when="Thursday, April 18, 2019 9:01:57 PM" who="Licenced User: NRU MPEI IDianaM Machine: MICROSOFTI User: diana" what="Station is upgraded from SCL Manager to V5.80 HF1." why="IEC 61850 System Configurator Automatic Startup: Insert Comment" />
		</History>
	</Header>

<IED name="ied1">
        <Services>
          <DynAssociation />
          <GetDirectory />
          <GetDataObjectDefinition />
          <GetDataSetValue />
          <DataSetDirectory />
          <ReadWrite />
          <GetCBValues />
          <ConfLNs fixPrefix="true" fixLnInst="true" />
          <GOOSE max="5" />
          <GSSE max="5" />
          <FileHandling />
          <GSEDir />
          <TimerActivatedControl />
        </Services>
        <AccessPoint name="accessPoint1">
          <Server>
            <Authentication />
            <LDevice inst="lDevice1">
              <LN0 lnClass="LLN0" lnType="LLN01" inst="">
                <DataSet name="dataset1" desc="">
                  <FCDA ldInst="lDevice1" lnClass="MMXU" fc="MX" lnInst="1" doName="TotW" />
                  <FCDA ldInst="lDevice1" lnClass="MMXU" fc="MX" lnInst="1" doName="W.phsA" daName="cVal.mag.f" />
                </DataSet>
                <ReportControl name="urcb1" confRev="0" datSet="dataset1" rptID="urcb1" intgPd="5000" bufTime="0">
                  <TrgOps dchg="true" qchg="true" dupd="true" period="true" gi="true" />
                  <OptFields dataSet="true" bufOvfl="false" configRef="true" dataRef="false" entryID="true" reasonCode="true" timeStamp="true" seqNum="true"/>
                  <RptEnabled max="3"/>
                </ReportControl>
                <ReportControl name="urcb2" confRev="0" datSet="dataset1" intgPd="0" bufTime="0">
                  <TrgOps />
                  <OptFields />
                </ReportControl>

                <DOI name="Mod">
                  <DAI name="ctlModel">
                    <Val>status-only</Val>
                  </DAI>
                </DOI>
              </LN0>

              <LN lnClass="SIMG" inst="1" prefix="" lnType="SIMG1">
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

                <ReportControl name="urcb2" confRev="0" datSet="PresAlm" intgPd="0" bufTime="0">
                </ReportControl>

                <ReportControl name="urcb2" confRev="0" datSet="DenAlm" intgPd="0" bufTime="0">
                </ReportControl>

                <ReportControl name="urcb2" confRev="0" datSet="TempAlm" intgPd="0" bufTime="0">
                </ReportControl>

                    <LogControl name="ExpModel" desc="anything"></LogControl>
                    <Inputs name="ExpModel" desc="anything"></Inputs>
                </LN>

                <LN lnClass="PDIS" inst="1" prefix="" lnType="PDIS1">
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

                <ReportControl name="urcb2" confRev="0" datSet="Str" intgPd="0" bufTime="0">
                </ReportControl>

                   <LogControl name="ExpModel" desc="anything"></LogControl>
                   <Inputs name="ExpModel" desc="anything"></Inputs>
               </LN>


                 <LN lnClass="CSWI" lnType="CSWI1" inst="1" prefix="">
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

                   <ReportControl name="urcb2" confRev="0" datSet="Mod" intgPd="0" bufTime="0">
                </ReportControl>

                 </LN>

            </LDevice>
          </Server>
        </AccessPoint>
      </IED>
</SCL>