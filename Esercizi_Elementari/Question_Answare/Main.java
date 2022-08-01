public class Main {
	public static void main(String[] args){
        Question q = new Question("Dove␣si␣trova␣Albuquerque?");
        Answare a1 = new Answare(q, "Canada");
        Answare a2 = new Answare(q, "New␣Mexico");
        Answare a3 = new Answare(q, "Campania");
        a1.voteUp();
        System.out.println(q.getBestAnsware());
        a2.voteUp();
        a2.voteUp();
        System.out.println(q.getBestAnsware());

        a3.voteUp();
        a3.voteUp();
        a3.voteUp();
        a3.voteUp();
        a1.voteUp();
        System.out.println(q.getBestAnsware());
    }
}
