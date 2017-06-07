package com.serverless.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Arbetsplats {

    private String adress;
    private String postnr;
    private String postort;
    private VardeNamn land;
    private VardeNamn lan;
    private VardeNamn kommun;
    private String latitud;
    private String longitud;

}
