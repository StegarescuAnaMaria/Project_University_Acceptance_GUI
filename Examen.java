package pack;

public class Examen {
protected String denumire;
protected float nota;
public Examen(String denumire, float nota) {
	super();
	this.denumire = denumire;
	this.nota = nota;
}
public String getDenumire() {
	return denumire;
}
public void setDenumire(String denumire) {
	this.denumire = denumire;
}
public float getNota() {
	return nota;
}
public void setNota(float nota) {
	this.nota = nota;
}

}
