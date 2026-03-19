package proyecto.simprocesos;

public class proceso {
  private int id, prioridad, tejecucion, trestante;
  private String nom;
  public proceso(){}
  public proceso(int id, int prioridad, int tejecucion, int trestante, String nom){
      this.id=id;
      this.prioridad=prioridad;
      this.tejecucion=tejecucion;
      this.trestante=trestante;
      this.nom=nom;
  }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
  
}
