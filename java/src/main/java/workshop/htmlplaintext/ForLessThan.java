package workshop.htmlplaintext;

public class ForLessThan implements PatternMatcherForHTML {
    @Override
    public boolean doesMatch(String param) {
        return (param.equals("<"));
    }

    @Override
    public String patternReturner() {
        return "&lt;";
    }
}
