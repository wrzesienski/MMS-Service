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
	<IED name="ExpModel" desc="anything">
	    <Services></Services>
	    <AccessPoint name="ExpModel" desc="anything">
            <Server desc="ExpModel" timeout="normalizedString">
                <Authentication none="1"></Authentication>
                <LDevice desc="ExpModel" normalizedString="anything">
                    <LN0 name="ExpModel" desc="anything">
                        <GSEControl name="ExpModel" desc="anything"></GSEControl>
                        <SampledValueControl name="ExpModel" desc="anything"></SampledValueControl>
                        <SettingControl numOfSGs="numOfSGs" desc="anything"></SettingControl>
                        <SCLControl name="ExpModel" desc="anything"></SCLControl>
                        <Log name="ExpModel" desc="anything"></Log>
                        <DataSet name="ExpModel" desc="anything">
                        </DataSet>
                        <ReportControl name="ExpModel" desc="anything"></ReportControl>
                        <LogControl name="ExpModel" desc="anything"></LogControl>
                        <DOI name="ExpModel" desc="anything"></DOI>
                        <Inputs name="ExpModel" desc="anything"></Inputs>
                        <Loc name="Loc">
                            <stVal name="stVal">0</stVal>
                             <q>
                                <validity>good</validity>
                            </q>
                            <t>
                                <SecondSinceEpoch>good</SecondSinceEpoch>
                            </t>
                        </Loc>
                        <opTmh>
                            <stVal name="stVal">1</stVal>
                            <q>
                                <validity>good</validity>
                            </q>
                            <t>
                                <SecondSinceEpoch>good</SecondSinceEpoch>
                            </t>
                        </opTmh>
                     </LN0>
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

                    <LN lnClass="XCBR1" inst="inst">
                    <Loc></Loc>
                    <EEHealth></EEHealth>
                    <EEName></EEName>
                    <OpCnt></OpCnt>
                    <BlkOpn></BlkOpn>
                    <BlkCls></BlkCls>
                    <ChaMotEna></ChaMotEna>
                    <SumSWARs></ChaMotEna>
                    </LN>

                    <LN lnClass="XCBR2" inst="inst">
                    <Loc></Loc>
                    <EEHealth></EEHealth>
                    <EEName></EEName>
                    <OpCnt></OpCnt>
                    <BlkOpn></BlkOpn>
                    <BlkCls></BlkCls>
                    <ChaMotEna></ChaMotEna>
                    <SumSWARs></ChaMotEna>
                    </LN>

                </LDevice>
                <Association kind="kind" associationID="associationID"
                    prefix="prefix" lnClass="lnClass" lnInst="lnInst"
                    iedName="iedName" ldInst="ldInst">
                </Association>
            </Server>
	    </AccessPoint>
	</IED>

</SCL>