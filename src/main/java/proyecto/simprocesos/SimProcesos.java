package proyecto.simprocesos;
import com.murcia.utils.*;
public class SimProcesos {
    private static ColaEnlazada<proceso> colaProcesos;
    private static ColaEnlazada<proceso> procesosTerminados;
    public static void main(String[] args) {
        //opciones menu
        final char salir = '6';
        String[] opciones = {
            "1-Crear proceso.",
            "2-Ejecutar ciclo.",
            "3-Ver cola.",
            "4-Ver terminados.",
            "5-Ver estadísticas.",
            "6-Salir."
        };
        //creacion de objeto menu
        Menu menu = new Menu(opciones,'V' , "", "simulador CPU");
        char opcion;
        do{
            Consola.clrscr();
            Consola.gotoxy(0, 0);
            opcion = menu.select("Opcion[1-6]: ");
            Input.nextLine("");//opcion para reemplazar el scanner
            if (opcion == '1') crearProceso();
            if (opcion == '2') ejecutarCiclo();
            if (opcion == '3') mostrarCola();
            if (opcion == '4') mostrarTerminados();
            if (opcion == '5') mostrarEstadisticas();
         } while(opcion != salir);
        //mostrarEstadisticas();<--pendiente 
    }
    public static void crearProceso(){
        if (colaProcesos == null) {
            colaProcesos = new ColaEnlazada<>();
        }
        
        String nombre = Input.nextLine("Nombre del proceso: ");
        int tiempo = Input.nextInt("Tiempo para completar la ejecución: ");

        proceso p = new proceso();//se crea el objeto para proceso
        p.setNom(nombre);
        p.setTejecucion(tiempo);
        p.setTrestante(tiempo);

        colaProcesos.encolar(p);

        System.out.println("Proceso agregado a la cola de procesos.");
    }
    public static void ejecutarCiclo(){
        //detecta si existe una cola
        if (colaProcesos == null) {
            System.out.println("No hay procesos.");
            return;
        }
        proceso actual = colaProcesos.desencolar();//toma un objeto existente en la cola y lo guarda en una variable que va a ser el proceso actual
        //detecta si no hay elementos en la cola, buscar elemento en la libreria
        if(actual==null){
            System.out.println("La cola esta vacía.");
            return;
        }
        actual.ejecutarCiclo();
        System.out.println("Ejecutando: " + actual);
        if (!actual.terminado()) {
            colaProcesos.encolar(actual);
        } else {
            if(procesosTerminados ==null){
                procesosTerminados = new ColaEnlazada<>();
        }
           procesosTerminados.encolar(actual);
            System.out.println("Proceso terminado: " + actual);
        }
    }
    public static void mostrarTerminados(){
        if (procesosTerminados == null) {
        System.out.println("No hay procesos terminados.");
        return;
    }else{
        System.out.println("Procesos terminados:");
        System.out.println(procesosTerminados); 
        }
    }
    public static void mostrarCola(){
        if(colaProcesos == null||colaProcesos.size()==0){
            System.out.println("Cola vacía.");
            return;
        }
            System.out.println(colaProcesos);
        }
    public static void mostrarEstadisticas(){
       int terminados = 0, enCola=0;
    if (procesosTerminados != null) {
        terminados = procesosTerminados.size();
    }
    if (colaProcesos != null) {
        enCola = colaProcesos.size();
    } 
        System.out.println("----------ESTADÍSTICAS----------");
        System.out.println("Procesos terminados: " + terminados);
        System.out.println("Procesos en cola: "+ enCola);
        int total = terminados + enCola;
        System.out.println("Total:" + total);
    }
    
}
