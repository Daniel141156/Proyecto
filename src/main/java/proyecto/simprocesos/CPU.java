
package proyecto.simprocesos;

public class CPU {
    private int prAct, ciclos;
    public CPU(){}

    public CPU(int prAct, int ciclos) {
        this.prAct = prAct;
        this.ciclos = ciclos;
    }

    public int getPrAct() {
        return prAct;
    }

    public void setPrAct(int prAct) {
        this.prAct = prAct;
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
