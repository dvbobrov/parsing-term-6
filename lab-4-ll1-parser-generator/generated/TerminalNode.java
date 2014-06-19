public class TerminalNode extends Node {
    public TerminalNode(String text) {
        this.text = text;
        children = new Node[0];
    }
}
