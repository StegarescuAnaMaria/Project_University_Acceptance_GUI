package pack;

public class Candidat {
	protected Facultate facultate;
	protected Specializare specializare;
	protected float mediaAdmitere;
	protected String nume;
	protected String prenume;
	protected ExamenBAC [] exameneBAC;
	public Candidat(Facultate facultate, Specializare specializare, String nume, String prenume,
			ExamenBAC[] exameneBAC) {
		super();
		this.facultate = facultate;
		this.specializare = specializare;
		this.nume = nume;
		this.prenume = prenume;
		this.exameneBAC = exameneBAC;
	}
	
public Candidat()
{
	this.mediaAdmitere = -1;
	this.nume = "";
	this.prenume = "";
}
	protected void calculeazaMedieAdmitere()
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

	public float getMediaAdmitere() {
		return mediaAdmitere;
	}

	public void setMedia_admitere(float mediaAdmitere) {
		this.mediaAdmitere = mediaAdmitere;
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

	public ExamenBAC[] getExameneBAC() {
		return exameneBAC;
	}

	public void setExameneBAC(ExamenBAC[] exameneBAC) {
		this.exameneBAC = exameneBAC;
	}
	
}
