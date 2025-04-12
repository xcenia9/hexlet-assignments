package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {

    private String bodyOfTheTag;
    private List<Tag> nameChildren;

    public PairedTag (String nameTag,
                      Map<String, String> attributes,
                      String bodyOfTheTag,
                      List<Tag> nameChildren
    ){
        super(nameTag, attributes);
        this.bodyOfTheTag = bodyOfTheTag;
        this.nameChildren = nameChildren;
    }

    public String getBodyOfTheTag() {
        return bodyOfTheTag;
    }

    public List<Tag> getNameChildren() {
        return nameChildren;
    }

    public String toString() {
        String formatted = getFormattedAttributes();
        String childrenString = getNameChildren().stream()
                .map(Tag::toString)
                .collect(Collectors.joining());
        if (bodyOfTheTag != null && !bodyOfTheTag.isEmpty()) {
            return String.format("<%s %s>%s</%s>", getNameTag(), formatted, getBodyOfTheTag(), getNameTag());
        } else if (!childrenString.isEmpty()) {
            return String.format("<%s %s>%s</%s>", getNameTag(), formatted, childrenString, getNameTag());
        } else {
            return String.format("<%s></%s>", getNameTag(), getNameTag());
        }
    }
}
// END
