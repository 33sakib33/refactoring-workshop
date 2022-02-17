package workshop.htmlplaintext;

public class ForGreaterThan implements PatternMatcherForHTML {
    @Override
    public boolean doesMatch(String param) {
        return (param.equals(">"));
    }

    @Override
    public String patternReturner() {
        return "&gt;";
    }
}
