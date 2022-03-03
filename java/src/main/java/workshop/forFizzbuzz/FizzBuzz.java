package workshop.forFizzbuzz;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Requirements:
 * For factor of three print Fizz instead of the number
 * For factor of five print Buzz instead of the number
 * For numbers which are factors of both three and five print FizzBuzz instead of the number
 */
// Removed conditionals by replacing it with polymorphism
public class FizzBuzz {
    private ArrayList<PatternMatcherForFizzBuzz> patternMatchers;
    public FizzBuzz(ArrayList<PatternMatcherForFizzBuzz> patternMatchers) {
        this.patternMatchers = patternMatchers;
    }

    public String say(int number) {
        String strReturn = Integer.toString(number);

        for (PatternMatcherForFizzBuzz patternMatcher : patternMatchers) {
            if (patternMatcher.parityCheck(number)) {
                strReturn=patternMatcher.generatePattern();
            }
        }
        return strReturn;
    }
}
