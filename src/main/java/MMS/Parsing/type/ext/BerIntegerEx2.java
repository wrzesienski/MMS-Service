package MMS.Parsing.type.ext;

import MMS.Parsing.type.BerInteger;
import sample.core.core.parse.Tag;

import java.util.HashMap;
import java.util.Map;

public class BerIntegerEx2 extends BerInteger {

    private static final Map<String, String> _valueStrings = new HashMap<String, String>();
    private static final Map<String, String> _displayStrings = new HashMap<String, String>();

    public String getValueAsString() {
        int tagNumber = getTag() & Tag.TAGNUMBER_MASK;
        String prefix = getClass().getName() + "-" + tagNumber;
        String valueAsString = _valueStrings.get(prefix + "-" + getValue());
        if (valueAsString != null) {
            return valueAsString;
        } else {
            valueAsString = _valueStrings.get(prefix + "-x");
            return valueAsString != null ? valueAsString : super.getValueAsString();
        }
    }

    public static void addValueString(int tagNumber, int value, String valueAsString, Class<?> clazz) {
        String prefix = clazz.getName() + "-" + tagNumber;
        _valueStrings.put(prefix + "-" + value, valueAsString);
    }

    public static void addValueString(int tagNumber, String valueAsString, Class<?> clazz) {
        String prefix = clazz.getName() + "-" + tagNumber;
        _valueStrings.put(prefix + "-x", valueAsString);
    }

    public static void addDisplayString(int tagNumber, String displayString, Class<?> clazz) {
        String prefix = clazz.getName() + "-" + tagNumber;
        _displayStrings.put(prefix, displayString);
    }

    public String getName() {
        int tagNumber = getTag() & Tag.TAGNUMBER_MASK;
        String prefix = getClass().getName() + "-" + tagNumber;
        return _displayStrings.get(prefix);
    }
}
