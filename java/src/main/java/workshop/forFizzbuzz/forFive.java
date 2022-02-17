package workshop.forFizzbuzz;

public class forFive implements Patternyzer {
    public boolean parityCheck(int number){
        return (number%5==0);
    }
    public String generatePattern(){
        return "buzz";
    }
}
