package workshop.Trivia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class TriviaGame {
    private ArrayList<Player> playerList;
    private HashMap<QuestionType,LinkedList<Questions>> questionList;
    private int currentPlayer;

    public TriviaGame(ArrayList<Player> playerList, HashMap<QuestionType, LinkedList<Questions>> questionList){
        this.playerList = playerList;
        this.questionList = questionList;
        currentPlayer=0;
    }

    private Player getCurrentPlayer() {
        return playerList.get(currentPlayer);
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public boolean isPlayable() {
        return (playerList.size() >= 2);
    }
    public boolean add(String playerName) {
        Player newPlayer= new Player(playerName);
        playerList.add(newPlayer);
        announce(newPlayer.getName() + " was added");
        announce("They are player number " + playerList.size());
        return true;
    }

    public void roll(int roll) {

        announce(getCurrentPlayer().getName() + " is the current player");
        announce("They have rolled a " + roll);
        announce(getCurrentPlayer().move(roll));

        if(!getCurrentPlayer().isPenaltyBox()) {
            QuestionType currQuesType;
            for(QuestionType quesTypeItr: questionList.keySet()){
                if(quesTypeItr.matchCategory(getCurrentPlayer().getPlace())){
                    currQuesType=quesTypeItr;
                    announce("The category is " + currQuesType.retType());
                    askQuestion(currQuesType);
                    break;
                }
            }
        }
    }

    private void askQuestion(QuestionType curQuesType) {
        announce(questionList.get(curQuesType).getFirst().getQuestionString());
    }

    public boolean wasCorrectlyAnswered() {
        if(!getCurrentPlayer().isPenaltyBox()){
            announce("Answer was correct!!!!");
            getCurrentPlayer().setPurse(getCurrentPlayer().getPurse()+1);
            announce(getCurrentPlayer().getName() + " now has " +getCurrentPlayer().getPurse() + " Gold Coins.");
            return didPlayerWin();
        }
        setCurrentPlayer((currentPlayer+1)%playerList.size());
        return false;
    }
    public boolean wrongAnswer() {
        announce("Question was incorrectly answered");
        announce(getCurrentPlayer().getName()+ " was sent to the penalty box");
        getCurrentPlayer().setPenaltyBox(true);
        setCurrentPlayer((currentPlayer+1)%playerList.size());
        return true;
    }
    private boolean didPlayerWin() {
        return !(getCurrentPlayer().getPurse()==6);
    }
    protected void announce(Object message) {
        announce(message);
    }
}