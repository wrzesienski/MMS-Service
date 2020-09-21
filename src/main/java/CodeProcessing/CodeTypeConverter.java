package CodeProcessing;

import IedStructure.RootClass;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * class for transforming code
 */
public class CodeTypeConverter {


    /**
     * метод разборки Id на составные части
     * @param in двоичный код Id
     * @return
     */
    public static int[] splitId(int in){
        String[] splitData = new String[3];
        int[] id = new int[3];
        int ik = 0;

        char[] data = dumbestMethod(in).toCharArray();
        String str ="";
        for (int i=0; i<data.length; i++){
            str+=data[i];
            if(isContaining(new int[]{1, 2}, i)){
            splitData[ik] = str;
            str = "";
            ik++;
            }
        }
        splitData[ik] = str;
        for (int i=0; i<splitData.length; i++){
            id[i] = Integer.parseInt(splitData[i], 2);
        }

        return id;
    }

    /**
     * метод добавления нулей до октета
     * @param bytee двоичный код
     * @return
     */
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

        hex = hex.replace(" ","");
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

    /**
     * метод позволяет получить длину данных, разделенных пробелом
     * @param data данные
     * @return длина 16 разрядная
     */
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
        return convertIntToHex(String.valueOf(Integer.parseInt(dumbestMethod(id, 2)+struct+dumbestMethod(choice, 5),2)));

    };

    public static String stickMessage(String content, String id){
        return id + " " + getLength(content) + " " + content;
    };

    public static String s_dataToHex(ArrayList<String> list){
        if(list==null){
            return "Error 1";
        }
        try {
            String ret = "";
            String choice = list.remove(list.size() - 1);
            if (list.isEmpty()) {
                ret += CodeTypeConverter.convertStringToHex("null") + " ";
                ret = CodeTypeConverter.convertIntToHex(Integer.toString(ret.split(" ").length))
                        + " " + ret;
                ret = CodeTypeConverter.stickId(0, 0, 0) + " " + ret;
            } else {
                for (String var : list) {
                    ret = CodeTypeConverter.convertStringToHex(var) + " " + ret;
                    ret = CodeTypeConverter.convertIntToHex(Integer.toString(ret.split(" ").length))
                            + " " + ret;
                    ret = CodeTypeConverter.stickId(0, 0, Integer.parseInt(Integer.toBinaryString(Integer.parseInt(choice)))) + " " + ret;
                }
            }
            return ret;
        } catch (NumberFormatException e){
            return "Error 2";
        }

    }

    public static String dataToHex(ArrayList<RootClass> lisr) {
        String ret = "";
        if (lisr.isEmpty()) {
            ret += CodeTypeConverter.convertStringToHex("null") + " ";
            ret = CodeTypeConverter.convertIntToHex(Integer.toString(ret.split(" ").length))
                    + " " + ret;
            ret = CodeTypeConverter.stickId(0, 0, 0) + " " + ret;
        } else {
            for (RootClass var : lisr) {
                ret = CodeTypeConverter.convertStringToHex(var.getRootName()) + " " + ret;
                ret = CodeTypeConverter.convertIntToHex(Integer.toString(ret.split(" ").length))
                        + " " + ret;
                ret = CodeTypeConverter.stickId(0, 0, Integer.parseInt(Integer.toBinaryString(var.getType().getCode()))) + " " + ret;

            }
        }
        return ret;
    }

}
