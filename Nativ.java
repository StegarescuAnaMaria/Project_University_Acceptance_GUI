package pack;

public class Nativ extends Candidat {

	private ExamenAdm [] exameneAdmitere;
	private float [] procentajAdm;
    private float [] procentajBAC;
	@Override
	public void calculeazaMedieAdmitere() {
		// TODO Auto-generated method stub
		int i;
		float nota=0;
		for(i=0; i<this.exameneAdmitere.length; i++)
		{
			nota+=this.exameneAdmitere[i].getNota()*this.procentajAdm[i];
		}
		for(i=0; i<this.exameneBAC.length; i++)
		{
			nota+=this.exameneBAC[i].getNota()*this.procentajBAC[i];
		}
		this.mediaAdmitere=nota;
		super.calculeazaMedieAdmitere();
	}
public Nativ(Facultate facultate, Specializare specializare, String nume, String prenume,
ExamenBAC[] examene_BAC, ExamenAdm[] exameneAdmitere, float[] procentajAdm, float[] procentajBAC) {
		super(facultate, specializare, nume, prenume, examene_BAC);
		this.exameneAdmitere = exameneAdmitere;
		this.procentajAdm = procentajAdm;
		this.procentajBAC = procentajBAC;
	}
public Nativ()
{
	
}
	public ExamenAdm[] getExameneAdmitere() {
		return exameneAdmitere;
	}
	public void setExameneAdmitere(ExamenAdm[] exameneAdmitere) {
		this.exameneAdmitere = exameneAdmitere;
	}
	public float[] getProcentajAdm() {
		return procentajAdm;
	}
	public void setProcentajAdm(float[] procentajAdm) {
		this.procentajAdm = procentajAdm;
	}
	public float[] getProcentajBAC() {
		return procentajBAC;
	}
	public void setProcentajBAC(float[] procentajBAC) {
		this.procentajBAC = procentajBAC;
	}
	
}
