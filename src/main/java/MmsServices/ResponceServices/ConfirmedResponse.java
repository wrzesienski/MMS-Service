package MmsServices.ResponceServices;

import MmsServices.BuildPointer;
import MmsServices.HighStructServiceBody;
import MmsServices.ResponceServices.VmdServices.GetNameListResponse;
import MmsServices.ResponceServices.VmdServices.IdentifyResponse;
import MmsServices.ResponceServices.VmdServices.StatusResponse;
import Old.Response.VariablesServices.ReadResponse;

/*
ConfirmedServiceResponse  ::= CHOICE
	{
	status							[0]	IMPLICIT Status-Response,
	getNameList						[1]	IMPLICIT GetNameList-Response,
	identify						[2]	IMPLICIT Identify-Response,
	rename							[3]	IMPLICIT Rename-Response,
	read							[4]	IMPLICIT Read-Response,
	write							[5]	IMPLICIT Write-Response,
	getVariableAccessAttributes		[6]	IMPLICIT GetVariableAccessAttributes-Response,
	defineNamedVariable				[7]	IMPLICIT DefineNamedVariable-Response,
	defineScatteredAccess			[8]	IMPLICIT DefineScatteredAccess-Response,
	getScatteredAccessAttributes	[9]	IMPLICIT GetScatteredAccessAttributes-Response,
	deleteVariableAccess			[10]	IMPLICIT DeleteVariableAccess-Response,
	defineNamedVariableList			[11]	IMPLICIT DefineNamedVariableList-Response,
	getNamedVariableListAttributes	[12]	IMPLICIT GetNamedVariableListAttributes-Response,
	deleteNamedVariableList			[13]	IMPLICIT DeleteNamedVariableList-Response,
	defineNamedType					[14]	IMPLICIT DefineNamedType-Response,
	getNamedTypeAttributes			[15]	IMPLICIT GetNamedTypeAttributes-Response,
	deleteNamedType					[16]	IMPLICIT DeleteNamedType-Response,
	input							[17]	IMPLICIT Input-Response,
	output							[18]	IMPLICIT Output-Response,
	takeControl						[19]	TakeControl-Response,
	relinquishControl				[20]	IMPLICIT RelinquishControl-Response,
	defineSemaphore					[21]	IMPLICIT DefineSemaphore-Response,
	deleteSemaphore					[22]	IMPLICIT DeleteSemaphore-Response,
	reportSemaphoreStatus			[23]	IMPLICIT ReportSemaphoreStatus-Response,
	reportPoolSemaphoreStatus		[24]	IMPLICIT ReportPoolSemaphoreStatus-Response,
	reportSemaphoreEntryStatus		[25]	IMPLICIT ReportSemaphoreEntryStatus-Response,
	initiateDownloadSequence		[26]	IMPLICIT InitiateDownloadSequence-Response,
	downloadSegment					[27]	IMPLICIT DownloadSegment-Response,
	terminateDownloadSequence		[28]	IMPLICIT TerminateDownloadSequence-Response,
	initiateUploadSequence			[29]	IMPLICIT InitiateUploadSequence-Response,
	uploadSegment					[30]	IMPLICIT UploadSegment-Response,
	terminateUploadSequence			[31]	IMPLICIT TerminateUploadSequence-Response,
	requestDomainDownLoad			[32]	IMPLICIT RequestDomainDownload-Response,
	requestDomainUpload				[33]	IMPLICIT RequestDomainUpload-Response,
	loadDomainContent				[34]	IMPLICIT LoadDomainContent-Response,
	storeDomainContent				[35]	IMPLICIT StoreDomainContent-Response,
	deleteDomain					[36]	IMPLICIT DeleteDomain-Response,
	getDomainAttributes				[37]	IMPLICIT GetDomainAttributes-Response,
	createProgramInvocation			[38]	IMPLICIT CreateProgramInvocation-Response,
	deleteProgramInvocation			[39]	IMPLICIT DeleteProgramInvocation-Response,
	start							[40]	IMPLICIT Start-Response,
	stop							[41]	IMPLICIT Stop-Response,
	resume							[42]	IMPLICIT Resume-Response,
	reset							[43]	IMPLICIT Reset-Response,
	kill							[44]	IMPLICIT Kill-Response,
	getProgramInvocationAttributes	[45]	IMPLICIT GetProgramInvocationAttributes-Response,
	obtainFile						[46]	IMPLICIT ObtainFile-Response,
	fileOpen						[72]	IMPLICIT FileOpen-Response,
	defineEventCondition			[47]	IMPLICIT DefineEventCondition-Response,
	deleteEventCondition			[48]	IMPLICIT DeleteEventCondition-Response,
	getEventConditionAttributes		[49]	IMPLICIT GetEventConditionAttributes-Response,
	reportEventConditionStatus		[50]	IMPLICIT ReportEventConditionStatus-Response,
	alterEventConditionMonitoring	[51]	IMPLICIT AlterEventConditionMonitoring-Response,
	triggerEvent					[52]	IMPLICIT TriggerEvent-Response,
	defineEventAction				[53]	IMPLICIT DefineEventAction-Response,
	deleteEventAction				[54]	IMPLICIT DeleteEventAction-Response,
	getEventActionAttributes		[55]	IMPLICIT GetEventActionAttributes-Response,
	reportActionStatus				[56]	IMPLICIT ReportEventActionStatus-Response,
	defineEventEnrollment			[57]	IMPLICIT DefineEventEnrollment-Response,
	deleteEventEnrollment			[58]	IMPLICIT DeleteEventEnrollment-Response,
	alterEventEnrollment			[59]	IMPLICIT AlterEventEnrollment-Response,
	reportEventEnrollmentStatus		[60]	IMPLICIT ReportEventEnrollmentStatus-Response,
	getEventEnrollmentAttributes	[61]	IMPLICIT GetEventEnrollmentAttributes-Response,
	acknowledgeEventNotification	[62]	IMPLICIT AcknowledgeEventNotification-Response,
	getAlarmSummary					[63]	IMPLICIT GetAlarmSummary-Response,
	getAlarmEnrollmentSummary		[64]	IMPLICIT GetAlarmEnrollmentSummary-Response,
	readJournal						[65]	IMPLICIT ReadJournal-Response,
	writeJournal					[66]	IMPLICIT WriteJournal-Response,
	initializeJournal				[67]	IMPLICIT InitializeJournal-Response,
	reportJournalStatus				[68]	IMPLICIT ReportJournalStatus-Response,
	createJournal					[69]	IMPLICIT CreateJournal-Response,
	deleteJournal					[70]	IMPLICIT DeleteJournal-Response,
	getCapabilityList				[71]	IMPLICIT GetCapabilityList-Response,
	fileRead						[73]	IMPLICIT FileRead-Response,
	fileClose						[74]	IMPLICIT FileClose-Response,
	fileRename						[75]	IMPLICIT FileRename-Response,
	fileDelete						[76]	IMPLICIT FileDelete-Response,
	fileDirectory					[77]	IMPLICIT FileDirectory-Response
 */

public class ConfirmedResponse extends HighStructServiceBody {

    public ConfirmedResponse(){super(ServiceType.CHOICE);}

    @Override
    public String choice(int tag) {
        switch (tag) {
            case 0: // StatusRequest
                return new StatusResponse().process(null, getIed()); // here should be bool
            case 1:
                return new GetNameListResponse().process(getData(), getIed());
            case 2: // IdentifyRequest
                return new IdentifyResponse().process(getData(), getIed()); // here should be bool
            case 3:
                return null;
            case 4:
                return new ReadResponse().process(getData(), getIed());
            case 5:
                return null;
//            case 71: // GetCapabilityList
//                return new ConfirmedResponse().build(getVmd().getCapabList());
            default:
                return null;
        }
    }

    @Override
    public String build(String data) {
        return BuildPointer.getParent(this, data);
    }

}
