package com.serverless;

import com.serverless.model.Annons;
import com.serverless.model.Arbetsplats;
import com.serverless.model.VardeNamn;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnnonsTest {

    @Test
    public void createAnnonsTest() {
        String id = "007";
        String kommun = "Stockholm";
        String lan = "Stockholm";
        String land = "Sverige";
        String adress = "Norra Stationsgatan 61";
        String latitude = "59.347517";
        String longitude = "18.039236";
        String postnr = "113 43";
        String postort = "STOCKHOLM";

        Arbetsplats arbetsplats = Arbetsplats.builder()
                .adress(adress)
                .kommun(new VardeNamn(kommun, "kommun"))
                .lan(new VardeNamn(lan, "län"))
                .land(new VardeNamn(land, "land"))
                .latitud(latitude)
                .longitud(longitude)
                .postnr(postnr)
                .postort(postort)
                .build();

        Annons annons = Annons.builder()
                .id(id)
                .build();

        System.out.println("annons = " + annons);
        assertEquals(id, annons.getId());
    }

}
