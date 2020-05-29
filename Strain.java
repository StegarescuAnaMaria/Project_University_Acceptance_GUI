package pack;

public class Strain extends Candidat {

	@Override
	public void calculeazaMedieAdmitere() {
		// TODO Auto-generated method stub
		int i;
		float nota=0;
		for(i=0; i<this.exameneBAC.length; i++)
		{
			nota+=this.exameneBAC[i].getNota();
		}
		nota/=this.exameneBAC.length;
		this.mediaAdmitere=nota;
		super.calculeazaMedieAdmitere();
	}

	public Strain(Facultate facultate, Specializare specializare, String nume, 
			String prenume, ExamenBAC[] exameneBAC) {
		super(facultate, specializare, nume, prenume, exameneBAC);
		// TODO Auto-generated constructor stub
	}
	public Strain()
	{
		
	}

	

	
	
}
