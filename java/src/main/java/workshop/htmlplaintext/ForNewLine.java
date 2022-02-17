package workshop.htmlplaintext;

public class ForNewLine implements Patternyzer2 {
    @Override
    public boolean doesMatch(String param) {
        return (param.equals("\n"));
    }

    @Override
    public String patternReturner() {
        String s = "<br>";
        return s;
    }
}
