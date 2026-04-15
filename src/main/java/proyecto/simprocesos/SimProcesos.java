package proyecto.simprocesos;
import com.murcia.utils.*;
public class SimProcesos {
    private static ColaEnlazada<proceso> colaProcesos;
    private static ColaEnlazada<proceso> procesosTerminados;
    private static estadistica stats = new estadistica();
    private static CPU cpu = new CPU();
    private static int ID;
    public static void main(String[] args) {
        //opciones menu
        final char salir = '7';
        String[] opciones = {
            "1-Crear proceso.",
            "2-Ejecutar ciclos.",
            "3-Ver cola.",
            "4-Ver terminados.",
            "5-Ver estadísticas.",
            "6-Buscar proceso.",
            "7-Salir."
        };
        //creacion de objeto menu
        Menu menu = new Menu(opciones,'V' , "", "simulador CPU");
        char opcion;
        do{
            Consola.clrscr();
            Consola.gotoxy(0, 0);
            opcion = menu.select("Opcion[1-7]: ");
            Input.nextLine("");//opcion para reemplazar el scanner
            if (opcion == '1') crearProceso();
            if (opcion == '2') ejecutarCiclo();
            if (opcion == '3') mostrarCola();
            if (opcion == '4') mostrarTerminados();
            if (opcion == '5') mostrarEstadisticas();
            if (opcion == '6') buscarProceso();
         } while(opcion != salir);
        Consola.clrscr();
        Consola.gotoxy(0, 0);
        System.out.println("Fin de la simulacion");
        mostrarEstadisticas();
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
        stats.setCantProcesos(stats.getCantProcesos() + 1);
        p.setID(ID+1);
        }
    
    
    public static void ejecutarCiclo(){
        
        int n = Input.nextInt("Cuantos Ciclos ejecutar?:");
        for(int i=0;i<n;i++){
        if (colaProcesos == null|| colaProcesos.size()==0) {
            System.out.println("No hay procesos.");
            return;
        }
        cpu.avanzarCiclo();
        proceso actual = colaProcesos.desencolar();
        actual.ejecutarCiclo();
        System.out.println("Ejecutando: " + actual);
        if (!actual.terminado()) {
            //colaProcesos.encolar(actual);, se busca añadir la prioridad si es alta(1) o baja(2)
            if(actual.getPrioridad()==1){
                ColaEnlazada<proceso> aux = new ColaEnlazada();
                aux.add(actual);
                while(colaProcesos.size()>0){
                    aux.add(actual);
                }
                colaProcesos = aux;
            }else{
                colaProcesos.encolar(actual);
            }
        } else {
            if(procesosTerminados ==null){
                procesosTerminados = new ColaEnlazada<>();
        }
           procesosTerminados.encolar(actual);
            stats.agrPrFin();
            stats.settTotal(stats.gettTotal() + actual.getTejecucion());
            if(actual.terminado()==true){
                System.out.println("Proceso terminado: "+actual);
            }
        }
    }
        System.out.println("Se ejecutaron "+n+" ciclos.");
        System.out.println("Ciclos totales CPU: "+cpu.getCiclos());
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
    int enCola=0;
    if (colaProcesos != null) {
        enCola = colaProcesos.size();
    } 
        System.out.println("----------ESTADÍSTICAS----------");
        System.out.println("Procesos creados: " + stats.getCantProcesos());
        System.out.println("Procesos en cola: "+ enCola);
        System.out.println("Procesos terminados: " + stats.getPrFinalizados());
        System.out.println("Ciclos ejecutados: " + cpu.getCiclos());
        System.out.println("Tiempo promedio: " + stats.promedioT());
    }
    
    
    public static void buscarProceso(){
        if (colaProcesos==null||colaProcesos.size()==0){
            System.out.println("No hay procesos.");
            return;
        }
        String nombre = Input.nextLine("Nombre del proceso: ");
        ColaEnlazada<proceso> aux = new ColaEnlazada<>();
        boolean encontrado = false;
        while (colaProcesos.size() > 0) {
            proceso p = colaProcesos.desencolar();
            if (nombre.equals(p.getNom())) {//se comparan dos strings a.equals(b)
                System.out.println("Proceso encontrado: " + p);
                encontrado = true;
            }
            aux.encolar(p);
        }
        while (aux.size()>0) {
            colaProcesos.encolar(aux.desencolar());
        }
        if (!encontrado) {
            System.out.println("Proceso no encontrado.");
        }
    }
}
