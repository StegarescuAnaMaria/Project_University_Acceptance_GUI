package pack;
import java.util.Comparator;

public class TheComparator implements Comparator<Candidat>{

	@Override
	public int compare(Candidat o1, Candidat o2) {
		//if (change1 < change2) return -1;
		if(o1.getMediaAdmitere()<o2.getMediaAdmitere())
			return 1;
		if(o1.getMediaAdmitere()==o2.getMediaAdmitere())
			return 0;
		return -1;
	}
}