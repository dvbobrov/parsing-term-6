package grammar;

import java.util.Objects;

public abstract class Node {
    public final String name;

    public Node(String name) {
        Objects.requireNonNull(name);
        this.name = name;
    }
}
