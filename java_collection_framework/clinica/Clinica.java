import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Clinica{
	Map<Specialista,List<String>> prenotazioni = new HashMap<>();
	
	public void prenota(Specialista tipoSpecialista, String nomePaziente){
		if(prenotazioni.containsKey(tipoSpecialista)){
			for (Entry<Specialista,List<String>> elem : prenotazioni.entrySet()) {
				if(elem.getValue().contains(nomePaziente)) 
					break;
				else 
					elem.getValue().add(nomePaziente);
			}
		}else{
			List<String> clienti = new ArrayList<>();
			clienti.add(nomePaziente);
			prenotazioni.put(tipoSpecialista, clienti);
		}
	}

	public void cancellaPrenotazione(Specialista tipoSpecialista, String nomePaziente){
		if(prenotazioni.containsKey(tipoSpecialista))
			prenotazioni.get(tipoSpecialista).remove(nomePaziente);
	}

	public Collection<String> getPrenotati(Specialista tipoSpecialista){
		Collection<String> ret = prenotazioni.get(tipoSpecialista);
		return ret;
	}
}

enum Specialista{OCULISTA, PEDIATRA;}