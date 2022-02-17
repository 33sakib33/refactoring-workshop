package workshop.forFizzbuzz;

import java.util.List;

/**
 * Requirements:
 * For factor of three print Fizz instead of the number
 * For factor of five print Buzz instead of the number
 * For numbers which are factors of both three and five print FizzBuzz instead of the number
 */
public class FizzBuzz {
    private List<PatternMatcherForFizzBuzz> patternMatchers;
    public FizzBuzz(List<PatternMatcherForFizzBuzz> patternMatchers) {
        super();
        this.patternMatchers = patternMatchers;
    }

    public String say(int number) {
        String strReturn = "";

        for (PatternMatcherForFizzBuzz patternMatcher : patternMatchers) {
            if (patternMatcher.parityCheck(number)) strReturn=strReturn.concat(patternMatcher.generatePattern());
        }
        strReturn=strReturn.isEmpty()?Integer.toString(number):strReturn;
        return strReturn;
    }
}
