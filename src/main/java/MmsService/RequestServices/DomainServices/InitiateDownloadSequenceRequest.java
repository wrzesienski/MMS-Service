package MmsService.RequestServices.DomainServices;

import MmsService.ServiceInterface;

/*
InitiateDownloadSequence-Request ::= SEQUENCE
	{
	domainName		[0] IMPLICIT Identifier,
	listOfCapabilities	[1] IMPLICIT SEQUENCE OF VisibleString,
	sharable		[2] IMPLICIT BOOLEAN
	}
 */

public class InitiateDownloadSequenceRequest implements ServiceInterface {

    @Override
    public String choice(int tag) {
        return null;
    }

    @Override
    public String build(String data) {
        return null;
    }

    @Override
    public String process(String data) {
        return null;
    }
}
