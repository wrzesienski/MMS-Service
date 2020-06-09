package MMS.Parsing.type.ext;

import MMS.Parsing.type.base.BerNode;

public interface IBerConstruct {
    public BerNode[] getChildren();

    public boolean remove(BerNode o);
}
