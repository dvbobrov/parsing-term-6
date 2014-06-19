package grammar;

import java.util.*;
import java.util.stream.Collectors;

public class Rule implements Iterable<Node> {
    private List<Node> children;
    public final List<String> childrenNames;
    private String code;

    public Rule() {
        childrenNames = new ArrayList<>();
    }

    public void addChild(String name) {
        Objects.requireNonNull(name);
        childrenNames.add(name);
    }

    public void transformNamesToNodes(Map<String, Node> nodes) {
        children = childrenNames.stream().map(s -> getOrThrow(nodes, s)).collect(Collectors.toList());
    }

    public Node getChildAt(int idx) {
        return children.get(idx);
    }

    public int size() {
        return childrenNames.size();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        Objects.requireNonNull(code);
        this.code = code.substring(1, code.length() - 1);
    }

    private static<T, R> R getOrThrow(Map<T, R> map, T key) {
        R res = map.get(key);
        if (res == null) {
            throw new NoSuchElementException("Cannot find element " + key);
        }
        return res;
    }

    @Override
    public Iterator<Node> iterator() {
        if (children == null) {
            throw new IllegalStateException("Must call `transformChildrenToNodes` first");
        }
        return children.iterator();
    }

    @Override
    public String toString() {
        String text = childrenNames.stream()
                .collect(Collectors.joining(" "));

        return text + (code == null ? "" : code);
    }
}
