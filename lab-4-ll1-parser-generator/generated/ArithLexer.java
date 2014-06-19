import java.util.regex.*;
import grammar.*;
public class ArithLexer {
    private boolean skip;
    private String s;
    private int pos;
    private String cur;
    private String curType;
    public ArithLexer(String s) {
        this.s = s;
        this.pos = 0;
        goToNext();
    }
    public String nextToken() {
        String res = cur;
        if (curType.equals("EOF")) {
            res = "EOF";
        } else {
            goToNext();
        }
        return res;
    }
    public void goToNext() {
        if (pos == s.length()) {
            curType = "EOF";
            return;
        }
        boolean found = false;
        do {
            skip = false;
            for (int i = s.length(); i > pos; i--) {
                if (tryGetB(i)) {
                    found = true;
                    break;
                }
                if (tryGetPL(i)) {
                    found = true;
                    break;
                }
                if (tryGetPR(i)) {
                    found = true;
                    break;
                }
                if (tryGetPLUS(i)) {
                    found = true;
                    break;
                }
                if (tryGetSTAR(i)) {
                    found = true;
                    break;
                }
                if (tryGetNUM(i)) {
                    found = true;
                    break;
                }
            }
        } while(skip);
        if (!found) {
            throw new GrammarException("No terminal matches string " + s.substring(pos));
        }
    }
    private boolean tryGetB(int end) {
        String maybeNext = s.substring(pos, end);
        if (!Pattern.matches("[\\t\\n\\r ]", maybeNext)) {
            return false;
        }
        cur = maybeNext;
        pos = end;
        curType = "B";
        skip = true;
        return true;
    }
    private boolean tryGetPL(int end) {
        String maybeNext = s.substring(pos, end);
        if (!Pattern.matches("\\(", maybeNext)) {
            return false;
        }
        cur = maybeNext;
        pos = end;
        curType = "PL";
        return true;
    }
    private boolean tryGetPR(int end) {
        String maybeNext = s.substring(pos, end);
        if (!Pattern.matches("\\)", maybeNext)) {
            return false;
        }
        cur = maybeNext;
        pos = end;
        curType = "PR";
        return true;
    }
    private boolean tryGetPLUS(int end) {
        String maybeNext = s.substring(pos, end);
        if (!Pattern.matches("\\+", maybeNext)) {
            return false;
        }
        cur = maybeNext;
        pos = end;
        curType = "PLUS";
        return true;
    }
    private boolean tryGetSTAR(int end) {
        String maybeNext = s.substring(pos, end);
        if (!Pattern.matches("\\*", maybeNext)) {
            return false;
        }
        cur = maybeNext;
        pos = end;
        curType = "STAR";
        return true;
    }
    private boolean tryGetNUM(int end) {
        String maybeNext = s.substring(pos, end);
        if (!Pattern.matches("-?[0-9]+", maybeNext)) {
            return false;
        }
        cur = maybeNext;
        pos = end;
        curType = "NUM";
        return true;
    }
    public String getCurType() {
        return curType;
    }
}
