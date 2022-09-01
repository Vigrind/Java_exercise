import java.util.Date;

public class ParkingLot {
	Cell carPark[][];
	int col;

	public ParkingLot(int m, int n) {
		carPark = new Cell[m][n];
		col = n;
	}

	Pair<Integer,Integer> carIn() {
		int i = 0;
		for (Cell[] cells : carPark) {
			for(int j = 0; j < col; j++){
				if(cells[j] == null) {
					cells[j] = new Cell();
					return new Pair<Integer,Integer>(i, j);
				
				}else if (cells[j].busy == false) {
					cells[j].busy = true;
					cells[j].d = new Date();
					return new Pair<Integer,Integer>(i, j);
				}
			}
			i++;
		}
		return null;
	}

	Integer carOut(Pair<Integer,Integer> p) {
		if(carPark[p.first][p.second] == null || carPark[p.first][p.second].busy == false)
			return null;
		
		carPark[p.first][p.second].busy = false;
		Date out = new Date();
		return ((int) (out.getTime() - carPark[p.first][p.second].d.getTime())) / 1000;
		
	}

	public boolean isFull() {
		/*
		 * isFull è particolare.
		 * se carIn mi restutuisce null, vuol dire che non ho inserito nulla perchè il parcheggio è pieno
		 * ma se carIn non mi restituisce null, devo eliminare l'auto che ho appena inserito.
		 * Questo perchè altrimenti ogni chiamata a isFull occuperebbe un posto
		 */
		Pair<Integer,Integer> p = this.carIn();
		if(p == null) 
			return true;
		else
			this.carOut(p);
		
		return false;
	}

	public boolean isEmpty() {
		/*
		 * Semplicemente scorro e controllo che non ci sia nessuna auto nel parcheggio
		 */
		for (Cell[] cells : carPark) {
			for(int j = 0; j < col; j++){
				if(cells[j] != null && cells[j].busy == true)
					return false;
			}
		}
		return true;
	}
}

class Cell {
	public boolean busy = true;
	public Date d = new Date();
}