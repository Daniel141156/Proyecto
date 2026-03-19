package proyecto.simprocesos;
/**
 Esta clase va a tener los datos que se produzcan durante la ejecución
 */
public class estadistica {
    private int prFinalizados, ciclos, cantProcesos,tTotal;
public estadistica(){}
    public estadistica(int prFinalizados, int ciclos) {
        this.prFinalizados = prFinalizados;
        this.ciclos = ciclos;
    }

    public int getPrFinalizados() {
        return prFinalizados;
    }

    public void setPrFinalizados(int prFinalizados) {
        this.prFinalizados = prFinalizados;
    }

    public int getCiclos() {
        return ciclos;
    }

    public void setCiclos(int ciclos) {
        this.ciclos = ciclos;
    }
    public void agrPrFin(){
        prFinalizados++;
    }
     public double promedioT(){
    if(cantProcesos==0){
        return 0;
    }  
    return (tTotal/cantProcesos);
  }
}
