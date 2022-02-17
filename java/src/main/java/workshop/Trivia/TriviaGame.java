package workshop.Trivia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class TriviaGame {
    private ArrayList<Player> playerList;
    private HashMap<QuestionType,LinkedList<Questions>> questionList;
    Iterator<Player> it;
    private Player currentPlayer;

    public TriviaGame(ArrayList<Player> playerList, HashMap<QuestionType, LinkedList<Questions>> questionList){
        this.playerList = playerList;
        this.questionList = questionList;
        this.it=this.playerList.iterator();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public boolean isPlayable() {
        return (playerList.size() >= 2);
    }
    public boolean add(String playerName) {
        Player newPlayer= new Player(playerName);
        playerList.add(newPlayer);
        System.out.println(newPlayer.getName() + " was added");
        System.out.println("They are player number " + playerList.size());
        return true;
    }

    public void roll(int roll) {
        it=it.hasNext()?it:playerList.iterator();
        currentPlayer=it.next();
        System.out.println(currentPlayer.getName() + " is the current player");
        System.out.println("They have rolled a " + roll);
        currentPlayer.move(roll);
        if(!currentPlayer.isPenaltyBox()) {
            QuestionType currQuesType=null;
            for(QuestionType quesTypeItr: questionList.keySet()){
                if(quesTypeItr.matchCategory(currentPlayer.getPlace())){
                    currQuesType=quesTypeItr;
                    System.out.println("The category is " + currQuesType.retType());
                    askQuestion(currQuesType);
                    break;
                }
            }
        }
    }

    private void askQuestion(QuestionType curQuesType) {
        System.out.println(questionList.get(curQuesType.retType()).removeFirst());
    }

    public boolean wasCorrectlyAnswered() {
        if(!getCurrentPlayer().isPenaltyBox()){
            System.out.println("Answer was correct!!!!");
            currentPlayer.setPurse(currentPlayer.getPlace()+1);
            System.out.println(currentPlayer.getName() + " now has " +currentPlayer.getPurse() + " Gold Coins.");
            return didPlayerWin();
        }
        return false;
    }
    public boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(currentPlayer.getName()+ " was sent to the penalty box");
        currentPlayer.setPenaltyBox(true);
        return true;
    }
    private boolean didPlayerWin() {
        return !(currentPlayer.getPurse()==6);
    }
}