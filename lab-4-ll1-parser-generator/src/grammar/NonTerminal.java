package grammar;

import java.util.*;
import java.util.stream.Collectors;

public class NonTerminal extends Node {
    public final List<Rule> rules;
    public final List<Attribute> attributes;
    public final Set<String> FIRST;
    public final Set<String> FOLLOW;
    private boolean hasEpsRule;

    public NonTerminal(String name, List<Attribute> attributes) {
        super(name);
        Objects.requireNonNull(attributes);
        rules = new ArrayList<>();
        this.attributes = attributes;
        FIRST = new HashSet<>();
        FOLLOW = new HashSet<>();
    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public boolean hasEpsRule() {
        return hasEpsRule;
    }

    public void enableEpsRule() {
        hasEpsRule = true;
    }

    @Override
    public String toString() {
        String attrs = attributes.isEmpty() ? "" : attributes.stream()
                .map(Attribute::toString)
                .collect(Collectors.joining(", ", "[", "]"));

        String rs = rules.stream()
                .map(Rule::toString)
                .collect(Collectors.joining(" | ", " -> ", ";"));

        String fst = FIRST.stream().collect(Collectors.joining(", ", "\nFIRST: ", ";"));
        String fl = FOLLOW.stream().collect(Collectors.joining(", ", "\nFOLLOW: ", ";"));

        return name + attrs + rs + fst + fl;
    }
}
