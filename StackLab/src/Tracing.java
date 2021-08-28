import java.util.Stack;

public class Tracing {
    private Stack s;

    public Tracing() {
        s = new Stack();
    }

    public void called(String name) {
        s.push(name);
    }

    public String returned() {
        String ret = "";
        if (!s.empty()) {
            ret = s.pop().toString();
        }
        return ret;
    }

    public String trace() {
        StringBuilder ret = new StringBuilder();

        if (!s.empty()) {
            ret.append(s.pop().toString());
        }

        while (!s.empty()) {
            ret.append(",").append(" ").append(s.pop().toString());
        }

        return ret.toString();
    }
}
