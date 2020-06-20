package BerCoding;

import ASN_1.Identifier;
import ASN_1.BerNode;

import java.util.Arrays;

public class Coder {


    public static String encode(BerNode node){
        String str = "";
        str += "0" + node.getId().getType()+node.getId().getStruct()+node.getId().getTag();

        str = Integer.toHexString(Integer.parseInt(str));
        str +=" " + Integer.toHexString(0) + " ";
        if (node.getId().getStruct() == 1){
//            str += encode((BerNode) node.getContent());
        }
        else str += Integer.toHexString(0);
        return str;
    }

    // data in octets
    public static BerNode decode(String data){
        BerNode myBerNode = new BerNode();
        Identifier id = new Identifier();
        String[] nData = data.split(" ", 3);
        int nodeId = Integer.parseInt(Integer.toBinaryString(Integer.decode("0x" + nData[0])));
        int length = Integer.parseInt(String.valueOf((Integer.decode("0x" + nData[1]))));
        int[] iden = getSplitId(nodeId);
        id.setType(iden[0]);
        id.setStruct(iden[1]);
        id.setTag(iden[2]);

        myBerNode.setId(id);

        if (id.getStruct() == 1){
            System.out.println("puk");
//            myBerNode.setContent(Coder.decode(nData[2]));
        }
        else myBerNode.setContent(nData[2]);

        return myBerNode;
    }

    public static int[] getSplitId(int in){
        String[] ss = new String[3];
        int[] id = new int[3];
        int ik = 0;
        int[] limits = {1, 2};
        char[] data = dumbestMethod(in).toCharArray();
        System.out.println(data);
        String str ="";
        for (int i=0; i<data.length; i++){
            str+=data[i];
            if(isContaining(limits, i)){
            ss[ik] = str;
            str = "";
            ik++;
            }
        }
        ss[ik] = str;
        for (int i=0; i<ss.length; i++){
            id[i] = Integer.parseInt(ss[i]);
        }

        return id;
    }

    static String dumbestMethod(int bytee){
        char[] data = Integer.toString(bytee).toCharArray();
        char[] arr = new char[8 - data.length];
        Arrays.fill(arr, '0');
        return (new String(arr) + bytee);
    }

    static String dumbestMethod(int bytee, int a){
        char[] data = Integer.toString(bytee).toCharArray();
        char[] arr = new char[a - data.length];
        Arrays.fill(arr, '0');
        return (new String(arr) + bytee);
    }

    static boolean isContaining(int[] arr, int obj){
        for(int obb: arr){
            if(obb == obj) return true;
        }
        return false;
    }

    // Char -> Decimal -> Hex
    public static String convertStringToHex(String str) {

        StringBuffer hex = new StringBuffer();

        // loop chars one by one
        for (char temp : str.toCharArray()) {

            // convert char to int, for char `a` decimal 97
            int decimal = (int) temp;

            // convert int to hex, for decimal 97 hex 61
            hex.append(Integer.toHexString(decimal)).append(" ");
        }

        return hex.toString();

    }

    // Hex -> Decimal -> Char
    public static String convertHexToString(String hex) {

        StringBuilder result = new StringBuilder();

        // split into two chars per loop, hex, 0A, 0B, 0C...
        for (int i = 0; i < hex.length() - 1; i += 2) {

            String tempInHex = hex.substring(i, (i + 2));

            //convert hex to decimal
            int decimal = Integer.parseInt(tempInHex, 16);

            // convert the decimal to char
            result.append((char) decimal);

        }
        return result.toString();

    }

    public static String getLength(String data){
        String[] splitData = data.split(" ");
        return Integer.toHexString(splitData.length);
    }

    public static String convertIntToHex(String data){
        int ii = Integer.parseInt(data);
        String a = Integer.toHexString(ii);
        char[] aa = a.toCharArray();
        char[] arr = new char[2 - aa.length];
        Arrays.fill(arr, '0');
        return (new String(arr) + a);
    }

    public static String convertHexToInt(String data){
        return Integer.decode("0x" + data).toString();
    }

    public static String[] convertIntArrayToHexByProt(String data){
        return data.replaceAll("\\[|]", "").split(", ");
    }

    public static String stickId(int id, int struct, int choice){
        return convertIntToHex(dumbestMethod(id, 2)+struct+dumbestMethod(choice, 5));

    };

    public static String stickMessage(String content, String id){
        return id + " " + getLength(content) + " " + content;
    };
}
