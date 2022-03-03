package workshop;

import org.junit.Test;
import workshop.Trivia.*;
import workshop.forFizzbuzz.FizzBuzz;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class TriviaGameTest {
    QuestionType science1= new ScienceType();
    QuestionType rock1= new RockType();
    QuestionType sport1= new SportsType();
    QuestionType pop1= new PopType();
    LinkedList<Questions> popQuestions= new LinkedList<>();
    LinkedList<Questions> scienceQuestions= new LinkedList<>();
    LinkedList<Questions> sportsQuestions= new LinkedList<>();
    LinkedList<Questions> rockQuestions= new LinkedList<>();
    HashMap<QuestionType,LinkedList<Questions>> hMap= new HashMap<>();
    ArrayList<Player> playerList= new ArrayList<>();
    public void initiate(){
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast(new Questions("Pop Question " + i,pop1));
            scienceQuestions.addLast(new Questions("Science Question " + i , science1));
            sportsQuestions.addLast(new Questions("Sports Question " + i,sport1));
            rockQuestions.addLast(new Questions("Rock Question " + i,rock1));
        }
        hMap.put(pop1,popQuestions);
        hMap.put(science1,scienceQuestions);
        hMap.put(sport1,sportsQuestions);
        hMap.put(rock1,rockQuestions);
    }
    FakeTriviaGame game;

    @Test
    public void correctlyAnswered() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast(new Questions("Pop Question " + i,pop1));
            scienceQuestions.addLast(new Questions("Science Question " + i , science1));
            sportsQuestions.addLast(new Questions("Sports Question " + i,sport1));
            rockQuestions.addLast(new Questions("Rock Question " + i,rock1));
        }
        hMap.put(pop1,popQuestions);
        hMap.put(science1,scienceQuestions);
        hMap.put(sport1,sportsQuestions);
        hMap.put(rock1,rockQuestions);
        game = new FakeTriviaGame(playerList,hMap);
        game.add("Chet");
        game.add("Pat");
        game.roll(2);
        game.wasCorrectlyAnswered();

        assertEquals(Arrays.asList(
                "Chet was added",
                "They are player number 1",
                "Pat was added",
                "They are player number 2",
                "Chet is the current player",
                "They have rolled a 2",
                "Chet's new location is 2",
                "The category is Sports",
                "Sports Question 0",
                "Answer was correct!!!!",
                "Chet now has 1 Gold Coins."), game.getMessages());
    }

    @Test
    public void wronglyAnswered() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast(new Questions("Pop Question " + i,pop1));
            scienceQuestions.addLast(new Questions("Science Question " + i , science1));
            sportsQuestions.addLast(new Questions("Sports Question " + i,sport1));
            rockQuestions.addLast(new Questions("Rock Question " + i,rock1));
        }
        hMap.put(pop1,popQuestions);
        hMap.put(science1,scienceQuestions);
        hMap.put(sport1,sportsQuestions);
        hMap.put(rock1,rockQuestions);
        game = new FakeTriviaGame(playerList,hMap);
        game.add("Chet");
        game.add("Pat");
        game.roll(1);
        game.wrongAnswer();

        assertEquals(Arrays.asList(
                "Chet was added",
                "They are player number 1",
                "Pat was added",
                "They are player number 2",
                "Chet is the current player",
                "They have rolled a 1",
                "Chet's new location is 1",
                "The category is Science",
                "Science Question 0",
                "Question was incorrectly answered",
                "Chet was sent to the penalty box"), game.getMessages());
    }

    class FakeTriviaGame extends TriviaGame {
        List<String> messages = new ArrayList<>();

        public FakeTriviaGame(ArrayList<Player> playerList, HashMap<QuestionType, LinkedList<Questions>> questionList) {
            super(playerList, questionList);
        }


        @Override
        protected void announce(Object message) {
            messages.add(String.valueOf(message));
        }

        protected List<String> getMessages() {
            return messages;
        }
    }
}
