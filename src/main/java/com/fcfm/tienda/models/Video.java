package com.fcfm.tienda.models;

import java.util.Date;

/**
 * Created by jose.espinoza.lopez on 11/24/2015.
 */
public class Video {
    private String path;
    private Date vigencia;

    public Video(String path, Date vigencia) {
        this.path = path;
        this.vigencia = vigencia;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }
}
