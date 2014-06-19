package grammar;

public class Attribute {
    public final String type;
    public final String name;

    public Attribute(String type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public String toString() {
        return type + " " + name;
    }
}
