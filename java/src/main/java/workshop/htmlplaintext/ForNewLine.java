package workshop.htmlplaintext;

public class ForNewLine implements PatternMatcherForHTML {
    @Override
    public boolean doesMatch(String param) {
        return (param.equals("\n"));
    }

    @Override
    public String patternReturner() {
        return "<br />";
    }
}
