# Harjoitusohjelmageneraattori
Sovelluksen toiminta tulee olemaan suurinpiirtein seuraavanlainen:
Käyttäjä näkee ensimmäisellä kerralla kirjautuessaan näkymän, jossa kysytään ikää, sukupuolta, harjoitustaustaa, kuinka paljon on mahdollisuus käyttää aikaa harjoitteluun viikossa sekä harjoittelun tavoitteita.
Kaikki yllä mainitut kyselyt toteutetaan monivalintana 2-5 vaihtoehdosta.
Käyttäjän syötettyä tiedot ensimmäisen kirjautumisen jälkeen sovellus antaa käyttäjälle harjoitusohjelman syötettyjen tietojen perusteella. Seuraavilla kerroilla sovellukseen kirjautuessaan käyttäjä näkee käynnissä olevan harjoitusohjelman. Ohjelman suoritettuaan käyttäjältä kysytään palautetta ohjelmasta ja tämän pohjalta sovellus ehdottaa käyttäjälle uutta ohjelmaa.


## Dokumentaatio
[Työaikakirjanpito](https://github.com/rautajan/ot-harjoitustyo/blob/master/dokumentaatio/ty%C3%B6aikakirjanpito.md)

[Vaatimusmäärittely](https://github.com/rautajan/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/rautajan/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md) (alustava luokka-/pakkauskaavio)


## Komentorivitoiminnot
                              
Testien suoritus: "mvn test"

Testikattavuusraportin luonti: "mvn jacoco: report"

Checkstyle-tarkistus: "mvn jxr:jxr checkstyle:checkstyle"
                           

                              
