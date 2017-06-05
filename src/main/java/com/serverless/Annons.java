package com.serverless;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Annons {

    private String id;
    private Arbetsplats arbetsplats;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Arbetsplats getArbetsplats() {
        return arbetsplats;
    }

    public void setArbetsplats(Arbetsplats arbetsplats) {
        this.arbetsplats = arbetsplats;
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
