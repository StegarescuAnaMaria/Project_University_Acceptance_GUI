package pack;

public class Candidat {
	protected Facultate facultate;
	protected Specializare specializare;
	protected float media_admitere;
	protected String nume;
	protected String prenume;
	protected Examen_BAC [] examene_BAC;
	public Candidat(Facultate facultate, Specializare specializare, String nume, String prenume,
			Examen_BAC[] examene_BAC) {
		super();
		this.facultate = facultate;
		this.specializare = specializare;
		this.nume = nume;
		this.prenume = prenume;
		this.examene_BAC = examene_BAC;
	}
	
public Candidat()
{
	this.media_admitere = -1;
	this.nume = "";
	this.prenume = "";
}
	protected void calcul_medie_admitere()
	{
		
	}

	public Facultate getFacultate() {
		return facultate;
	}

	public void setFacultate(Facultate facultate) {
		this.facultate = facultate;
	}

	public Specializare getSpecializare() {
		return specializare;
	}

	public void setSpecializare(Specializare specializare) {
		this.specializare = specializare;
	}

	public float getMedia_admitere() {
		return media_admitere;
	}

	public void setMedia_admitere(float media_admitere) {
		this.media_admitere = media_admitere;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public Examen_BAC[] getExamene_BAC() {
		return examene_BAC;
	}

	public void setExamene_BAC(Examen_BAC[] examene_BAC) {
		this.examene_BAC = examene_BAC;
	}
	
}
