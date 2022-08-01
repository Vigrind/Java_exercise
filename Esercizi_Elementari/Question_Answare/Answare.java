public class Answare implements Comparable<Answare> {
	private Question question;
    String answer;
    private int count = 0;

    public Answare(Question q, String a){
        this.question = q;
        this.answer = a;
        q.addAnswer(this);
    }

    public void voteUp(){
        question.remoevAnswer(this);
        count++;
        question.addAnswer(this);
    }

    @Override
    public int compareTo(Answare arg0) {
        if( count < arg0.count ) 
            return -1;
        else if( count > arg0.count )
            return 1;
        else
            return 0;
    }
}