package MMS.Parsing.type.ext;

import MMS.Parsing.type.BerInteger;

import java.util.HashMap;
import java.util.Map;

public abstract class BerIntegerEx extends BerInteger {
    private static final Map<String, String> _valueStrings = new HashMap<String, String>();

    public String getValueAsString() {
        String valueAsString = _valueStrings.get(getClass().getName() + "-" + getValue());
        if (valueAsString != null) {
            return valueAsString;
        } else {
            return super.getValueAsString();
        }
    }

    public static void addValueString(int value, String valueAsString, Class<?> clazz) {
        _valueStrings.put(clazz.getName() + "-" + value, valueAsString);
    }

}
