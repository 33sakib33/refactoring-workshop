package workshop.forFizzbuzz;

public class ForFive implements PatternMatcherForFizzBuzz {
    public boolean parityCheck(int number){
        return (number%5==0);
    }
    public String generatePattern(){
        return "buzz";
    }
}
