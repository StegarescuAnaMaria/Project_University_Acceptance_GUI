package pack;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Collection;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.PriorityQueue;
import java.io.BufferedWriter;
import java.io.FileWriter; 

public class FisierSingleton {
private static FisierSingleton instance;

private FisierSingleton() {}
	
public static FisierSingleton getInstance()
{
	if(instance==null)
	{
		instance=new FisierSingleton();
	}
	return instance;
}
	

public ArrayList<Facultate> citesteFacultati(String path)
{    
	
 HashMap<String,Facultate>obiecte=new HashMap<String, Facultate>();  
 
 try {
 for (String line: Files.readAllLines(Paths.get(path))) {
	 String[] val=line.split(",");
	 
	 
	 Facultate obiect;
	 if(!obiecte.containsKey(val[0]))
	 {
	 obiect=new Facultate(val[0]);
	 obiect.setSpecializari(citesteSpecializari
			 ("D:/Users/ayami/OneDrive/Desktop/Java/Proiect/bin/facultati/"+val[0]+".csv", val[0]));
	 }
	 else {
	 obiect=obiecte.get(val[0]);
	 }
	 int i;

	
	 obiecte.put(val[0],obiect);
 }
 }catch(IOException e)
 {
	 System.out.println(e);
 }
        
        
Collection<Facultate> values = obiecte.values(); 
        
ArrayList<Facultate> facultati = new ArrayList<Facultate>(values);
 return facultati;
}

public ArrayList<Specializare> citesteSpecializari(String path, String facultate)
{
	ArrayList <Specializare> specializari=new ArrayList<Specializare>();
try {
	for (String line: Files.readAllLines(Paths.get(path))) {
		 String[] val=line.split(",");
		 Specializare spec=new Specializare(facultate, val[0], Integer.parseInt(val[1]), 
				 Integer.parseInt(val[2]), Integer.parseInt(val[3]), Integer.parseInt(val[4]));
 specializari.add(spec);
	}
}catch(IOException e)
{
	System.out.println(e);
}
	
	return specializari;
}

public void scrieCandidatiAdmisi(String path, Specializare specializare)
{
	FileWriter writer = new FileWriter(path, true);

	int nr_locuri_romani=specializare.getNrLocuriNativi();
	int nr_locuri_straini=specializare.getNrLocuriStraini();
	
	PriorityQueue <Nativ> candidati_romani=specializare.getCandidatiRomani();
	Iterator <Nativ> iterator=candidati_romani.iterator();
	writer.append("Candidatii admisi la specializarea");
	writer.append(","); writer.append(specializare.getNumeSpec());
	writer.append("\n");
	int i=0;
writer.append("Candidati nativi:");
writer.append("\n");
	if(!candidati_romani.isEmpty())
	{
	while(i<nr_locuri_romani && iterator.hasNext())
	{
		Nativ nativ=iterator.next();
		if(nativ.getMediaAdmitere()>=5) {
		//afiseazaCandidatNativ(nativ);
			int i;
			writer.append("Nume si prenume:"); writer.append(",");
			writer.append(nativ.getNume());
			writer.append(",");
			writer.append(nativ.getPrenume());
			writer.append("\n");
			writer.append("Media admitere:"); writer.append(",");
			writer.append(Float.toString(nativ.getMediaAdmitere()));
			writer.append("\n");
			writer.write("Examene:");
			writer.append("\n");
			writer.append("Examene BAC:");
			writer.append("\n");
			 ExamenAdm[] exameneAdmitere=nativ.getExameneAdmitere();
			 for(i=0; i<exameneAdmitere.length; i++)
			 {
				    writer.append("Denumire examen:");writer.append(",");
				    writer.append(exameneAdmitere[i].getDenumire());
				    writer.append("\n");
					writer.append("Nota:");writer.append(",");
					writer.append(exameneAdmitere[i].getNota());
					writer.append("\n");
			 }
			 
			 ExamenBAC[] examene_bac=nativ.getExameneBAC();

				for(i=0; i<examene_bac.length; i++)
				{
					writer.append("Denumire examen:");writer.append(",");
					writer.append(examene_bac[i].getDenumire());
					writer.append("\n");
					writer.append("Nota:");writer.append(",");
					writer.append(Float.toString(examene_bac[i].getNota()));
					writer.append("\n");
				}
		}
		i++;
	}
	}
writer.append("Candidati straini:");
writer.append("\n");
	PriorityQueue <Strain> candidati_straini=specializare.getCandidatiStraini();
	i=0;
	Iterator <Strain> iterator2=candidati_straini.iterator();
	if(!candidati_straini.isEmpty())
	{
	while(i<nr_locuri_straini && iterator2.hasNext())
	{
	
		Strain strain=iterator2.next();
		if(strain.getMediaAdmitere()>=5){
			
			writer.append("Nume si prenume:");
			writer.append(strain.getNume());writer.append(",");
			writer.append(strain.getPrenume());
			writer.append("\n");
			writer.append("Media admitere:");writer.append(",");
			writer.append(Float.toString(strain.getMediaAdmitere()));
			writer.append("\n");
			writer.append("Examene:");writer.append("\n");
			writer.append("Examene BAC:");writer.append("\n");
			ExamenBAC[] examene_bac=strain.getExameneBAC();

			for(i=0; i<examene_bac.length; i++)
			{
				writer.append("Denumire examen:");writer.append(",");
				writer.append(examene_bac[i].getDenumire());
				writer.append("\n");
				writer.append("Nota:");writer.append(",");
				writer.append(Float.toString(examene_bac[i].getNota()));
				writer.append("\n");
			}
		}
		i++;
	}
	}
	writer.close();
}

public AbstractMap.SimpleEntry<PriorityQueue<Nativ>,PriorityQueue<Strain>> 
citesteCandidati(String path, Facultate facultate, Specializare specializare)
{
	int nrExamAdm=0, nrExamBAC=0, counter=0, counter2=0;
	String prefix="D:/Users/ayami/OneDrive/Desktop/Java/Proiect/bin/";
	String f=facultate.getNume();
	try {
	for (String line0: Files.readAllLines(Paths.get(prefix+"facultati/"+f+".csv"))) {
		 String[] val0=line0.split(",");
if(val0[0].equals(specializare.getNumeSpec()))
{
	//System.out.println("aici");
	nrExamAdm=Integer.parseInt(val0[3]);
	nrExamBAC=Integer.parseInt(val0[4]);
}
	}
	}catch(IOException e)
	{
		System.out.println(e);
	}
PriorityQueue<Nativ> q1=specializare.getCandidatiRomani();
PriorityQueue<Strain> q2=specializare.getCandidatiStraini();
	try {
		for (String line: Files.readAllLines(Paths.get(path))) {
			 String[] val=line.split(",");
			 if(val[0].equals(facultate.getNume())&&val[1].equals(specializare.getNumeSpec()))
			 {
				if(val[4].equals("nativ"))
				{
					ExamenAdm[]	exameneAdmitere;
					ExamenBAC[] exameneBAC;
					float[]procentajAdm;
					float[]procentajBAC;
					exameneAdmitere=new ExamenAdm[nrExamAdm]; 
					exameneBAC=new ExamenBAC[nrExamBAC]; 
					procentajAdm=new float[nrExamAdm];
					procentajBAC=new float[nrExamBAC];
					for (String line1: Files.readAllLines(Paths.get(prefix+"/candidati/"
				+val[2]+" "+val[3]+".csv" ))) 
					{
						 String[] val2=line1.split(",");
				if(counter<nrExamAdm) 
				{
						exameneAdmitere[counter]=new ExamenAdm(val2[0], Integer.parseInt(val2[1]));
						procentajAdm[counter]=Float.parseFloat(val2[2]);
						counter++;
				}
				else
					{
						exameneBAC[counter2]=new ExamenBAC(val2[0], Integer.parseInt(val2[1]));
						procentajBAC[counter2]=Float.parseFloat(val2[2]);
						counter2++;
					}
					
					}	 
					Nativ nativ=new Nativ(facultate, specializare, val[2], val[3], exameneBAC, 
							exameneAdmitere, procentajAdm, procentajBAC);
					nativ.calculeazaMedieAdmitere();
					q1.add(nativ);
				
			 }
				else
				{
				int countter=0;
					ExamenBAC[] exameneBAC=new ExamenBAC[4];
					for (String line1: Files.readAllLines(Paths.get(prefix+"/candidati/"
							+val[2]+" "+val[3]+".csv" ))) {
						String[] val2=line1.split(",");
						exameneBAC[countter]=new ExamenBAC(val2[0], Integer.parseInt(val2[1]));
				}
				Strain strain=new Strain(facultate, specializare, val[2], val[3], exameneBAC);
				strain.calculeazaMedieAdmitere();
				q2.add(strain);
	             }
		
}

}
	}catch(IOException e)
	{
		System.out.println(e);
	}
	
	AbstractMap.SimpleEntry<PriorityQueue<Nativ>,PriorityQueue<Strain>> map=new 
			AbstractMap.SimpleEntry<PriorityQueue<Nativ>,PriorityQueue<Strain>>(q1,q2);
	System.out.println();
	return map;
}

}
