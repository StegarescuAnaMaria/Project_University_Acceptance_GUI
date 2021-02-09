package pack;

import java.util.PriorityQueue;
import java.util.Comparator;

public class Specializare extends Facultate{
private String nume_spec;
private int nr_locuri_nativi;
private int nr_locuri_straini;
private PriorityQueue <Nativ> candidati_romani;
private PriorityQueue <Strain> candidati_straini;
private int nr_examene_adm;
private int nr_examene_BAC;


public Specializare(String nume, String nume_spec, int nr_locuri_nativi, int nr_locuri_straini, 
		int nr_examene_adm, int nr_examene_BAC) {
	super(nume);
	this.nume_spec = nume_spec;
	this.nr_locuri_nativi = nr_locuri_nativi;
	this.nr_locuri_straini = nr_locuri_straini;
	PriorityQueue<Nativ> queue = new PriorityQueue<Nativ>(new The_Comparator()); 
	this.candidati_romani=queue;
	PriorityQueue<Strain> queue2 = new PriorityQueue<Strain>(new The_Comparator()); 
	this.candidati_straini=queue2;
	this.nr_examene_adm=nr_examene_adm;   //nr examene de admitere
	this.nr_examene_BAC=nr_examene_BAC;
}

public int getNr_examene_adm() {
	return nr_examene_adm;
}

public void setNr_examene_adm(int nr_examene) {
	this.nr_examene_adm = nr_examene;
}

public int getNr_examene_BAC() {
	return nr_examene_BAC;
}

public void setNr_examene_BAC(int nr_examene_BAC) {
	this.nr_examene_BAC = nr_examene_BAC;
}

public String getNume_spec() {
	return nume_spec;
}

public void setNume_spec(String nume_spec) {
	this.nume_spec = nume_spec;
}

public int getNr_locuri_nativi() {
	return nr_locuri_nativi;
}

public void setNr_locuri_nativi(int nr_locuri_nativi) {
	this.nr_locuri_nativi = nr_locuri_nativi;
}

public int getNr_locuri_straini() {
	return nr_locuri_straini;
}

public void setNr_locuri_straini(int nr_locuri_straini) {
	this.nr_locuri_straini = nr_locuri_straini;
}

public PriorityQueue<Nativ> getCandidati_romani() {
	return candidati_romani;
}

public void setCandidati_romani(PriorityQueue<Nativ> candidati_romani) {
	this.candidati_romani = candidati_romani;
}

public PriorityQueue<Strain> getCandidati_straini() {
	return this.candidati_straini;
}

public void setCandidati_straini(PriorityQueue<Strain> candidati_straini) {
	this.candidati_straini = candidati_straini;
}

}
