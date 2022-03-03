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
public class FizzBuzz {
    private ArrayList<PatternMatcherForFizzBuzz> patternMatchers;
    private PatternMatcherForFizzBuzz nullMatcher;
    public FizzBuzz(ArrayList<PatternMatcherForFizzBuzz> patternMatchers, PatternMatcherForFizzBuzz forNullObj ) {
        this.patternMatchers = patternMatchers;
        this.nullMatcher=forNullObj;
    }

    public String say(int number) {
        String strReturn = Integer.toString(number);

        for (PatternMatcherForFizzBuzz patternMatcher : patternMatchers) {
            if (patternMatcher.parityCheck(number)==true) {
                strReturn=patternMatcher.generatePattern();
            }
        }
        return strReturn;
    }
}
