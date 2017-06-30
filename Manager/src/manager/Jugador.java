/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import java.io.Serializable;

/**
 *
 * @author Alvaro
 */
public class Jugador implements Serializable {

    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private int annoNacimiento;
    private String posicion;
    private String telefono;
    private String email;
    private String equipoAnterior;
    private int numero;
    private int minJugados;
    private int amarillas;
    private int rojas;
    private int goles;
    private int asistencias;
    private String observaciones;

    public Jugador(String nombre, String primerApellido, String segundoApellido, int annoNacimiento, String posicion, String telefono, String email, String equipoAnterior) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.annoNacimiento = annoNacimiento;
        this.posicion = posicion;
        this.telefono = telefono;
        this.email = email;
        this.equipoAnterior = equipoAnterior;
        this.numero = 0;
        this.minJugados = 0;
        this.amarillas = 0;
        this.rojas = 0;
        this.goles = 0;
        this.asistencias = 0;
        this.observaciones = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public int getAnnoNacimiento() {
        return annoNacimiento;
    }

    public void setAnnoNacimiento(int annoNacimiento) {
        this.annoNacimiento = annoNacimiento;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEquipoAnterior() {
        return equipoAnterior;
    }

    public void setEquipoAnterior(String equipoAnterior) {
        this.equipoAnterior = equipoAnterior;
    }

    public int getNumero() {
        return numero;
    }

    public void sumaNumero(int numero) {
        this.numero += numero;
    }

    public int getMinJugados() {
        return minJugados;
    }

    public void sumaMinJugados(int minJugados) {
        this.minJugados += minJugados;
    }

    public int getAmarillas() {
        return amarillas;
    }

    public void sumaAmarillas(int amarillas) {
        this.amarillas += amarillas;
    }

    public int getRojas() {
        return rojas;
    }

    public void sumaRojas(int rojas) {
        this.rojas += rojas;
    }

    public int getGoles() {
        return goles;
    }

    public void sumaGoles(int goles) {
        this.goles += goles;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void sumaAsistencias(int asistencias) {
        this.asistencias += asistencias;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}
