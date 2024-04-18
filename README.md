Semester assignment for Object Oriented Programming at University of Bergen. 

Oppgaven: 
## Oversikt
De to spillene "Tic Tac Toe" og "Connect Four" er allerede ferdig implementert.
Denne semesteroppgaven har 2 hoveddeler:
- Teori, sett deg inn i den eksisterende koden
- Utvid funksjonaliteten ved å legge til et tredje spill som heter [Othello](https://no.wikipedia.org/wiki/Othello_(brettspill)).
Reglene for spillet er ganske enkle men vær sikker på at du forstår reglene rett ellers kan det bli mye ekstra arbeid.

Læringsmål:
- sette seg inn i eksisterende kode
- forstå hva oppgaven ber om, (lese seg opp på reglene for spillet)
- planlegge kodeprosjekt, design av klasser og avhengighet mellom disse
- bruke objektorienterte prinsipper som polymorfisme, arv og abstrakte klasser
- ryddig og lesbar kodestil som gjør vedlikehold/utvidelse av koden enklere.


## Oppgave 1 - Designanalyse
I denne semesteroppgaven har vi allerede laget et fungerende spill for dere.
Dere skal kjøre spillet, se på klassediagrammet og se på koden slik at dere forstår hvordan koden fungerer.
Vi har allerede brukt noen forelesninger på å forstå hvordan denne koden fungerer.
Pakken gui er litt vanskelig å forstå og ikke en viktig del av programmet, de viktigste pakkene å forstå er grid, game og player.

Skriv en analyse av designet som er valgt for den eksisterende koden i prosjektet. Fokuser på hvilke objektorienterte prinsipper som er brukt. Hvis du ser mulige forbedringer er det veldig positivt om du skriver om dette. Svar på følgende spørsmål:

- Nevn noen viktige klasser og hvorfor vi trenger disse klassene?
- Hvor brukes abstraction, encapsulation, inheritance og polymorphism.
- Hvilke andre spill (eller utvidelser) vil det være enkelt å legge til i dette prosjektet, og hvilke spill vil by på utfordringer?
- Hvor er [SOLID](https://en.wikipedia.org/wiki/SOLID) prinsippene brukt/ikke brukt.
Merk at SOLID prinsippene ikke er pensum før i INF112 så vi forventer ikke så mye av dere her,
men de av dere som ønsker å få 15/15 må vise at dere har prøvd litt på dette.

## Oppgave 2 - Plan og klassediagram

Skriv en kort plan for hva du må gjøre for å implementere spillert Othello.
Her bør du skrive opp de klassene du trenger å lage og hvorfor.
Tegn et klassediagram, dere skal få utlevert et klassediagram av den eksisterende koden hvor dere kan legge til de nye klassene.

Dere kan godt gå tilbake til planen og gjøre endringer hvis dere oppdager at det trengs.
Men det kan være en fordel om dere lager en ordentlig plan før dere begynner slik at dere ikke gjør mer koding enn nødvendig.

## Oppgave 3 - Implementer Othello
Utvid funksjonaliteten til prosjektet slik at det også går an å spille Othello.
Spillet skal kunne spilles både fra terminal og fra GUI med flere valg av spillere.

Lesbar kode og gjenbruk av kode er viktig. 

Dere skal teste koden dere skriver. Den koden som er lett å teste med JUnit tester skal dere skrive tester for. Den delen av koden som er vanskelig å teste med JUnit tester skal dere beskrive tester der dere kjører spillet og sjekker at det virker som det skal.
