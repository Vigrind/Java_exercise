import java.util.SortedSet;
import java.util.TreeSet;

public class Question {
	private String domanda;
	private SortedSet<Answare> answerList;

    public Question(){}

    public Question(String domanda){
        this.domanda = domanda;
        answerList = new TreeSet<>();
    }

    public String getBestAnsware(){
       return answerList.last().answer;
    }

    public void addAnswer(Answare a){
        answerList.add(a);
    }

    public void remoevAnswer(Answare a){
        answerList.remove(a);
    }
}
