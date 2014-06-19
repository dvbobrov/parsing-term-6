package grammar;

import java.util.Objects;

public class Terminal extends Node {
    public final String regex;
    public final boolean isSkippable;

    public Terminal(String name, String regex, boolean isSkippable) {
        super(name);
        Objects.requireNonNull(regex);
        this.regex = regex.substring(1, regex.length() - 1);
        this.isSkippable = isSkippable;
    }

    @Override
    public String toString() {
        return name + " -> REGEX(" + regex + ")";
    }
}
