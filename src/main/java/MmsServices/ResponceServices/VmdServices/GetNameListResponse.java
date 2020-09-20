package MmsServices.ResponceServices.VmdServices;

import MmsServices.ServiceConnector;
import MmsServices.ResponseService;


//GetNamedVariableListAttributes-Response ::= SEQUENCE
//        {
//        mmsDeletable		[0] IMPLICIT BOOLEAN,
//        AccessResultResponce		[1] IMPLICIT SEQUENCE OF SEQUENCE
//        {
//        [0] variableSpecification 		VariableSpecification,
//        alternateAccess			[5] IMPLICIT AlternateAccess OPTIONAL
//        }
//        }

public class GetNameListResponse extends ResponseService {
    public GetNameListResponse() {
        super(ServiceType.SEQUENCE);
    }

    @Override
    public String choice(int tag) {
        switch (tag){
            case 0:
                break;
            case 1:
                return new AccessResultResponce().process(getData(), getIed());
        }
        return null;
    }

    @Override
    public String build(String data) {
        return ServiceConnector.getParent(this, data);
    }

}
