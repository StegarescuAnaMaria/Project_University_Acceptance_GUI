package pack;
import java.util.ArrayList;
import java.util.Scanner;
//import java.util.HashMap;

public class Facultate {
protected String nume;
private ArrayList <Specializare> specializari;
private int nr_specializari;

public Facultate(String nume) {
	super();
	this.nume = nume;
	this.nr_specializari=0;
	this.specializari=new ArrayList<Specializare>();
	
	//this.nr_locuri_nativi = nr_locuri_nativi;
	//this.nr_locuri_straini = nr_locuri_straini;
}

public String getNume() {
	return nume;
}

public int getNr_specializari() {
	return nr_specializari;
}

public void setNr_specializari(int nr_specializari) {
	this.nr_specializari = nr_specializari;
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

public void adaugare_specializare()
{
	Scanner scanner=new Scanner(System.in);
	System.out.println("Denumirea specializarii:");
	String spec=scanner.nextLine();
	System.out.println("Numarul de locuri (romani)");
	int nr=scanner.nextInt();
	System.out.println("Numarul de locuri (straini)");
	int nr2=scanner.nextInt();
	System.out.println("Introduceti numarul de examene necesare pentru admitere: \n");
	int nr3=scanner.nextInt();
	System.out.println("Introduceti numarul de examene BAC luate in considerare pentru admitere: \n");
	int nr4=scanner.nextInt();
	Specializare specializare=new Specializare(this.nume,  spec, nr, nr2, nr3, nr4);
	
	this.specializari.add(specializare);
	this.setNr_specializari(this.getNr_specializari());
	System.out.println("Specializare adaugata cu succes");
	 //if(scanner!=null)
	 //       scanner.close(); 
}

public void adaugare_specializari()
{
	Scanner scanner=new Scanner(System.in);
	System.out.println("Introduceti numarul de specializari: \n");
	int nr=scanner.nextInt();
	int i;
	for(i=0; i<nr; i++)
		adaugare_specializare();
	 //if(scanner!=null)
	  //      scanner.close(); 
}

}
