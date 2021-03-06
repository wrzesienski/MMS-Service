package MmsServices.Error;

/*
Cancel-ErrorPDU ::= SEQUENCE
	{
	originalInvokeID	[0] IMPLICIT Unsigned32,
	serviceError		[1] IMPLICIT ServiceError
	}
 */

public class CancelError extends Error {


    @Override
    public String choice(int tag) {

        System.out.println("Cancel-ErrorPDU ::= SEQUENCE\n" +
                "\t{\n" +
                "\toriginalInvokeID\t[0] IMPLICIT Unsigned32,\n" +
                "\tserviceError\t\t[1] IMPLICIT ServiceError\n" +
                "\t}");

        switch (tag){
            case 0:
                System.out.println("Причина 0");;
                return null;
            case 1:
                System.out.println("Причина 1");;

                return null;
            case 2:
                System.out.println("Причина 2");;

                return null;
            case 3:
                System.out.println("Причина 3");;

                return null;
            case 4:
                System.out.println("Причина 4");;

                return null;
        }
        System.out.println("Unknown ConfirmedError!");
        return null;
    }
}
