package exercise;

import java.util.Map;

import static java.util.Collections.replaceAll;

// BEGIN
public class SingleTag extends Tag {

    public SingleTag (String nameTag, Map<String, String> attributes) {
        super(nameTag, attributes);
    }

    @Override
    public String toString() {
        String formatted = getFormattedAttributes();
        if (formatted.length() > 0) {
            return String.format("<%s %s>", getNameTag(), formatted);
        } else {
            return String.format("<%s>", getNameTag());
        }
    }
}
// END
