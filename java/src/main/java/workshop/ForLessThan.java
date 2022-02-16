package workshop;

public class ForLessThan implements Patternyzer2{
    @Override
    public boolean doesMatch(String param) {
        return (param.equals("<"));
    }

    @Override
    public String patternReturner() {
        return "&lt;";
    }
}
