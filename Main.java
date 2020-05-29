package pack;
import java.util.Scanner;

import java.lang.reflect.Field;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public class Main {
	
public static void main(String[]args) {
	

	String prefix="D:/Users/ayami/OneDrive/Desktop/Java/Proiect/bin/";

	int i,j;
	try {
	FileWriter writer = new FileWriter(prefix+"audit.csv", true); 	
	
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
            LocalDateTime now;
	Scanner scanner=new Scanner(System.in);
	System.out.println("Alegeti: \n1 pentru a citi din fisier facultati si specializarile respective, plus"
			+ "afisarea informatiei despre acestea");
	System.out.println("2 pentru a citi candidatii din fisiere, respectiv datele despre examenele de "
			+ "admitere si BAC ale acestora, si afisarea lor (mai intai e necesar adaugarea unor facultati si specializari, "
			+ "fie din fisier, fie de la tastatura)");
	System.out.println("3 pentru a scrie intr-un fisier toti candidatii admisi (e necesar ca macar un "
			+ "candidat sa fie adaugat inainte, fie din fisier, fie de la tastatura)");
	System.out.println("4 pentru a adauga o facultate+specializarile ei de la tastatura");
	System.out.println("5 pentru a afisa informatii despre toate facultatile (e necesar ca facultatile "
			+ "sa fie adaugate mai intai");
	System.out.println("0 pentru iesire");
	
	label: while(true) {
	int nr=scanner.nextInt();
	
	switch(nr)
	{
	case 1:
		  now= LocalDateTime.now();  
		ArrayList<Facultate> facultati=FisierSingleton.getInstance().citesteFacultati
		(prefix+"facultati.csv");	
		Servicii.setFacultati(facultati);
		System.out.println(Servicii.getFacultati().size());
		Servicii.afiseazaFacultati();
		writer.append(dtf.format(now));
		writer.append(",");
		writer.append("1");
		writer.append("\n");
		break;

	case 2:
		 now = LocalDateTime.now();  
		ArrayList<Facultate> facultati2=Servicii.getFacultati();
		for(i=0;i<facultati2.size(); i++)
		{    ArrayList<Specializare> spec=facultati2.get(i).getSpecializari();
			for(j=0; j<facultati2.get(i).getNrSpecializari(); j++)
			{
				AbstractMap.SimpleEntry<PriorityQueue<Nativ>,PriorityQueue<Strain>> map=
	FisierSingleton.getInstance().citesteCandidati(prefix+"Candidati.csv", facultati2.get(i), 
									spec.get(j)	);
			spec.get(j).setCandidatiRomani(map.getKey());
			spec.get(j).setCandidatiStraini(map.getValue());
			}
		}
		for(i=0;i<facultati2.size(); i++)
		{    ArrayList<Specializare> spec=facultati2.get(i).getSpecializari();
			for(j=0; j<facultati2.get(i).getNrSpecializari(); j++)
			{
				Servicii.afiseazaTotiCandidatiiSpecializare(spec.get(j));
			}
		}
		writer.append(dtf.format(now));
		writer.append(",");
		writer.append("2");
		writer.append("\n");
		break;
	case 3:
		 now = LocalDateTime.now();  
		ArrayList<Facultate> facultati3=Servicii.getFacultati();
		for(i=0;i<facultati3.size(); i++)
		{    ArrayList<Specializare> spec=facultati3.get(i).getSpecializari();
			for(j=0; j<facultati3.get(i).getNrSpecializari(); j++)
			{
		FisierSingleton.getInstance().scrieCandidatiAdmisi(prefix+"admisi "+spec.get(j)+".csv", spec.get(j));
			}
		}
		writer.append(dtf.format(now));
		writer.append(",");
		writer.append("3");
		writer.append("\n");
		break;
	case 4:
		 now = LocalDateTime.now();  
		Servicii.adaugaFacultate();
		writer.append(dtf.format(now));
		writer.append(",");
		writer.append("4");
		writer.append("\n");
		break;
	case 5:
		 now = LocalDateTime.now();  
		Servicii.afiseazaFacultati();
		writer.append(dtf.format(now));
		writer.append(",");
		writer.append("5");
		writer.append("\n");
		break;
	case 0:
		break label; 
		
		
	}
	}
	writer.close();
	}catch(IOException e)
	{
		System.out.println(e);
	}
	//Am ales sa scriu in audit numarul actiunii, si nu actiunea in sine, 
	//fiindca actiunile reprezinta stringuri lungi si nu vor fi afisate bine pe coloane,
	//decat daca coloanele vor fi marite manual
	
	
	//Actiuni care nu sunt in audit (fiindca am nevoie de informatii aditionale, spre exemplu 
	//facultatea la care se face referire, numele unui candidat, locul pe care un candidat 
	//il ocupa in lista de  admisi etc):
	//Afisare candidat dupa nume(am nevoie de numele candidatului)
	//Afisare candidat dupa locul pe care il ocupa in lista (dupa index) 
	//Afisarea tuturor candidatilor de pe lista a unei specializari
	//Afisarea informatiilor despre o facultate(anume)
	//Adaugare specializare pentru o facultate(anume)
	
	


	
	
	//Colectii: ArrayList. HashMap
}

}
