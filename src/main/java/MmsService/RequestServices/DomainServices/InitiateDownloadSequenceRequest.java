package MmsService.RequestServices.DomainServices;

import ASN_1.MyBerNode;
import MmsService.MyInterface;

/*
InitiateDownloadSequence-Request ::= SEQUENCE
	{
	domainName		[0] IMPLICIT Identifier,
	listOfCapabilities	[1] IMPLICIT SEQUENCE OF VisibleString,
	sharable		[2] IMPLICIT BOOLEAN
	}
 */

public class InitiateDownloadSequenceRequest implements MyInterface {

    @Override
    public Object get(MyBerNode berNode) {
        return null;
    }

    @Override
    public MyBerNode convert() {
        return null;
    }
}
