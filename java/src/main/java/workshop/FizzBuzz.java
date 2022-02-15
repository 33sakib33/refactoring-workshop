package workshop;

import java.util.List;

/**
 * Requirements:
 * For factor of three print Fizz instead of the number
 * For factor of five print Buzz instead of the number
 * For numbers which are factors of both three and five print FizzBuzz instead of the number
 */
public class FizzBuzz {
    private List<Patternyzer> patternMatchers;
    public FizzBuzz(List<Patternyzer> patternMatchers) {
        super();
        this.patternMatchers = patternMatchers;
    }

    public String say(int number) {
        String strReturn = "";

        for (Patternyzer patternMatcher : patternMatchers) {
            if (patternMatcher.parityCheck(number)) strReturn=strReturn.concat(patternMatcher.generatePattern());
        }

        return strReturn;
    }
}
