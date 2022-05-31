/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.Beans;

import ec.edu.ups.controlador.BodegaFacade;
import ec.edu.ups.modelo.Bodega;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edwin
 */
@Named
@SessionScoped
public class BodegaBeans implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private BodegaFacade bodegaFacade;
    private List<Bodega> listp = new ArrayList<>();
    private int id;
    private String nombre;
    private String ciudad;

    @PostConstruct
    public void init() {
        listp = bodegaFacade.findAll();
    }

    public BodegaFacade getBodegaFacade() {
        return bodegaFacade;
    }

    public void setBodegaFacade(BodegaFacade bodegaFacade) {
        this.bodegaFacade = bodegaFacade;
    }

    public List<Bodega> getListp() {
        return listp;
    }

    public void setListp(List<Bodega> listp) {
        this.listp = listp;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String add() {
        Bodega p = new Bodega(id, nombre, ciudad);
        bodegaFacade.create(p);
        listp = bodegaFacade.findAll();
        this.limpiar();
        return null;
    }

    public void limpiar() {

        this.nombre = "";
        this.ciudad = "";

    }

    public void edit(Bodega s) {

        bodegaFacade.edit(s);

        listp = bodegaFacade.findAll();
    }

    public String delete(Bodega s) {
        bodegaFacade.remove(s);
        listp = bodegaFacade.findAll();//llamo al findall para que se me actualice la lista
        return null;
    }
}
