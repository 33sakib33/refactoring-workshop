package workshop;

import org.junit.Test;
import workshop.forFizzbuzz.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class FizzBuzzTest {
    ArrayList<PatternMatcherForFizzBuzz> objList = new ArrayList<>();
    PatternMatcherForFizzBuzz obj1 = new ForNull();
    void initiate() {
        PatternMatcherForFizzBuzz obj2 = new ForThree();
        PatternMatcherForFizzBuzz obj3 = new ForFive();
        PatternMatcherForFizzBuzz obj4 = new ForThreeFive();
        objList.add(obj2);
        objList.add(obj3);
        objList.add(obj4);
    }


    FizzBuzz obj=new FizzBuzz(objList,obj1);
    @Test
    public void returnsANumber() {
        assertEquals("1", obj.say(1));
        assertEquals("4", obj.say(4));
        assertEquals("7", obj.say(7));
    }

    @Test
    public void factorOf3() {
        assertEquals("Fizz", obj.say(3));
        assertEquals("Fizz", obj.say(6));
        assertEquals("Fizz", obj.say(9));
    }

    @Test
    public void factorOf5() {
        assertEquals("Buzz", obj.say(5));
        assertEquals("Buzz", obj.say(10));
        assertEquals("Buzz", obj.say(20));
    }

    @Test
    public void factorOf3And5() {
        assertEquals("FizzBuzz", obj.say(15));
        assertEquals("FizzBuzz", obj.say(30));
        assertEquals("FizzBuzz", obj.say(60));
    }
}