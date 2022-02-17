package workshop.htmlplaintext;

public class ForAmp implements PatternMatcherForHTML {
    @Override
    public boolean doesMatch(String param) {
        return (param.equals("&"));
    }

    @Override
    public String patternReturner() {
        return "&amp;";
    }
}