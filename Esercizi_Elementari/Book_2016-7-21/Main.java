public class Main {
	public static void main(String[] args) {
		Book b = new Book();
		b.addChapter("Prefazione", "Sono_passati_pochi_anni...");
		b.addChapter("Introduzione", "Un_calcolatore_digitale...");
		b.addChapter("Sistemi_di_elaborazione", "Un_calcolatore...");

		Book bb = b.clone();
		System.out.println(bb.getChapterContent(1));
		System.out.println(bb.getChapterTitle(2));
	}
}
