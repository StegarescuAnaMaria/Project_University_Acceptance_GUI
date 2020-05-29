package pack;

import java.util.PriorityQueue;
import java.util.Comparator;

public class Specializare extends Facultate{
private String numeSpec;
private int nrLocuriNativi;
private int nrLocuriStraini;
private PriorityQueue <Nativ> candidatiRomani;
private PriorityQueue <Strain> candidatiStraini;
private int nrExameneAdm;
private int nrExameneBAC;


public Specializare(String nume, String numeSpec, int nrLocuriNativi, int nrLocuriStraini, 
		int nrExameneAdm, int nrExameneBAC) {
	super(nume);
	this.numeSpec = numeSpec;
	this.nrLocuriNativi = nrLocuriNativi;
	this.nrLocuriStraini = nrLocuriStraini;
	PriorityQueue<Nativ> queue = new PriorityQueue<Nativ>(new TheComparator()); 
	this.candidatiRomani=queue;
	PriorityQueue<Strain> queue2 = new PriorityQueue<Strain>(new TheComparator()); 
	this.candidatiStraini=queue2;
	this.nrExameneAdm=nrExameneAdm;   //nr examene de admitere
	this.nrExameneBAC=nrExameneBAC;
}

public int getNrExameneAdm() {
	return nrExameneAdm;
}

public void setNrExameneAdm(int nrExamene) {
	this.nrExameneAdm = nrExamene;
}

public int getNrExameneBAC() {
	return nrExameneBAC;
}

public void setNrExameneBAC(int nrExameneBAC) {
	this.nrExameneBAC = nrExameneBAC;
}

public String getNumeSpec() {
	return numeSpec;
}

public void setNumeSpec(String numeSpec) {
	this.numeSpec = numeSpec;
}

public int getNrLocuriNativi() {
	return nrLocuriNativi;
}

public void setNrLocuriNativi(int nrLocuriNativi) {
	this.nrLocuriNativi = nrLocuriNativi;
}

public int getNrLocuriStraini() {
	return nrLocuriStraini;
}

public void setNrLocuriStraini(int nrLocuriStraini) {
	this.nrLocuriStraini = nrLocuriStraini;
}

public PriorityQueue<Nativ> getCandidatiRomani() {
	return candidatiRomani;
}

public void setCandidatiRomani(PriorityQueue<Nativ> candidatiRomani) {
	this.candidatiRomani = candidatiRomani;
}

public PriorityQueue<Strain> getCandidatiStraini() {
	return this.candidatiStraini;
}

public void setCandidatiStraini(PriorityQueue<Strain> candidatiStraini) {
	this.candidatiStraini = candidatiStraini;
}
/*
@Override
public String toString()
{
	String answer="";
	answer+="Denumire specializare: "+numeSpec+"\n";
	System.out.println("Nr locuri studenti romani: ");
	System.out.println(facultati.get(i).getSpecializari().get(j).getNrLocuriNativi());
	System.out.println("Nr locuri studenti straini: ");
	System.out.println(facultati.get(i).getSpecializari().get(j).getNrLocuriStraini());
	
	System.out.println("Vreti sa afisati si datele despre candidatii pentru aceasta "
			+ "specializare (da/nu)? \n");
	String raspuns=scanner.next();
	scanner.nextLine();
}
*/
}
