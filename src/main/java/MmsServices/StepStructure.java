package MmsServices;

import CodeProcessing.CodeTypeConverter;


/**
 * MMS на каждом этапе обработки состоит из 3х частей:
 * - id;
 * - актуальная длина данных;
 * - сами данные;
 * В классе описывается структура такой ступени обработки
 */
public abstract class StepStructure {

    private IdStruct id;
    private int length;
    private int content;

    public StepStructure(){
        id = new IdStruct();
        length = 0;
        content = 0;
    }

    public IdStruct getId() {
        return id;
    }

    public void setId(IdStruct id) {
        this.id = id;
    }

    /**
     * method set pams of id
     * @param IdData stream of data
     * @return content data of BerNode
     */
    public void setId(String IdData){
        int nodeId = Integer.parseInt(Integer.toBinaryString(Integer.decode("0x" + IdData)));
        int[] iden = CodeTypeConverter.splitId(nodeId);
        id.setType(iden[0]);
        id.setStruct(iden[1]);
        id.setTag(iden[2]);
    }

    public int getLength() {
        return length;
    }

    public void setLength(String lengthData) {
        this.length = Integer.parseInt(String.valueOf((Integer.decode("0x" + lengthData))));
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }

    public void setContent(String ConentData){
        this.content =Integer.parseInt(String.valueOf((Integer.decode("0x" + ConentData))));
    }
}
