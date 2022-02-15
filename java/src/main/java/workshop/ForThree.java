package workshop;

public class ForThree implements Patternyzer{
    public boolean parityCheck(int number){
        return (number%3==0);
    }
    public String generatePattern(){
        return "fizz";
    }
}
