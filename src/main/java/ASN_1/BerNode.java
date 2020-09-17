package ASN_1;

import BerCoding.CodeConverter;

public class BerNode {

    private Identifier id;
    private int length;
    private int content;

    public BerNode(){
        id = new Identifier();
        length = 0;
        content = 0;
    }

    public Identifier getId() {
        return id;
    }

    public void setId(Identifier id) {
        this.id = id;
    }

    /**
     * method set pams of id
     * @param IdData stream of data
     * @return content data of BerNode
     */
    public void setId(String IdData){
        int nodeId = Integer.parseInt(Integer.toBinaryString(Integer.decode("0x" + IdData)));
        int[] iden = CodeConverter.getSplitId(nodeId);
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
