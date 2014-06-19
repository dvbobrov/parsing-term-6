package com.dbobrov.labs.recursive_parsing.visualization;

import com.dbobrov.labs.recursive_parsing.ParseException;
import com.dbobrov.labs.recursive_parsing.Parser;
import com.dbobrov.labs.recursive_parsing.logical_expression_nodes.Expression;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.TreeLayout;
import edu.uci.ics.jung.graph.DelegateTree;
import edu.uci.ics.jung.graph.Tree;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

public class Visualizer {
    public static Tree<Node, Integer> buildVisualizationTree(Expression expression) {
        DelegateTree<Node, Integer> g = new DelegateTree<>();
        int edgeNum = 0;
        int nodeNum = 0;
        Queue<Expression> qE = new ArrayDeque<>();
        Queue<Node> qN = new ArrayDeque<>();

        qE.add(expression);
        Node root = new Node(nodeNum++, expression.getLabel());
        qN.add(root);
        g.addVertex(root);


        while(!qE.isEmpty()) {
            Expression cur = qE.poll();
            Node curNode = qN.poll();
            for (Expression e : cur.getChildren()) {
                Node n = new Node(nodeNum++, e.getLabel());
                qE.add(e);
                qN.add(n);
//                g.addVertex(n);
                g.addChild(edgeNum++, curNode, n);
            }
        }
        return g;
    }


    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("usage: Visualizer expression");
            return;
        }
        String expr = args[0];
        Expression tree;
        try {
            tree = Parser.parse(expr);
        } catch (IOException e) {
            System.err.println(e.toString());
            return;
        } catch (ParseException e) {
            System.err.println("Parse exception: " + e);
            return;
        }

        Tree<Node, Integer> graph = buildVisualizationTree(tree);
        Layout<Node, Integer> layout = new TreeLayout<>(graph);
//        layout.setSize(new Dimension(1000, 700));
        BasicVisualizationServer<Node,Integer> vv =
                new BasicVisualizationServer<>(layout);
        vv.setPreferredSize(new Dimension(1000,700)); //Sets the viewing area size
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<>());
        vv.getRenderContext().setVertexDrawPaintTransformer(node -> {
            if (node.getId() == 0) return Color.GREEN;
            else return Color.BLACK;
        });

        JFrame frame = new JFrame("Tree visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv);
        frame.pack();
        frame.setVisible(true);
    }
}
