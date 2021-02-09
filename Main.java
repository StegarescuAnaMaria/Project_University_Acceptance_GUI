package pack;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	
public static void main(String[]args) {
	
	Examen matematica=new Examen("matematica", 9);
	System.out.println(matematica.nota);
	
	Servicii.setFacultati(new ArrayList<Facultate>());
	Servicii.adaugare_facultate();
	ArrayList<Facultate> facultati=Servicii.getFacultati();
	Servicii.adaugare_candidat(facultati.get(0).getNume(), facultati.get(0).getSpecializari().get(0).getNume_spec());
	Servicii.adaugare_candidat(facultati.get(0).getNume(), facultati.get(0).getSpecializari().get(0).getNume_spec());
	Servicii.adaugare_candidat(facultati.get(0).getNume(), facultati.get(0).getSpecializari().get(0).getNume_spec());
	Servicii.adaugare_candidat(facultati.get(0).getNume(), facultati.get(0).getSpecializari().get(0).getNume_spec());
	Servicii.afisare_candidati_admisi_specializare(facultati.get(0).getSpecializari().get(0));
	
	//Actiuni:
	//Adaugare facultate
	//Adaugare specializare pentru o facultate
	//Calcul medie admitere candidat
	//Adaugare candidat strain
	//Adaugare candidat nativ
	//Afisare candidat dupa nume
	//Afisare candidat dupa locul pe care il ocupa in lista (dupa index) (candidatii sunt sortati dupa medie)
	//Afisare candidati admisi
	//Afisarea tuturor candidatilor de pe lista a unei specializari
	//Afisarea informatiilor despre o facultate
	
	//Colectii: ArrayList. HashMap
}

}
