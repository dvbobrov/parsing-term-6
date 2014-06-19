package grammar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Grammar {
    public final List<Terminal> terminals = new ArrayList<>();
    public final List<NonTerminal> nonTerminals = new ArrayList<>();

    public void add(Terminal terminal) {
        terminals.add(terminal);
    }

    public void add(NonTerminal nonTerminal) {
        nonTerminals.add(nonTerminal);
    }

    @Override
    public String toString() {
        String terms = terminals.stream()
                .map(Terminal::toString)
                .collect(Collectors.joining("\n", "terminals:\n", "\n---------------\n"));
        String nonTerms = nonTerminals.stream()
                .map(NonTerminal::toString)
                .collect(Collectors.joining("\n", "non-terminals:\n", "\n--------------\n"));

        return terms + nonTerms;
    }

    public void finishConstruction() {
        Map<String, Node> allNodes = Stream.concat(terminals.stream(), nonTerminals.stream())
                .collect(Collectors.toMap(n -> n.name, n -> n));
        nonTerminals.forEach(nt -> nt.rules.forEach(r -> r.transformNamesToNodes(allNodes)));
        constructFirsts();
        constructFollows();
    }

    private void constructFirsts() {
        boolean setChanged;
        do {
            setChanged = false;
            for (NonTerminal nonTerminal : nonTerminals) {
                int curSize = nonTerminal.FIRST.size();
                for (Rule rule : nonTerminal.rules) {
                    for (Node node : rule) {
                        if (node instanceof Terminal) {
                            nonTerminal.FIRST.add(node.name);
                            break;
                        } else {
                            NonTerminal cur = ((NonTerminal) node);
                            nonTerminal.FIRST.addAll(cur.FIRST);
                            if (!cur.hasEpsRule()) {
                                break;
                            }
                        }
                    }
                }
                setChanged |= curSize != nonTerminal.FIRST.size();
            }
        } while(setChanged);
    }

    private void constructFollows() {
        boolean setChanged;
        do {
            setChanged = false;
            for (NonTerminal nonTerminal : nonTerminals) {
                for (Rule rule : nonTerminal.rules) {
                    if (rule.size() == 0) {
                        continue;
                    }
                    NonTerminal last = null;
                    {
                        Node lastNode = rule.getChildAt(rule.size() - 1);
                        if (lastNode instanceof NonTerminal) {
                            last = (NonTerminal) lastNode;
                        }
                    }
                    if (last != null) {
                        int curSize = last.FOLLOW.size();
                        last.FOLLOW.addAll(nonTerminal.FOLLOW);
                        setChanged |= last.FOLLOW.size() != curSize;
                    }

                    for (int i = rule.size() - 2; i >= 0; i--) {
                        Node curChild = rule.getChildAt(i);
                        if (curChild instanceof Terminal) {
                            continue;
                        }

                        NonTerminal cur = ((NonTerminal) curChild);
                        int curSize = cur.FOLLOW.size();
                        Node next = rule.getChildAt(i + 1);
                        if (next instanceof NonTerminal) {
                            NonTerminal nextNt = (NonTerminal) next;
                            cur.FOLLOW.addAll(nextNt.FIRST);
                            if (nextNt.hasEpsRule()) {
                                cur.FOLLOW.addAll(nextNt.FOLLOW);
                            }
                        } else {
                            cur.FOLLOW.add(next.name);
                        }
                        setChanged |= cur.FOLLOW.size() != curSize;
                    }
                }
            }
        } while(setChanged);
    }
}
