package com.serverless;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Arbetsplats {

    private String adress;
    private String postnr;
    private String postort;
    private VardeNamn land;
    private VardeNamn lan;
    private VardeNamn kommun;
    private String latitud;
    private String longitud;

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPostnr() {
        return postnr;
    }

    public void setPostnr(String postnr) {
        this.postnr = postnr;
    }

    public String getPostort() {
        return postort;
    }

    public void setPostort(String postort) {
        this.postort = postort;
    }

    public VardeNamn getLand() {
        return land;
    }

    public void setLand(VardeNamn land) {
        this.land = land;
    }

    public VardeNamn getLan() {
        return lan;
    }

    public void setLan(VardeNamn lan) {
        this.lan = lan;
    }

    public VardeNamn getKommun() {
        return kommun;
    }

    public void setKommun(VardeNamn kommun) {
        this.kommun = kommun;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    @Override
    public boolean equals(Object object) {
        return EqualsBuilder.reflectionEquals(this, object);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
