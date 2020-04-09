package pack;

public class Nativ extends Candidat {

	private Examen_adm [] examene_admitere;
	private float [] procentaj_adm;
    private float [] procentaj_BAC;
	@Override
	public void calcul_medie_admitere() {
		// TODO Auto-generated method stub
		int i;
		float nota=0;
		for(i=0; i<this.examene_admitere.length; i++)
		{
			nota+=this.examene_admitere[i].getNota()*this.procentaj_adm[i];
		}
		for(i=0; i<this.examene_BAC.length; i++)
		{
			nota+=this.examene_BAC[i].getNota()*this.procentaj_BAC[i];
		}
		this.media_admitere=nota;
		super.calcul_medie_admitere();
	}
public Nativ(Facultate facultate, Specializare specializare, String nume, String prenume,
Examen_BAC[] examene_BAC, Examen_adm[] examene_admitere, float[] procentaj_adm, float[] procentaj_BAC) {
		super(facultate, specializare, nume, prenume, examene_BAC);
		this.examene_admitere = examene_admitere;
		this.procentaj_adm = procentaj_adm;
		this.procentaj_BAC = procentaj_BAC;
	}
public Nativ()
{
	
}
	public Examen_adm[] getExamene_admitere() {
		return examene_admitere;
	}
	public void setExamene_admitere(Examen_adm[] examene_admitere) {
		this.examene_admitere = examene_admitere;
	}
	public float[] getProcentaj_adm() {
		return procentaj_adm;
	}
	public void setProcentaj_adm(float[] procentaj_adm) {
		this.procentaj_adm = procentaj_adm;
	}
	public float[] getProcentaj_BAC() {
		return procentaj_BAC;
	}
	public void setProcentaj_BAC(float[] procentaj_BAC) {
		this.procentaj_BAC = procentaj_BAC;
	}
	
}
