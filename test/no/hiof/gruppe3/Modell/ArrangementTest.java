package no.hiof.gruppe3.Modell;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class ArrangementTest {

    Arrangement arr;

    @BeforeEach
    void init(){
        arr = new Arrangement();
    }


    @DisplayName("sjekker om arrangementsdato er like datoen for i dag.")
    @Test
    void testOmArrangemetsdatoErLikDatoForIdag(){
        arr.setTidspunktForArrangement(LocalDate.now());

        assertEquals(LocalDate.now(), arr.getTidspunktForArrangement() );
    }

    @DisplayName("sjekker om arrangementsdato settes til null om arrangementsdato settes til å være en dato som er tildigere enn dagensdato.")
    @Test
    void testArrangemetsdatoMedEnDatoSomErTildigereEnnDagensdato(){
        arr.setTidspunktForArrangement(LocalDate.of(2018,10,4));

        assertEquals(null, arr.getTidspunktForArrangement() );
    }

    @DisplayName("sjekker om arrangementsdato settes til den datoen vi velger om den er nyere en dagensdato .")
    @Test
    void testArrangemetsdatoMedEnDatoSomErNyereEnnDagensdato(){
        arr.setTidspunktForArrangement(LocalDate.of(2020,11,5));

        assertEquals(LocalDate.of(2020,11,5), arr.getTidspunktForArrangement() );
    }

    @DisplayName("sjekker om at arrangementsdato ikke settes til å være lik null om den er nyere dato enn dagensdato.")
    @Test
    void testNotEquals(){
        arr.setTidspunktForArrangement(LocalDate.of(2020,11,5));
        assertNotEquals(null,arr.getTidspunktForArrangement());
    }

    @DisplayName("sjekker om arrangementene som returneres fra rrangementListe når brukeren søker etter Moss Klubb er lik expectedList")
    @Test
    void testOmMetodenReturnererArrangementListeAvArrangementerEnSøktKlubbArrangerer(){
        ArrayList <Arrangement> expectedList = new ArrayList<>();
        expectedList.add(new Arrangement("riding",mossKlubb,"Moss",LocalDate.of(2020,10,04),370,250));
        expectedList.add(new Arrangement("Adventure Racing",mossKlubb,"Moss",LocalDate.of(2020,9,5),275,200));

        Main m = new Main();
        ArrayList <Arrangement> actualList = arr.arrangementerDenSøkteKlubbenSkalArrangere(m.getArrangementListe(), "Moss Klubb");
        assertEquals(expectedList,actualList);

    }






}