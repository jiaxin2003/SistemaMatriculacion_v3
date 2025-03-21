package org.iesalandalus.programacion.matriculacion.modelo.negocio;

import java.util.ArrayList;

import org.iesalandalus.programacion.matriculacion.modelo.dominio.Alumno;

import javax.naming.OperationNotSupportedException;

public class Alumnos {
    private final ArrayList<Alumno> coleccionAlumnos;


    public Alumnos() {
        this.coleccionAlumnos = new ArrayList<>();
    }

    public ArrayList<Alumno> get() {
        return (copiaProfundaAlumnos());
    }

    private ArrayList<Alumno> copiaProfundaAlumnos() {
        ArrayList<Alumno> copia = new ArrayList<>(this.coleccionAlumnos.size());
        for (Alumno alumno : this.coleccionAlumnos) {
            copia.add(new Alumno(alumno));
        }
        return copia;
    }

    public int getTamano() {
        return this.coleccionAlumnos.size();
    }

    public void insertar(Alumno alumno) throws OperationNotSupportedException {
        if (alumno == null) {
            throw new NullPointerException("ERROR: No se puede insertar un alumno nulo.");
        }
        int indice = this.coleccionAlumnos.indexOf(alumno);
        if (indice != -1) {
            throw new OperationNotSupportedException("ERROR: Ya existe un alumno con ese dni.");
        } else {

            this.coleccionAlumnos.add(new Alumno(alumno));
        }
    }

    public Alumno buscar(Alumno alumno) {
        if (alumno == null) {
            throw new NullPointerException("ERROR: El alumno no puede ser nulo.");
        }
        int indice = this.coleccionAlumnos.indexOf(alumno);
        if (indice == -1) {
            return null;
        }
        return new Alumno(this.coleccionAlumnos.get(indice));
    }


    public void borrar(Alumno alumno) throws OperationNotSupportedException {
        if (alumno == null) {
            throw new NullPointerException("ERROR: No se puede borrar un alumno nulo.");
        }
        int indice = this.coleccionAlumnos.indexOf(alumno);
        if (indice == -1) {
            throw new OperationNotSupportedException("ERROR: No existe ningún alumno como el indicado.");
        }
        this.coleccionAlumnos.remove(indice);
    }


}
