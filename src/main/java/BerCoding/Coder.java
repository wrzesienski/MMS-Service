package BerCoding;

import ASN_1.Identifier;
import ASN_1.MyBerNode;

import java.util.Arrays;

public class Coder {


    public static String encode(MyBerNode node){
        String str = "";
        str += "0" + node.getId().getType()+node.getId().getStruct()+node.getId().getTag();

        str = Integer.toHexString(Integer.parseInt(str));
        str +=" " + Integer.toHexString(0) + " ";
        if (node.getId().getStruct() == 1){
            str += encode((MyBerNode) node.getContent());
        }
        else str += Integer.toHexString(0);
        return str;
    }

    // data in octets
    public static MyBerNode decode(String data){
        MyBerNode myBerNode = new MyBerNode();
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
            myBerNode.setContent(Coder.decode(nData[2]));
        }
        else myBerNode.setContent(nData[2]);

        return myBerNode;
    }

    static int[] getSplitId(int in){
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

    static boolean isContaining(int[] arr, int obj){
        for(int obb: arr){
            if(obb == obj) return true;
        }
        return false;
    }
}
