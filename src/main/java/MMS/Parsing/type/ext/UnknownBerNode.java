package MMS.Parsing.type.ext;

import MMS.Parsing.type.BerOctetString;
import sample.core.core.parse.Tag;

public class UnknownBerNode extends BerOctetString {

    public UnknownBerNode() {
        setId("unknown");
        setName("unknown");
    }

    public UnknownBerNode(int tag) {
        setId("unknown " + Tag.toString(tag));
        setName("unknown " + Tag.toString(tag));
    }

    public void setTag(int tag) {
        super.setTag(tag);
        setId("unknown " + Tag.toString(tag));
        setName("unknown " + Tag.toString(tag));
        setDisplayString(null);
    }

}
