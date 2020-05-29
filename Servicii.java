package pack;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Iterator;
import java.io.IOException;
import java.io.IOException;
public class Servicii {
static private ArrayList <Facultate> facultati;
static {
	facultati=new ArrayList <Facultate>();
}


public static ArrayList<Facultate> getFacultati() {
	return facultati;
}

public static void setFacultati(ArrayList<Facultate> facultati) {
	Servicii.facultati = facultati;
}

public static void adaugaCandidat(String numeFacultate, String numeSpecializare) throws IOException
{
	int i;
	
	 int index=BinarySearch.binarySearchFacultate(facultati, 0, facultati.size(), numeFacultate);
	 if(index==-1)
	 {
		 System.out.println("Aceasta facultate nu a fost adaugata inca ");
		 return;
	 }
	 
	 int index2=BinarySearch.binarySearchSpec(facultati.get(index).getSpecializari(), 0, 
			 facultati.get(index).getSpecializari().size(), numeSpecializare);
	 if(index2==-1)
	 {
		 System.out.println("Aceasta specializare nu a fost adaugata inca ");
		 return;
	 }
	 
	 Scanner scanner=new Scanner(System.in);
	 Facultate facultate=facultati.get(index);
	 Specializare specializare=facultate.getSpecializari().get(index2);
	 String nume, prenume, raspuns="";
	 
	 System.out.println("Introduceti numele candidatului ");
	 nume=scanner.next();
	 scanner.nextLine();
	 System.out.println("Introduceti prenumele candidatului ");
	 prenume=scanner.next();
	 scanner.nextLine();
	 System.out.println("Este candidatul nativ sau strain? (nativ/strain) ");
	
	 raspuns=scanner.next();
	 scanner.nextLine();
	 if(raspuns.compareTo("nativ")!=0 && raspuns.compareTo("strain")!=0) {
		 throw new IOException ("Tip nedefinit pentru candidat");
	 }
	 switch(raspuns)
	 {
	 case "nativ":
	 {
		int nrExamene=specializare.getNrExameneAdm();
		ExamenAdm [] exameneAdmitere=new ExamenAdm[nrExamene];
		
		System.out.println("Examene de admitere: ");
		float [] procentajAdm=new float[nrExamene];

		for(i=0; i<nrExamene; i++)
		{
			System.out.println("Introduceti numele materiei: ");
			String nume_materie=scanner.nextLine();
			System.out.println("Introduceti nota: ");
			float nota=scanner.nextFloat();
			scanner.nextLine();
			ExamenAdm examen_adm=new ExamenAdm(nume_materie, nota);
			exameneAdmitere[i]=examen_adm;
			System.out.println("Introduceti procentajul de contributie la media de admitere al acestui "
					+ "examen: ");
			float proc=scanner.nextFloat();
			scanner.nextLine();
			procentajAdm[i]=proc;
		}
		
		
		int nr_exam_bac=specializare.getNrExameneBAC();
		ExamenBAC [] examene_BAC=new ExamenBAC[nr_exam_bac];
		System.out.println("Examene de bacalaureat:");
		float [] procentaj_bac=new float[nr_exam_bac];

		for(i=0; i<nr_exam_bac; i++)
		{
			System.out.println("Introduceti numele materiei:");
			String nume_materie=scanner.nextLine();
			System.out.println("Introduceti nota: ");
			float nota=scanner.nextFloat();
			scanner.nextLine();
			ExamenBAC examen_BAC=new ExamenBAC(nume_materie, nota);
			examene_BAC[i]=examen_BAC;
			System.out.println("Introduceti procentajul de contributie la media de admitere al acestui "
					+ "examen: ");
			float proc=scanner.nextFloat();
			scanner.nextLine();
			procentaj_bac[i]=proc;
		}
		
		Nativ nativ=new Nativ(facultate, specializare, nume, prenume, examene_BAC, exameneAdmitere, 
				procentajAdm, procentaj_bac);
		nativ.calculeazaMedieAdmitere();
		PriorityQueue<Nativ>candidati_romani=specializare.getCandidatiRomani();
		candidati_romani.add(nativ);
		specializare.setCandidatiRomani(candidati_romani);
		break;
		}
	 case "strain":
	 {
		 int nr_exam_bac=specializare.getNrExameneBAC();
			ExamenBAC [] examene_BAC=new ExamenBAC[nr_exam_bac];
			System.out.println("Examene de bacalaureat: ");
			//float [] procentaj_bac=new float[nr_exam_bac];
			for(i=0; i<nr_exam_bac; i++)
			{
				System.out.println("Introduceti numele materiei: ");
				String nume_materie=scanner.nextLine();
				System.out.println("Introduceti nota: ");
				float nota=scanner.nextFloat();
				scanner.nextLine();
				ExamenBAC examen_BAC=new ExamenBAC(nume_materie, nota);
				examene_BAC[i]=examen_BAC;
				//System.out.println("Introduceti procentajul de contributie la media de admitere al acestui examen: \n");
				//float proc=scanner.nextFloat();
				//procentaj_bac[i]=proc;
			}
			Strain strain=new Strain(facultate, specializare, nume, prenume, examene_BAC);
			strain.calculeazaMedieAdmitere();
			PriorityQueue<Strain>candidati_straini=specializare.getCandidatiStraini();
			candidati_straini.add(strain);
			specializare.setCandidatiStraini(candidati_straini);
	 }
	 }
	 
	 //if(scanner!=null)
	  //      scanner.close(); 
}

static public void adaugaFacultate()
{
	System.out.println("Denumirea facultatii:");
	Scanner scanner=new Scanner(System.in);
	String den=scanner.nextLine();
	if(!facultati.isEmpty())
	{
	if(BinarySearch.binarySearchFacultate(facultati, 0, facultati.size(), den)==-1)
	{
		   Facultate facultate=new Facultate(den);
			
			System.out.println("Numarul de specializari:");
			int nr=scanner.nextInt();
			scanner.nextLine();
			int i;
			for(i=0; i<nr; i++)
			{
				facultate.adaugaSpecializare();
			}
			int index=BinarySearch.binarySearch2Facultate(facultati, den);
			ArrayList <Facultate> facultati=getFacultati();
			facultati.add(index, facultate);
			setFacultati(facultati);
			
			System.out.println("facultate adaugata cu succes");
	}
	else 
		System.out.println("Facultatea deja exista");
	}
	else
	{
		Facultate facultate=new Facultate(den);
		
		System.out.println("Numarul de specializari:");
		int nr=scanner.nextInt();
		scanner.nextLine();
		int i;
		for(i=0; i<nr; i++)
		{
			facultate.adaugaSpecializare();
		}
		int index=BinarySearch.binarySearch2Facultate(facultati, den);
		ArrayList <Facultate> facultati=getFacultati();
		facultati.add(index, facultate);
		setFacultati(facultati);
		System.out.println("Facultate adaugata cu succes");
	}
	//if(scanner!=null)
    //    scanner.close();
}

static public void afiseazaFacultati()
{
	int i, j;
	Scanner scanner=new Scanner(System.in);
	for(i=0; i<facultati.size(); i++)
	{
		System.out.println("Denumire facultate: ");
		System.out.println(facultati.get(i).getNume());
		for(j=0; j<facultati.get(i).getSpecializari().size(); j++)
		{
			System.out.println("Denumire specializare: ");
			System.out.println(facultati.get(i).getSpecializari().get(j).getNumeSpec());
			System.out.println("Nr locuri studenti romani: ");
			System.out.println(facultati.get(i).getSpecializari().get(j).getNrLocuriNativi());
			System.out.println("Nr locuri studenti straini: ");
			System.out.println(facultati.get(i).getSpecializari().get(j).getNrLocuriStraini());
			
			System.out.println("Vreti sa afisati si datele despre candidatii pentru aceasta "
					+ "specialitate (da/nu)? \n");
			String raspuns=scanner.next();
			scanner.nextLine();
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
//	if(scanner!=null)
  //      scanner.close();
}

static public void afiseazaTotiCandidatiiSpecializare(Specializare specializare)
{
	PriorityQueue <Nativ> candidati_romani=specializare.getCandidatiRomani();
	if(candidati_romani.isEmpty())
	{
		System.out.println("Inca nu a fost adaugat nici un candidat nativ ");
	}
	else 
	{
		System.out.println("Candidati romani: ");
		Iterator iterator=candidati_romani.iterator();
		while(iterator.hasNext())
				afiseazaCandidatNativ((Nativ)iterator.next());
	}
	
	PriorityQueue <Strain> candidati_straini=specializare.getCandidatiStraini();
	if(candidati_straini.isEmpty())
	{
		System.out.println("Inca nu a fost adaugat nici un candidat strain ");
	}
	else 
	{
		System.out.println("Candidati straini: ");
		Iterator iterator=candidati_straini.iterator();
		while(iterator.hasNext())
				afiseazaCandidatStrain((Strain)iterator.next());
	}
}

static public void afiseazaCandidatiAdmisiSpecializare(Specializare specializare)
{
	int nr_locuri_romani=specializare.getNrLocuriNativi();
	int nr_locuri_straini=specializare.getNrLocuriStraini();
	
	PriorityQueue <Nativ> candidati_romani=specializare.getCandidatiRomani();
	Iterator <Nativ> iterator=candidati_romani.iterator();
	
	int i=0;

	if(!candidati_romani.isEmpty())
	{
	while(i<nr_locuri_romani && iterator.hasNext())
	{
		Nativ nativ=iterator.next();
		if(nativ.getMediaAdmitere()>=5) {
		afiseazaCandidatNativ(nativ);
		}
		i++;
	}
	}

	PriorityQueue <Strain> candidati_straini=specializare.getCandidatiStraini();
	i=0;
	Iterator <Strain> iterator2=candidati_straini.iterator();
	if(!candidati_straini.isEmpty())
	{
	while(i<nr_locuri_straini && iterator2.hasNext())
	{
	
		Strain strain=iterator2.next();
		if(strain.getMediaAdmitere()>=5){
		afiseazaCandidatStrain(strain);
		}
		i++;
	}
	}
}

static public void afiseazaCandidatNume(Specializare specializare, String nume, String prenume)
{
	PriorityQueue<Nativ> queue=specializare.getCandidatiRomani();
	PriorityQueue<Strain> queue2=specializare.getCandidatiStraini();
			Iterator value = queue2.iterator(); 

		    Strain strain=new Strain();
		    while(value.hasNext())
		    {
		    strain=(Strain)value.next();
		    	if(strain.getNume()==nume&&strain.getPrenume()==prenume)
		    		break;
		    }
			if(strain.getNume()==nume&&strain.getPrenume()==prenume)
				afiseazaCandidatStrain((Strain)strain);
	else
	{
		Iterator value1 = queue.iterator(); 

	    Nativ nativ=new Nativ();
	    while(value.hasNext())
	    {
	    nativ=(Nativ)value1.next();
	    	if(nativ.getNume()==nume&&nativ.getPrenume()==prenume)
	    		break;
	    }
		if(nativ.getNume()==nume&&nativ.getPrenume()==prenume)
			afiseazaCandidatStrain((Strain)strain);
		else
			System.out.println("Nu a fost adaugat un astfel de student.");
	}
    
}

static public void afiseazaCandidatIndex(Specializare specializare, int index, String tip)
{
	PriorityQueue<Nativ> queue=specializare.getCandidatiRomani();

	Candidat[] arr = (Candidat[]) queue.toArray();
	
	if(tip=="nativ")
		afiseazaCandidatNativ((Nativ) arr[index]);
	else if (tip=="strain")
		afiseazaCandidatStrain((Strain) arr[index]);
	
}

public static void afiseazaCandidatNativ(Nativ nativ)
{
	int i;
	System.out.println("Nume si prenume: "+nativ.getNume()+" "+nativ.getPrenume());
	System.out.println("Media admitere: "+nativ.getMediaAdmitere());
	System.out.println("Examene: \n Examene BAC:");
	 ExamenAdm[] exameneAdmitere=nativ.getExameneAdmitere();
	 for(i=0; i<exameneAdmitere.length; i++)
	 {
		    System.out.println("Denumire examen: "+exameneAdmitere[i].getDenumire());
			System.out.println("Nota: "+exameneAdmitere[i].getNota());
	 }
	 
	 ExamenBAC[] examene_bac=nativ.getExameneBAC();

		for(i=0; i<examene_bac.length; i++)
		{
			System.out.println("Denumire examen: "+examene_bac[i].getDenumire());
			System.out.println("Nota: "+examene_bac[i].getNota());
		}
}

public static void afiseazaCandidatStrain(Strain strain)
{
	int i;
	System.out.println("Nume si prenume: "+strain.getNume()+" "+strain.getPrenume());
	System.out.println("Media admitere: "+strain.getMediaAdmitere());
	System.out.println("Examene: \n Examene BAC:");
	ExamenBAC[] examene_bac=strain.getExameneBAC();

	for(i=0; i<examene_bac.length; i++)
	{
		System.out.println("Denumire examen: "+examene_bac[i].getDenumire());
		System.out.println("Nota: "+examene_bac[i].getNota());
	}
}
}

