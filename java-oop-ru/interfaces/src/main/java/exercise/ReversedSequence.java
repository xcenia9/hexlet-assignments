package exercise;

import java.util.ArrayList;
import java.util.stream.Collectors;

// BEGIN
public class ReversedSequence implements CharSequence {
    private String str;

    public ReversedSequence(String str) {
        this.str = str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public int length() {
        return str.length();
    }

    @Override
    public char charAt(int i) {
        return str.charAt(length() - i - 1);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        String subStr = str.substring(start, end);
        return new ReversedSequence(subStr);
    }

    @Override
    public String toString() {
        StringBuilder reversed = new StringBuilder();
        for (int i = length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }
}
// END
