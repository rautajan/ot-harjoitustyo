# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovelluksen ideana on antaa käyttäjälle harjoitusohjelma kuntosalille
käyttäjän antamien tietojen perusteella. 

## Käyttäjät

- Sovelluksella on aluksi vain yksi käyttäjärooli, eli normaalikäyttäjä.
- Myöhemmässä vaiheessa voidaan mahdollisesti lisätä myös ylläpitäjä, 
jolla on laajemmat oikeudet.

## Perusversion tarjoama toiminnallisuus

### Ennen kirjautumista
- Käyttäjä voi luoda oman käyttäjätunnuksen ja salasanan.
	- Käyttäjätunnuksen tulee olla uniikki ja vähintään neljä merkkiä
	 pitkä.
	- Salasanan tulee olla vähintään viisi merkkiä pitkä.
- Käyttäjä voi kirjautua sovellukseen, jos hän on jo luonut tunnukset.	
	- Jos käyttäjä syöttää salasanan tai käyttäjätunnuksen väärin tai käyttäjätunnusta ei ole, 
	niin sovellus ilmoittaa tästä yhdellä virheviestillä.


### Kirjautumisen jälkeen
- Käyttäjä näkee ensimmäisellä kerralla kirjautuessaan näkymän, jossa
kysytään ikää, sukupuolta, harjoitustaustaa, kuinka paljon on mahdollisuus
käyttää aikaa harjoitteluun viikossa.
	- Kaikki yllämainitut kyselyt toteutetaan monivalintana 2-3 
	vaihtoehdosta.
- Käyttäjän syötettyä tiedot ensimmäisen kirjautumisen jälkeen sovellus 
antaa käyttäjälle harjoitusohjelman syötettyjen tietojen perusteella.
- Seuraavilla kerroilla sovellukseen kirjautuessaan käyttäjä näkee alunperin ensimmäisellä kirjautumiskerralla sovelluksen valitseman
harjoitusohjelman.

## Käyttöliittymä
Sovelluksessa tulee olemaan graafinen käyttöliittymä.

## Jatkokehitysideoita

- Sovellusta käyttävien käyttäjien määrä/luotujen harjoitusohjelmien määrä.
-  Kaikkien käyttäjien suoritetut harjoitusohjelmat(lukumäärä).
- Palaute harjoitusohjelmista vastaavilta käyttäjiltä(kuinka sopivaksi kyseinen
ohjelma on koettu).
- Tehtyjen harjoitusten ja niiden onnistumisen  merkitseminen sovellukseen(edistymisen
reaaliaikainen seuranta).
	 - Tätä dataa voidaan mahdollisesti käyttää seuraavan viikon ja/tai seuraavan
	 harjoitusohjelman muokkaamiseen käyttäjälle vielä sopivammaksi.
- Ylläpitäjän lisäys
- Ohjelman suoritettuaan käyttäjältä kysytään palautetta ohjelmasta ja tämän 
pohjalta sovellus ehdottaa käyttäjälle uutta ohjelmaa.



### Toimintaympäristön rajoitteet
+ Sovelluksen tulee toimia Linux-käyttöjärjestelmällä varustetulla koneella.
+ Käyttäjien tiedot ja sovelluksen muut mahdolliset tiedot tallennetaan paikallisen
koneen kovalevylle.  
