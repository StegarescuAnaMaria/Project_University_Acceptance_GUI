package pack;
import java.util.ArrayList;
import java.util.Scanner;
//import java.util.HashMap;

public class Facultate {
protected String nume;
private ArrayList <Specializare> specializari;
private int nrSpecializari;

public Facultate(String nume) {
	super();
	this.nume = nume;
	this.nrSpecializari=0;
	this.specializari=new ArrayList<Specializare>();
	
	//this.nr_locuri_nativi = nr_locuri_nativi;
	//this.nr_locuri_straini = nr_locuri_straini;
}

public String getNume() {
	return nume;
}

public int getNrSpecializari() {
	return nrSpecializari;
}

public void setNrSpecializari(int nrSpecializari) {
	this.nrSpecializari = nrSpecializari;
}

public void setNume(String nume) {
	this.nume = nume;
}

public ArrayList<Specializare> getSpecializari() {
	return specializari;
}

public void setSpecializari(ArrayList<Specializare> specializari) {
	this.specializari = specializari;
}

public void adaugaSpecializare()
{
	Scanner scanner=new Scanner(System.in);
	System.out.println("Denumirea specializarii:");
	String spec=scanner.nextLine();
	System.out.println("Numarul de locuri (romani)");
	int nr=scanner.nextInt();
	scanner.nextLine();
	System.out.println("Numarul de locuri (straini)");
	int nr2=scanner.nextInt();
	scanner.nextLine();
	System.out.println("Introduceti numarul de examene necesare pentru admitere: ");
	int nr3=scanner.nextInt();
	scanner.nextLine();
	System.out.println("Introduceti numarul de examene BAC luate in considerare pentru admitere: ");
	int nr4=scanner.nextInt();
	scanner.nextLine();
	Specializare specializare=new Specializare(this.nume,  spec, nr, nr2, nr3, nr4);
	
	this.specializari.add(specializare);
	this.setNr_specializari(this.getNr_specializari());
	System.out.println("Specializare adaugata cu succes");
	 //if(scanner!=null)
	 //       scanner.close(); 
}

public void adaugaSpecializari()
{
	Scanner scanner=new Scanner(System.in);
	System.out.println("Introduceti numarul de specializari: ");
	int nr=scanner.nextInt();
	scanner.nextLine();
	int i;
	for(i=0; i<nr; i++)
		adaugaSpecializare();
	 //if(scanner!=null)
	  //      scanner.close(); 
}
/*
@Override
public String toString()
{
	int i, j;
	Scanner scanner=new Scanner(System.in);
	String answer="";
	answer+="Denumire facultate: "+nume+"\n ";
		
	
		for(j=0; j<specializari.size(); j++)
		{
		    specializari.get(i).toString();
			switch(raspuns)
			{
			case "da":
				afiseazaTotiCandidatiiSpecializare(facultati.get(i).getSpecializari().get(j));
				break;
			case "nu":
				continue;
			}
		}



}
*/
}