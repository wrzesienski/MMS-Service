package MmsServices.Error;

/*
Initiate-ErrorPDU ::= ServiceError
 */

public class AssociationError extends Error {

    @Override
    public String choice(int tag) {
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
