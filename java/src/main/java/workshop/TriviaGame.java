package workshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class TriviaGame {
    private ArrayList<Player> playerList;
    private HashMap<QuestionType,LinkedList<Questions>> questionList;
    Iterator<Player> it;
    private Player currentPlayer=null;

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
    public boolean addPlayer(String playerName) {
        Player newPlayer= new Player(playerName);
        playerList.add(newPlayer);
        announce(newPlayer.getName() + " was added");
        announce("They are player number " + playerList.size());
        return true;
    }

    public void roll(int roll) {
        it=it.hasNext()?it:playerList.iterator();
        currentPlayer=it.next();
        announce(currentPlayer.getName() + " is the current player");
        announce("They have rolled a " + roll);
        currentPlayer.move(roll);
        if(!currentPlayer.isPenaltyBox()) {
            QuestionType currQuesType=null;
            for(QuestionType quesTypeItr: questionList.keySet()){
                if(quesTypeItr.matchCategory(currentPlayer.getPlace())){
                    currQuesType=quesTypeItr;
                    announce("The category is " + currQuesType.retType());
                    askQuestion(currQuesType);
                    break;
                }
            }
        }
    }

    private void askQuestion(QuestionType curQuesType) {
        announce(questionList.get(curQuesType.retType()).removeFirst());
    }

    public boolean wasCorrectlyAnswered() {
        if(!getCurrentPlayer().isPenaltyBox()){
            announce("Answer was correct!!!!");
            currentPlayer.setPurse(currentPlayer.getPlace()+1);
            announce(currentPlayer.getName() + " now has " +currentPlayer.getPurse() + " Gold Coins.");
            boolean winner = didPlayerWin();
            return winner;
        }
    }
    public boolean wrongAnswer() {
        announce("Question was incorrectly answered");
        announce(currentPlayer.getName()+ " was sent to the penalty box");
        currentPlayer.setPenaltyBox(true);
        return true;
    }
    private boolean didPlayerWin() {
        return !(currentPlayer.getPurse()==6);
    }
    protected void announce(Object message) {
        System.out.println(message);
    }
}