package proyecto.simprocesos;

public class proceso {
  private int ID, prioridad, tejecucion, trestante;
  private String nom;
  public proceso(){}
  public proceso(int ID, int prioridad, int tejecucion, int trestante, String nom){
      this.prioridad=prioridad;
      this.tejecucion=tejecucion;
      this.trestante=trestante;
      this.nom=nom;
      this.ID=ID;
  }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
  
    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getTejecucion() {
        return tejecucion;
    }

    public void setTejecucion(int tejecucion) {
        this.tejecucion = tejecucion;
    }

    public int getTrestante() {
        return trestante;
    }

    public void setTrestante(int trestante) {
        this.trestante = trestante;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
  public void ejecutarCiclo(){
      trestante--;
  }
  public boolean terminado(){
          return trestante<=0; 
}
  
  public String toString(){
      return "Proceso: "+ nom + 
             "ID: "+ ID +
             "| Tiempo restante: " + trestante +
             "|Prioridad: "+ prioridad
              ;
  }
}
