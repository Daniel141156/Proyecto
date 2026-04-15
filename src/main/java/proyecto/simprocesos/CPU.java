
package proyecto.simprocesos;

public class CPU {
    private int ciclos;
    public CPU(){}

    public CPU(int ciclos) {
        this.ciclos = ciclos;
    }
    public int getCiclos() {
        return ciclos;
    }

    public void setCiclos(int ciclos) {
        this.ciclos = ciclos;
    }
    public void avanzarCiclo(){
        ciclos++;
    }
    
}
