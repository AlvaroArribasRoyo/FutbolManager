/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Alvaro
 */
public class Manager implements Serializable {

    private static ArrayList<Jugador> jugadores;
    private static ArrayList<Partido> partidos;
    //Almacenara el jugador actual del que necesitamos saber sus datos y estadisticas y cambiaran segun la busqueda.
    private Jugador jugadorBuscado;

    public Manager() {
        Manager.jugadores = new ArrayList<>();
        Manager.partidos = new ArrayList<>();
    }

    public void darAltaJugador(Jugador fichaje) {
        jugadores.add(fichaje);
        guardarDatosJugador();
    }

    public void darBajaJugador(Jugador descarte) {
        jugadores.remove(descarte);
    }

    public String mostrarPlantilla() {
        String informacion = "Nombre\t\t\t\tNumero\t\tPosicion\n";
        Jugador aux;
        for (int i = 0; i < jugadores.size(); i++) {
            //Guarda el jugador que utilizamos en cada iteracion para que sea mas corto el codigo
            aux = jugadores.get(i);
            //Rellenamos la informacion que vamos a devolver para poder mostrarla en el panel correspondiente
            informacion += aux.getPrimerApellido() + " " + aux.getSegundoApellido() + "," + aux.getNombre() + "\t\t\t" + aux.getNumero() + "\t\t" + aux.getPosicion() + "\n";
        }
        return informacion;
    }

    public String mostrarHemeroteca() {
        String informacion = "";
        Partido aux;
        for (int i = 0; i < partidos.size(); i++) {
            aux = partidos.get(i);
            informacion += aux.getEquipoLocal() + " " + aux.getGolesLocal() + "-" + aux.getGolesVisitante() + " " + aux.getEquipoVisitante() + "\t" + aux.getFecha() + "\t\tID: " + (i + 1) + "\n";
        }

        return informacion;
    }

    public boolean encontrarJugador(String apellido, int dorsal) {
        //Intentaremos encontrar el jugador que buscan para mostrar su informacion
        Jugador aux;
        for (int i = 0; i < jugadores.size(); i++) {
            //Guarda el jugador que utilizamos en cada iteracion para que sea mas corto el codigo
            aux = jugadores.get(i);
            if (aux.getPrimerApellido().equals(apellido) && aux.getNumero() == dorsal) {
                //Almacenamos el jugador del que mostraremos los datos 
                jugadorBuscado = aux;
                return true;
            }
        }
        return false;
    }

    public Jugador recuperarJugador() {
        //Intentaremos recuperar el jugador que buscaban para modificar sus atributos en caso de editar algo
        Jugador aux;
        Jugador buscado = null;
        for (int i = 0; i < jugadores.size(); i++) {
            //Guarda el jugador que utilizamos en cada iteracion para que sea mas corto el codigo
            aux = jugadores.get(i);
            if (aux.getPrimerApellido().equals(jugadorBuscado.getPrimerApellido()) && aux.getNombre().equals(jugadorBuscado.getNombre()) && aux.getNumero() == jugadorBuscado.getNumero()) {
                //Almacenamos el jugador del que mostraremos los datos 
                buscado = aux;
            }

        }
        return buscado;
    }

    public void altaPartido(Partido partido) {
        partidos.add(partido);
    }

    public void guardarDatosPartido() {
        try {
            //Creamos el stream en el que vamos a escribir bits
            FileOutputStream streamSalida = new FileOutputStream("registroPartidos.dat");
            //Creamos el objeto donde vamos a escribir aquello que queremos guardar
            ObjectOutputStream objetoSalida = new ObjectOutputStream(streamSalida);
            //Escribimos en nuestro objeto aquello que le pasamos por parametro
            objetoSalida.writeObject(partidos);//Guardamos el jugador que hayamos modificado
            //Cerramos el stream de salida  
            streamSalida.close();
        } catch (Exception e) {
            System.out.println("Error al serializar, los datos no fueron guardados.");
        }

    }

    public void guardarDatosJugador() {
        try {
            //Creamos el stream en el que vamos a escribir bits
            FileOutputStream streamSalida = new FileOutputStream("plantilla.dat");
            //Creamos el objeto donde vamos a escribir aquello que queremos guardar
            ObjectOutputStream objetoSalida = new ObjectOutputStream(streamSalida);
            //Escribimos en nuestro objeto aquello que le pasamos por parametro
            objetoSalida.writeObject(jugadores);//Guardamos el jugador que hayamos modificado
            //Cerramos el stream de salida  
            streamSalida.close();
        } catch (Exception e) {
            System.out.println("Error al serializar, los datos no fueron guardados.");
        }

    }

    public void recuperarDatos() {
        try {
            //Creamos el stream de entrada para leer datos
            FileInputStream streamEntradaJugador = new FileInputStream("plantilla.dat");
            //Creamos el objeto que nos permite leer el fichero
            ObjectInputStream objetoEntradaJugador = new ObjectInputStream(streamEntradaJugador);
            try {
                //Recuperamos la lista con la plantilla
                while (true) {
                    //Añadimos a nuestra plantilla todos los objetos jugador que habiamos guardado
                    jugadores = (ArrayList) objetoEntradaJugador.readObject();
                }
            } catch (EOFException e) {
                System.out.println("Datos de la plantilla recuperados");
            }
            streamEntradaJugador.close();

            //Creamos el stream de entrada para leer datos
            FileInputStream streamEntradaPartido = new FileInputStream("registroPartidos.dat");
            //Creamos el objeto que nos permite leer el fichero
            ObjectInputStream objetoEntradaPartido = new ObjectInputStream(streamEntradaPartido);
            try {
                //Recuperamos la lista con los jugadores
                while (true) {
                    //Añadimos a nuestra plantilla todos los objetos jugador que habiamos guardado
                    partidos = (ArrayList) objetoEntradaPartido.readObject();

                }
            } catch (EOFException e) {
                System.out.println("Datos de los partidos recuperados");
            }
            streamEntradaPartido.close();
        } catch (Exception e) {
            System.out.println("Error al acceder a los datos, no se pudieron cargar correctamente.");
        }

    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        Manager.jugadores = jugadores;
    }

    public Jugador getJugadorBuscado() {
        return jugadorBuscado;
    }

    public void incrementarMinutos(int minutos, Jugador jugador) {
        jugador.sumaMinJugados(minutos);
    }

    public void incrementarAmarillas(Jugador jugador) {
        jugador.sumaAmarillas(1);
    }

    public void incrementarRojas(Jugador jugador) {
        jugador.sumaRojas(1);
    }

    public void incrementarGoles(Jugador jugador) {
        jugador.sumaGoles(1);
    }

    public void incrementarAsistencias(Jugador jugador) {
        jugador.sumaAsistencias(1);
    }

    public void incrementarNumero(Jugador jugador) {
        jugador.sumaNumero(1);
    }

    public void decrementarMinutos(Jugador jugador) {
        jugador.sumaMinJugados(-1);
    }

    public void decrementarAmarillas(Jugador jugador) {
        jugador.sumaAmarillas(-1);
    }

    public void decrementarRojas(Jugador jugador) {
        jugador.sumaRojas(-1);
    }

    public void decrementarGoles(Jugador jugador) {
        jugador.sumaGoles(-1);
    }

    public void decrementarAsistencias(Jugador jugador) {
        jugador.sumaAsistencias(-1);
    }

    public void decrementarNumero(Jugador jugador) {
        jugador.sumaNumero(-1);
    }

}
