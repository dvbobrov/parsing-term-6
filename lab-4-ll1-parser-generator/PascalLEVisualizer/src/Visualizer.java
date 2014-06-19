import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.TreeLayout;
import edu.uci.ics.jung.graph.DelegateTree;
import edu.uci.ics.jung.graph.DirectedOrderedSparseMultigraph;
import edu.uci.ics.jung.graph.Tree;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import grammar.GrammarException;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Visualizer {
    public static void main(String[] args) throws IOException {
        String line;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            line = reader.readLine();
        }

        PascalLELexer lexer = new PascalLELexer(line);
        PascalLEParser parser = new PascalLEParser(lexer);

        Node root = parser.orXor();
        if (!lexer.getCurType().equals("EOF")) {
            throw new GrammarException("EOF not reached");
        }
        Tree<Node, Integer> graph = buildVisualizationTree(root);
        Layout<Node, Integer> layout = new TreeLayout<>(graph);
        BasicVisualizationServer<Node,Integer> vv =
                new BasicVisualizationServer<>(layout);
        vv.setPreferredSize(new Dimension(1000,700)); //Sets the viewing area size
        vv.getRenderContext().setVertexLabelTransformer(node -> {
            if (node instanceof TerminalNode) {
                return node.text;
            }
            return node.getClass().getSimpleName();
        });
        vv.getRenderContext().setVertexDrawPaintTransformer(node -> {
            if (node == root) return Color.GREEN;
            if (node instanceof TerminalNode) {
                return Color.BLUE;
            }
            else return Color.BLACK;
        });

        JFrame frame = new JFrame("Tree visualizer");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv);
        frame.pack();
        frame.setVisible(true);
    }

    private static Tree<Node, Integer> buildVisualizationTree(Node root) {
        DirectedOrderedSparseMultigraph<Node, Integer> tree = new DirectedOrderedSparseMultigraph<>();

        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        tree.addVertex(root);

        int edge = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (Node c : cur.children) {
                q.add(c);
                tree.addVertex(c);
                tree.addEdge(edge++, cur, c);
            }
        }

        DelegateTree<Node, Integer> res = new DelegateTree<>(tree);
        res.addVertex(root);
        return res;
    }
}
