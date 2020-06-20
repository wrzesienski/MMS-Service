package MmsService.RequestServices;

import MmsService.AbstractService;
import MmsService.RequestServices.VariablesSevices.ReadRequest;
import MmsService.RequestServices.VariablesSevices.WriteRequest;
import MmsService.RequestServices.VmdServices.GetNameListRequest;
import MmsService.RequestServices.VmdServices.IdentifyRequest;
import MmsService.RequestServices.VmdServices.RenameRequest;
import MmsService.RequestServices.VmdServices.StatusRequest;
import res.IDK;

/*
    ConfirmedServiceRequest  ::= CHOICE
	{
    status						    [0]	IMPLICIT Status-Request,
	getNameList						[1] IMPLICIT GetNameList-Request,
	identify						[2]	IMPLICIT Identify-Request,
	rename							[3]	IMPLICIT Rename-Request,
	read							[4]	IMPLICIT Read-Request,
	write							[5]	IMPLICIT Write-Request,
	getVariableAccessAttributes		[6]	GetVariableAccessAttributes-Request,
	defineNamedVariable				[7]	IMPLICIT DefineNamedVariable-Request,
	defineScatteredAccess			[8]	IMPLICIT DefineScatteredAccess-Request,
	getScatteredAccessAttributes	[9]	IMPLICIT GetScatteredAccessAttributes-Request,
	deleteVariableAccess			[10] IMPLICIT DeleteVariableAccess-Request,
	defineNamedVariableList			[11] IMPLICIT DefineNamedVariableList-Request,
	getNamedVariableListAttributes	[12] IMPLICIT GetNamedVariableListAttributes-Request,
	deleteNamedVariableList			[13] IMPLICIT DeleteNamedVariableList-Request,
	defineNamedType					[14] IMPLICIT DefineNamedType-Request,
	getNamedTypeAttributes			[15] IMPLICIT GetNamedTypeAttributes-Request,
	deleteNamedType					[16] IMPLICIT DeleteNamedType-Request,
	input							[17] IMPLICIT Input-Request,
	output							[18] IMPLICIT Output-Request,
	takeControl						[19] IMPLICIT TakeControl-Request,
	relinquishControl				[20] IMPLICIT RelinquishControl-Request,
	defineSemaphore					[21] IMPLICIT DefineSemaphore-Request,
	deleteSemaphore					[22] IMPLICIT DeleteSemaphore-Request,
	reportSemaphoreStatus			[23] IMPLICIT ReportSemaphoreStatus-Request,
	reportPoolSemaphoreStatus		[24] IMPLICIT ReportPoolSemaphoreStatus-Request,
	reportSemaphoreEntryStatus		[25] IMPLICIT ReportSemaphoreEntryStatus-Request,
	initiateDownloadSequence		[26] IMPLICIT InitiateDownloadSequence-Request,
	downloadSegment					[27] IMPLICIT DownloadSegment-Request,
	terminateDownloadSequence		[28] IMPLICIT TerminateDownloadSequence-Request,
	initiateUploadSequence			[29] IMPLICIT InitiateUploadSequence-Request,
	uploadSegment					[30] IMPLICIT UploadSegment-Request,
	terminateUploadSequence			[31] IMPLICIT TerminateUploadSequence-Request,
	requestDomainDownload			[32] IMPLICIT RequestDomainDownload-Request,
	requestDomainUpload				[33] IMPLICIT RequestDomainUpload-Request,
	loadDomainContent				[34] IMPLICIT LoadDomainContent-Request,
	storeDomainContent				[35] IMPLICIT StoreDomainContent-Request,
	deleteDomain					[36] IMPLICIT DeleteDomain-Request,
	getDomainAttributes				[37] IMPLICIT GetDomainAttributes-Request,
	createProgramInvocation			[38] IMPLICIT CreateProgramInvocation-Request,
	deleteProgramInvocation			[39] IMPLICIT DeleteProgramInvocation-Request,
	start							[40] IMPLICIT Start-Request,
	stop							[41] IMPLICIT Stop-Request,
	resume							[42] IMPLICIT Resume-Request,
	reset							[43] IMPLICIT Reset-Request,
	kill							[44] IMPLICIT Kill-Request,
	getProgramInvocationAttributes	[45] IMPLICIT GetProgramInvocationAttributes-Request,
	obtainFile						[46] IMPLICIT ObtainFile-Request,
	defineEventCondition			[47] IMPLICIT DefineEventCondition-Request,
	deleteEventCondition			[48] DeleteEventCondition-Request,
	getEventConditionAttributes		[49] GetEventConditionAttributes-Request,
	reportEventConditionStatus		[50] ReportEventConditionStatus-Request,
	alterEventConditionMonitoring	[51] IMPLICIT AlterEventConditionMonitoring-Request,
	triggerEvent					[52] IMPLICIT TriggerEvent-Request,
	defineEventAction				[53] IMPLICIT DefineEventAction-Request,
	deleteEventAction				[54] DeleteEventAction-Request,
	getEventActionAttributes		[55] GetEventActionAttributes-Request,
	reportEventActionStatus			[56] ReportEventActionStatus-Request,
	defineEventEnrollment			[57] IMPLICIT DefineEventEnrollment-Request,
	deleteEventEnrollment			[58] DeleteEventEnrollment-Request,
	alterEventEnrollment			[59] IMPLICIT AlterEventEnrollment-Request,
	reportEventEnrollmentStatus		[60] ReportEventEnrollmentStatus-Request,
	getEventEnrollmentAttributes	[61] IMPLICIT GetEventEnrollmentAttributes-Request,
	acknowledgeEventNotification	[62] IMPLICIT AcknowledgeEventNotification-Request,
	getAlarmSummary					[63] IMPLICIT GetAlarmSummary-Request,
	getAlarmEnrollmentSummary		[64] IMPLICIT GetAlarmEnrollmentSummary-Request,
	readJournal						[65] IMPLICIT ReadJournal-Request,
	writeJournal					[66] IMPLICIT WriteJournal-Request,
	initializeJournal				[67] IMPLICIT InitializeJournal-Request,
	reportJournalStatus				[68] IMPLICIT ReportJournalStatus-Request,
	createJournal					[69] IMPLICIT CreateJournal-Request,
	deleteJournal					[70] IMPLICIT DeleteJournal-Request,
	getCapabilityList				[71] IMPLICIT GetCapabilityList-Request,
	fileOpen						[72] IMPLICIT FileOpen-Request,
	fileRead						[73] IMPLICIT FileRead-Request,
	fileClose						[74] IMPLICIT FileClose-Request,
	fileRename						[75] IMPLICIT FileRename-Request,
	fileDelete						[76] IMPLICIT FileDelete-Request,
	fileDirectory					[77] IMPLICIT FileDirectory-Request
-- XXX this one is neither in this ASN nor in the IMPORTS
--	additionalService				[78] AdditionalService-Request
	}

CS-Request-Detail ::= CHOICE {
-- see ISO 9506-2
-- XXX can not handle empty choice
-- XXX fix me later
		foo INTEGER
	}
     */

public class ConfirmedRequest extends AbstractService {


    @Override
    public String choice(int tag) {
        switch (tag) {
            case 0: // StatusRequest
                return new StatusRequest().process(null); // here should be bool
            case 1:
                return new GetNameListRequest().process(getData());
            case 2: // IdentifyRequest
                return new IdentifyRequest().process(IDK.vmd.identify()); // here should be bool
            case 3:
                return new RenameRequest().process(getData());
            case 4:
                return new ReadRequest().process(getData());
            case 5:
                return new WriteRequest().process(getData());
//            case 71: // GetCapabilityList
//                return new ConfirmedResponse().build(getVmd().getCapabList());
            default:
                return null;
        }
    }

    @Override
    public String build(String data) {
        return null;
    }

//    @Override
//    public String build() {
//        return null;
//    }

    @Override
    public String process(String data) {

        String[] splitData;
            splitData = data.split(" ", 4);
            setId(splitData[0]);
            setLength(splitData[1]);
            setContent(splitData[2]);
            if (getContent() == 1){
                splitData = splitData[3].split(" ", 3);
                setId(splitData[0]);
                setLength(splitData[1]);
                setData(splitData[2]);
                return choice(getId().getTag());
            }
            return "Error";

    }
}

