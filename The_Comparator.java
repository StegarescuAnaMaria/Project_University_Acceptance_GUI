package pack;
import java.util.Comparator;

public class The_Comparator implements Comparator<Candidat>{

	@Override
	public int compare(Candidat o1, Candidat o2) {
		//if (change1 < change2) return -1;
		if(o1.getMedia_admitere()<o2.getMedia_admitere())
			return 1;
		if(o1.getMedia_admitere()==o2.getMedia_admitere())
			return 0;
		return -1;
	}
	

}
