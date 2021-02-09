package pack;

public class Strain extends Candidat {

	@Override
	public void calcul_medie_admitere() {
		// TODO Auto-generated method stub
		int i;
		float nota=0;
		for(i=0; i<this.examene_BAC.length; i++)
		{
			nota+=this.examene_BAC[i].getNota();
		}
		nota/=this.examene_BAC.length;
		this.media_admitere=nota;
		super.calcul_medie_admitere();
	}

	public Strain(Facultate facultate, Specializare specializare, String nume, 
			String prenume, Examen_BAC[] examene_BAC) {
		super(facultate, specializare, nume, prenume, examene_BAC);
		// TODO Auto-generated constructor stub
	}
	public Strain()
	{
		
	}

	

	
	
}
