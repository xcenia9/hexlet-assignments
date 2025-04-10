package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private String tag;
    private TagInterface inputTag;

    public LabelTag(String tag, TagInterface inputTag) {
        this.tag = tag;
        this.inputTag = inputTag;
    }
    public String getTag() {
        return tag;
    }

    public TagInterface getInputTag() {
        return inputTag;
    }
    @Override
    public String render() {
        return "<label>" + getTag() + getInputTag().render() + "</label>";
    }
}
// END
