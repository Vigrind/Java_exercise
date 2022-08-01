import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		Errore er = new Errore();

		try {
			er.secondoMetodo();
		} catch (IOException e) {
			e.printStackTrace();
		}

		er.terzoMetodo();
	}
}

class Errore {
	public void primoMetodo(Boolean val) throws IOException{
		if(val)
			return;
		else 
			throw new IOException();
	}

	public void secondoMetodo() throws IOException{
		primoMetodo(false);
	}

	public void terzoMetodo() {
		try {
			primoMetodo(true);
			secondoMetodo();
		} catch (Exception e) {
		}
	}
}