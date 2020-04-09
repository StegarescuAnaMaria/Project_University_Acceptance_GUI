package pack;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Iterator;

public class Servicii {
static private ArrayList <Facultate> facultati=new ArrayList <Facultate>();



public static ArrayList<Facultate> getFacultati() {
	return facultati;
}

public static void setFacultati(ArrayList<Facultate> facultati) {
	Servicii.facultati = facultati;
}

public static void adaugare_candidat(String nume_facultate, String nume_specializare)
{
	int i;
	
	 int index=BinarySearch.binarySearch_facultate(facultati, 0, facultati.size(), nume_facultate);
	 if(index==-1)
	 {
		 System.out.println("Aceasta facultate nu a fost adaugata inca ");
		 return;
	 }
	 
	 int index2=BinarySearch.binarySearch_spec(facultati.get(index).getSpecializari(), 0, 
			 facultati.get(index).getSpecializari().size(), nume_specializare);
	 if(index2==-1)
	 {
		 System.out.println("Aceasta specializare nu a fost adaugata inca ");
		 return;
	 }
	 Scanner scanner=new Scanner(System.in);
	 Facultate facultate=facultati.get(index);
	 Specializare specializare=facultate.getSpecializari().get(index2);
	 System.out.println("Introduceti numele candidatului ");
	 String nume=scanner.next();
	 System.out.println("Introduceti prenumele candidatului ");
	 String prenume=scanner.next();
	 System.out.println("Este candidatul nativ sau strain? (nativ/strain) ");
	 String raspuns=scanner.next();
	 switch(raspuns)
	 {
	 case "nativ":
	 {
		int nr_examene=specializare.getNr_examene_adm();
		Examen_adm [] examene_admitere=new Examen_adm[nr_examene];
		System.out.println("Examene de admitere: ");
		float [] procentaj_adm=new float[nr_examene];
		for(i=0; i<nr_examene; i++)
		{
			System.out.println("Introduceti numele materiei: ");
			String nume_materie=scanner.nextLine();
			System.out.println("Introduceti nota: ");
			float nota=scanner.nextFloat();
			Examen_adm examen_adm=new Examen_adm(nume_materie, nota);
			examene_admitere[i]=examen_adm;
			System.out.println("Introduceti procentajul de contributie la media de admitere al acestui examen: \n");
			float proc=scanner.nextFloat();
			procentaj_adm[i]=proc;
		}
		int nr_exam_bac=specializare.getNr_examene_BAC();
		Examen_BAC [] examene_BAC=new Examen_BAC[nr_exam_bac];
		System.out.println("Examene de bacalaureat:");
		float [] procentaj_bac=new float[nr_exam_bac];
		for(i=0; i<nr_exam_bac; i++)
		{
			System.out.println("Introduceti numele materiei:");
			String nume_materie=scanner.nextLine();
			System.out.println("Introduceti nota: ");
			float nota=scanner.nextFloat();
			Examen_BAC examen_BAC=new Examen_BAC(nume_materie, nota);
			examene_BAC[i]=examen_BAC;
			System.out.println("Introduceti procentajul de contributie la media de admitere al acestui examen: \n");
			float proc=scanner.nextFloat();
			procentaj_bac[i]=proc;
		}
		Nativ nativ=new Nativ(facultate, specializare, nume, prenume, examene_BAC, examene_admitere, 
				procentaj_adm, procentaj_bac);
		nativ.calcul_medie_admitere();
		PriorityQueue<Nativ>candidati_romani=specializare.getCandidati_romani();
		candidati_romani.add(nativ);
		specializare.setCandidati_romani(candidati_romani);
		break;
	 }
	 case "strain":
	 {
		 int nr_exam_bac=specializare.getNr_examene_BAC();
			Examen_BAC [] examene_BAC=new Examen_BAC[nr_exam_bac];
			System.out.println("Examene de bacalaureat: \n");
			//float [] procentaj_bac=new float[nr_exam_bac];
			for(i=0; i<nr_exam_bac; i++)
			{
				System.out.println("Introduceti numele materiei: \n");
				String nume_materie=scanner.nextLine();
				System.out.println("Introduceti nota: \n");
				float nota=scanner.nextFloat();
				Examen_BAC examen_BAC=new Examen_BAC(nume_materie, nota);
				examene_BAC[i]=examen_BAC;
				//System.out.println("Introduceti procentajul de contributie la media de admitere al acestui examen: \n");
				//float proc=scanner.nextFloat();
				//procentaj_bac[i]=proc;
			}
			Strain strain=new Strain(facultate, specializare, nume, prenume, examene_BAC);
			strain.calcul_medie_admitere();
			PriorityQueue<Strain>candidati_straini=specializare.getCandidati_straini();
			candidati_straini.add(strain);
			specializare.setCandidati_straini(candidati_straini);

	 }
	 
	 }
	 
	 
	 //if(scanner!=null)
	  //      scanner.close(); 
}

static public void adaugare_facultate()
{
	System.out.println("Denumirea facultatii:");
	Scanner scanner=new Scanner(System.in);
	String den=scanner.nextLine();
	if(!facultati.isEmpty())
	{
	if(BinarySearch.binarySearch_facultate(facultati, 0, facultati.size(), den)==-1)
	{
		   Facultate facultate=new Facultate(den);
			
			System.out.println("Numarul de specializari:");
			int nr=scanner.nextInt();
			int i;
			for(i=0; i<nr; i++)
			{
				facultate.adaugare_specializare();
			}
			int index=BinarySearch.binarySearch2_facultate(facultati, den);
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
		int i;
		for(i=0; i<nr; i++)
		{
			facultate.adaugare_specializare();
		}
		int index=BinarySearch.binarySearch2_facultate(facultati, den);
		ArrayList <Facultate> facultati=getFacultati();
		facultati.add(index, facultate);
		setFacultati(facultati);
		System.out.println("Facultate adaugata cu succes");
	}
	//if(scanner!=null)
    //    scanner.close();
}

static public void afisare_facultati()
{
	int i, j;
	Scanner scanner=new Scanner(System.in);
	for(i=0; i<facultati.size(); i++)
	{
		System.out.println("Denumire facultate: \n");
		System.out.println(facultati.get(i).getNume());
		for(j=0; j<facultati.get(i).getSpecializari().size(); j++)
		{
			System.out.println("Denumire specializare: \n");
			System.out.println(facultati.get(i).getSpecializari().get(j).getNume_spec()+"\n");
			System.out.println("Nr locuri studenti romani: \n");
			System.out.println(facultati.get(i).getSpecializari().get(j).getNr_locuri_nativi()+"\n");
			System.out.println("Nr locuri studenti straini: \n");
			System.out.println(facultati.get(i).getSpecializari().get(j).getNr_locuri_straini()+"\n");
			
			System.out.println("Vreti sa afisati si datele despre candidatii pentru aceasta "
					+ "specialitate (da/nu)? \n");
			String raspuns=scanner.next();
			
			switch(raspuns)
			{
			case "da":
				afisare_toti_candidatii_specializare(facultati.get(i).getSpecializari().get(j));
				break;
			case "nu":
				continue;
			}
		}

	}
//	if(scanner!=null)
  //      scanner.close();
}

static public void afisare_toti_candidatii_specializare(Specializare specializare)
{
	PriorityQueue <Nativ> candidati_romani=specializare.getCandidati_romani();
	if(candidati_romani.isEmpty())
	{
		System.out.println("Inca nu a fost adaugat nici un candidat nativ \n");
	}
	else 
	{
		System.out.println("Candidati romani: \n");
		Iterator iterator=candidati_romani.iterator();
		while(iterator.hasNext())
				afisare_candidat_nativ((Nativ)iterator.next());
	}
	
	PriorityQueue <Strain> candidati_straini=specializare.getCandidati_straini();
	if(candidati_straini.isEmpty())
	{
		System.out.println("Inca nu a fost adaugat nici un candidat strain \n");
	}
	else 
	{
		System.out.println("Candidati straini: \n");
		Iterator iterator=candidati_straini.iterator();
		while(iterator.hasNext())
				afisare_candidat_strain((Strain)iterator.next());
	}
}

static public void afisare_candidati_admisi_specializare(Specializare specializare)
{
	int nr_locuri_romani=specializare.getNr_locuri_nativi();
	int nr_locuri_straini=specializare.getNr_locuri_straini();
	
	PriorityQueue <Nativ> candidati_romani=specializare.getCandidati_romani();
	Iterator <Nativ> iterator=candidati_romani.iterator();
	
	int i=0;
	if(!candidati_romani.isEmpty())
	while(i<nr_locuri_romani&&iterator.hasNext());
	{
		if(iterator.next().getMedia_admitere()>=5)
		afisare_candidat_nativ(iterator.next());
		i++;
	}
	PriorityQueue <Strain> candidati_straini=specializare.getCandidati_straini();
	i=0;
	Iterator <Strain> iterator2=candidati_straini.iterator();
	if(!candidati_straini.isEmpty())
	while(i<nr_locuri_straini&&iterator2.hasNext());
	{
		if(iterator2.next().getMedia_admitere()>=5)
		afisare_candidat_strain(iterator2.next());
		i++;
	}
}

static public void afisare_candidat_nume(Specializare specializare, String nume, String prenume)
{
	PriorityQueue<Nativ> queue=specializare.getCandidati_romani();
	PriorityQueue<Strain> queue2=specializare.getCandidati_straini();
			Iterator value = queue2.iterator(); 

		    Strain strain=new Strain();
		    while(value.hasNext())
		    {
		    strain=(Strain)value.next();
		    	if(strain.getNume()==nume&&strain.getPrenume()==prenume)
		    		break;
		    }
			if(strain.getNume()==nume&&strain.getPrenume()==prenume)
				afisare_candidat_strain((Strain)strain);
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
			afisare_candidat_strain((Strain)strain);
		else
			System.out.println("Nu a fost adaugat un astfel de student. \n");
	}
    
}

static public void afisare_candidat_index(Specializare specializare, int index, String tip)
{
	PriorityQueue<Nativ> queue=specializare.getCandidati_romani();

	Candidat[] arr = (Candidat[]) queue.toArray();
	
	if(tip=="nativ")
		afisare_candidat_nativ((Nativ) arr[index]);
	else if (tip=="strain")
		afisare_candidat_strain((Strain) arr[index]);
	
}

public static void afisare_candidat_nativ(Nativ nativ)
{
	int i;
	System.out.println("Nume si prenume: \n");
	System.out.println(nativ.getNume()+" "+nativ.getPrenume()+"\n");
	System.out.println("Media admitere: \n");
	System.out.println(nativ.getMedia_admitere());
	System.out.println("Examene: \n Examene BAC:");
	 Examen_adm[] examene_admitere=nativ.getExamene_admitere();
	 for(i=0; i<examene_admitere.length; i++)
	 {
		 System.out.println("Denumire examen: \n");
			System.out.println(examene_admitere[i].getDenumire());
			System.out.println("Nota: \n");
			System.out.println(examene_admitere[i].getNota());
	 }
	 
	 Examen_BAC[] examene_bac=nativ.getExamene_BAC();

		for(i=0; i<examene_bac.length; i++)
		{
			System.out.println("Denumire examen: \n");
			System.out.println(examene_bac[i].getDenumire());
			System.out.println("Nota: \n");
			System.out.println(examene_bac[i].getNota());
		}
}

public static void afisare_candidat_strain(Strain strain)
{
	int i;
	System.out.println("Nume si prenume: \n");
	System.out.println(strain.getNume()+" "+strain.getPrenume()+"\n");
	System.out.println("Media admitere: \n");
	System.out.println(strain.getMedia_admitere());
	System.out.println("Examene: \n Examene BAC:");
	Examen_BAC[] examene_bac=strain.getExamene_BAC();

	for(i=0; i<examene_bac.length; i++)
	{
		System.out.println("Denumire examen: \n");
		System.out.println(examene_bac[i].getDenumire());
		System.out.println("Nota: \n");
		System.out.println(examene_bac[i].getNota());
	}
}
}

