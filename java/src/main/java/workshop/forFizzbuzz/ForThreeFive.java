package workshop.forFizzbuzz;

public class ForThreeFive implements PatternMatcherForFizzBuzz{
    @Override
    public boolean parityCheck(int number) {
        return (number%15==0);
    }

    @Override
    public String generatePattern() {
        return "FizzBuzz";
    }
}
