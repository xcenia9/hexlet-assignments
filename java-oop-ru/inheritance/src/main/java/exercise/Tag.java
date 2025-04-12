package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public  class Tag {
    private String nameTag;
    private Map<String, String> attributes = new HashMap<>();

    public Tag(String nameTag, Map<String, String > attributes) {
        this.nameTag = nameTag;
        this.attributes = attributes;
    }

    public String getNameTag() {
        return nameTag;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public String getFormattedAttributes() {
        StringBuilder attributesBuilder = new StringBuilder();

        for (Map.Entry<String, String> entry : getAttributes().entrySet()) {
            if (attributesBuilder.length() > 0) {
                attributesBuilder.append(" ");
            }
            attributesBuilder.append(String.format("%s=\"%s\"", entry.getKey(), entry.getValue()));
        } return attributesBuilder.toString();
    }
}
// END
