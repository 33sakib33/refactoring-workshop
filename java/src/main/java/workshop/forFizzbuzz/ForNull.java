package workshop.forFizzbuzz;

public class ForNull implements PatternMatcherForFizzBuzz {
    @Override
    public boolean parityCheck(int number) {
        return false;
    }

    @Override
    public String generatePattern() {
        return null;
    }
}
