package com.dbobrov.labs.recursive_parsing.visualization;

public class Node {
    private final int id;
    private final String label;

    public Node(int id, String label) {
        this.id = id;
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (id != node.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + label.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return label;
    }

    public int getId() {
        return id;
    }
}
