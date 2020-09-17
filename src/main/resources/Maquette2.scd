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
              <LN lnClass="LPHD" lnType="LPHD1" inst="1" prefix="" />
              <LN lnClass="MMXU" lnType="MMXU1" inst="1" prefix="">
                <DOI name="Mod">
                  <DAI name="ctlModel">
                    <Val>status-only</Val>
                  </DAI>
                </DOI>
              </LN>
              <LN lnClass="CSWI" lnType="CSWI1" inst="1" prefix="">
                <DOI name="Mod">
                  <DAI name="ctlModel">
                    <Val>status-only</Val>
                  </DAI>
                </DOI>
                <DOI name="Pos">
                  <DAI name="ctlModel">
                    <Val>direct-with-normal-security</Val>
                  </DAI>
                </DOI>
                <DOI name="PosA">
                  <DAI name="sboTimeout">
                    <Val>1000</Val>
                  </DAI>
                  <DAI name="ctlModel">
                    <Val>sbo-with-normal-security</Val>
                  </DAI>
                </DOI>
                <DOI name="PosB">
                  <DAI name="ctlModel">
                    <Val>direct-with-enhanced-security</Val>
                  </DAI>
                </DOI>
                <DOI name="PosC">
                  <DAI name="ctlModel">
                    <Val>sbo-with-enhanced-security</Val>
                  </DAI>
                </DOI>
              </LN>
              <LN lnClass="DSCH" lnType="DSCH1" inst="1" prefix="">
                <DOI name="Mod">
                  <DAI name="ctlModel">
                    <Val>status-only</Val>
                  </DAI>
                </DOI>


              </LN>
               <LN lnClass="SIMG" inst="inst">
                  <EEHealth></EEHealth>
                  <EEName></EEName>
                  <DAI name="Pres">
                      <instMag></instMag>
                      <q>
                          <validity>good</validity>
                      </q>
                      <t>
                          <SecondSinceEpoch>good</SecondSinceEpoch>
                      </t>
                  </DAI>
                  <DAI name="Pres">
                      <instMag></instMag>
                      <q>
                          <validity>good</validity>
                      </q>
                      <t>
                          <SecondSinceEpoch>good</SecondSinceEpoch>
                      </t>
                  </DAI>
                  <DAI name="Temp">
                      <instMag></instMag>
                      <q>
                          <validity>good</validity>
                      </q>
                      <t>
                          <SecondSinceEpoch>good</SecondSinceEpoch>
                      </t>
                  </DAI>
                  <DAI name="InsAlm">
                        <stVal name="stVal">1</stVal>
                          <q>
                              <validity>good</validity>
                          </q>
                          <t>
                              <SecondSinceEpoch>good</SecondSinceEpoch>
                          </t>
                  </DAI>
                  <DAI name="InsBlk">
                        <stVal name="stVal">1</stVal>
                          <q>
                              <validity>good</validity>
                          </q>
                          <t>
                              <SecondSinceEpoch>good</SecondSinceEpoch>
                          </t>
                  </DAI>
                  <DAI name="InsTr">
                        <stVal name="stVal">1</stVal>
                          <q>
                              <validity>good</validity>
                          </q>
                          <t>
                              <SecondSinceEpoch>good</SecondSinceEpoch>
                          </t>
                  </DAI>

                  <ReportControl name="ExpModel" desc="anything"></ReportControl>
                  <LogControl name="ExpModel" desc="anything"></LogControl>
                  <DOI name="ExpModel" desc="anything"></DOI>
                  <Inputs name="ExpModel" desc="anything"></Inputs>
              </LN>
            </LDevice>
          </Server>
        </AccessPoint>
      </IED>

</SCL>