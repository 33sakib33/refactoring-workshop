package workshop.forFizzbuzz;

public class ForThree implements PatternMatcherForFizzBuzz {
    public boolean parityCheck(int number){
        return (number%3==0);
    }
    public String generatePattern(){
        return "Fizz";
    }
}
