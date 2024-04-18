# Svar på spørsmål

*I denne filen legger du inn svar på spørsmålene som stilles i oppgaveteksten, eventuelt kommentarer og informasjon om kreative løsninger*

   
## Oppgave 1
- Noen viktige klasser og hvorfor vi trenger de:
Game for eksempel er en viktig klasse, fordi den er abstrakt, og mange klasser arver fra den. Game er på en måte "alle tre spillene i ett". Både tictactoe, connectfour og othello,
  er svært avhengig av denne klassen. Andre klasser som også er viktige er for eksempel GameBoard og PlayerList. Dette fordi alle andre klasser er avhengig av å ha ett spillbrett, og er avhengig av å vite 
  hvilke spillere som er med, hvem sin tur det er osv. Et spill ville ikke vært et spill om det ikke var holdt styr på hvem sin tur det er osv. 



- Abstraction blir brukt i: Game-klassen, og i alle interfacene (Player, IGrid, Graphics, ActionListener, MouseListener). 
  Game er en abstrakt klasse med abstrakte metoder, og alle interfacene har abstrakte metoder. Disse klassene og interfacene er abstrakte, 
  fordi de ikke blir direkte brukt, de blir utvidet og implementerte i andre klasser. 
  Encapsulation blir feks brukt i: 
  Grid.java. Dette fordi metodene numColumns() og numRows() må hente ut private final int rows og columns. Man må bruke en metode for å hente ut verdien, og det blir encapsulation. 
  Vi finner også encapsulation i feks PlayerList. Her henter vi ut currentIndex gjennom getCurrentPlayer()-metoden.
  
  Inheritance finner vi i alle klassene som "extender" andre klasser, som feks. ConnectFour(extends Game), ClickableGrid(extends JPane) osv.
  Ett interface, som feks IGrid(extends Iterable<T>) kan ikke instansieres, men klasser som implementerer feks. IGrid (eller andre interfaces), 
  kan bli instansiert. 
  
  Polymorphism er når en metode kan gjenbrukes på mange typer objekter så lenge de følger interfacet. Eksempler på dette er interfacet 
  IGrid. I TicTacToe.java feks. lager vi ett nytt gameboard ved hjelp av metoden GameBoard(int rows, int cols) som er fra GameBoard.java. GameBoard.java extends Grid.java,
  og Grid.java implementerer interfacet IGrid. Med andre ord: interfacet IGrid er brukt mange plasser. 

  
- Andre spill som vil være enkelt å legge til er for eksempel stigespillet. Dette fordi stigespillet har overkommelige regler, og kan bruke veldig mange
  av de metodene og klassene som allerede finnes. Stigespillet trenger ett grid, det trenger spillere (kan være multiplayer, spille mot AI, eller flere spillere), det trenger brikker/farger, 
  og det trenger å kunne flytte spillere/brikker i flere ulike retningen. Alle desse egenskapene finnes det metoder for allerede, og det vil derfor være lett å legge til. 
  
  Spill som kan by på utfordinger er spill som er veldig komplekse, med mange regler. Dette kan feks. være sjakk. Sjakk krever mange ulike brikker, der alle brikkene har ulike regler
  for hvordan de kan flytte seg osv. Her skal man i tillegg kun ha to spillere, og dette kan by på utfordringer da hver spiller skal "eie" mange ulike brikker, med forskjellige regler, og man
  i tillegg skal ha annenhver tur. Dette spillet krever også mye grafikk da man må se forskjell på de ulike brikkene, og hvem som tilhører hvem. Å lage dette spillet resulterer i svært mye kode, også gjerne tung kode som
  fort kan bli uoversiktlig. I tillegg krever det veldig mye å lage AI-spillere til sjakk, i hvertfall om den skal være en god spiller, da det er mye å ta til grunn for. 
  
- SOLID; Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, Dependency Inversion
Single responsibility finner vi for eksempel i RandomPlayer.java. Denne klassen har kun en enkelt oppgave, og det er å hente getMove(). Ett annet eksempel er TerminalInput.java. Denne klassen har one single responsibility; å lese inn input.
Single responsibility er bra fordi dess mindre funksjonalitet det er i en klasse, dess mindre avhengigheter er det --> lettere å teste, mer oversiktlig og organisert. 
  
Open/Closed: det skal være åpent for utvidelser, men stengt for modifikasjon. Dette finner vi feks i interfacene. 
Der kan vi override og endre, men ikke endre selve metoden i interfacet. Da er vi sikre på at metodene i interfacet forblir uendret, men vi kan legge til flere ting om vi ønsker. 
Ett eksempel på dette er Game.java. Othello, tictactoe og connectfour extender Game, og de forskjellige spillene kan ha andre metoder enn Game, men vi kan ikke forandre på Game. 

Liskov Substitution:
Dersom en klasse A er en subtype av en annen klasse B, skal vi kunne bytte ut klasse B med klasse A uten å ødelegge funksjonaliteten til programmet. 
Ett eksempel på dette er feks når vi bruker game.makeMove(). Her bytter vi ut feks ConnectFour-klassen med Game klassen, uten å ødelegge noe for koden.

Interface segregation:
Store interface skal bli splittet i flere små interfaces, slik at de klassene som arver fra interfacene kun får de metodene som faktisk er nødvendig. 
Dette er ikke brukt i dette programmet, da de interfacene vi har ikke implementerer andre interface.

Dependency Inversion:
Høg-level moduler skal ikke være avhengig av lav-level moduler, begge skal være avhengige av abstraksjon.
Main.java har ikke dependecy direkte på feks tictactoe og connectfour, den har en avhengighet gjennom game.java. 



## Oppgave 2
	Lage othello.java, deretter legge othello inn i både MainMenu og TerminalMenu. 
	Lage til grid på 8x8 ruter i othello.java.
	Legge inn reglene som gjelder spesifikt for othello i othello.java:
-	Startpos. til brikkene, dvs. to svarte og to hvite brikker i midten av griden. Må legges til i konstruktøren. Dette kan sjekkes at fungerer manuelt i både GUI og terminal. 
-	Sjekke hvor man kan legge brikker, dvs. plasser der det ikke allerede ligger brikker fra før av, bruke canPlace(). 
-	Dersom ingen brikker ligger på den valgte posisjonen  sjekke videre om det er lovlig å legge der, med å sjekke at det ligger brikker av motstanderen imellom den valgte posisjonen og på enden av den retningen man sjekker. Ny metode checkDirection(), som bruker griddirection for å sjekke vertikalt, horisontalt, og diagonalt. 
-	Dersom man kan legge noen plass  bytte farge på motstanderen sine brikker som ligger imellom to av sine egne brikker, i de lovlige retningene. Må lage en ny metode changeColor() i GameBoard.java som plasserer spiller på brikkene imellom, det er spiller som avgjør hvilken farge det er, og det er spilleren som er plassert på lokasjonen, ikke fargen i seg selv. 
-	Legge brikke der spilleren har valgt, etter at alle reglene er sjekket, bruke makeMove() her. 
-	Dersom man ikke kan legge noen plass, er det neste spiller sin tur. Dette må også skje i makeMove() metoden som er overridet.
-	Når alle spillerne har lagt alle sine mulige brikker, er spillet over. Dette skjer både når det ikke lenger er mulig for noen av spillerne å legge brikker på lovlig plass og turen går videre til hverandre i loop (selv om alle 64 rutene ikke inneholder brikker), eller når alle 64 ruter er fylt opp av brikker(spillere). Bruke gameOver() metoden, og bruke possibleMoves() for å sjekke. 
-	Vinneren er den som står igjen med flest av sine brikker når det er game over. Her må vi telle antall ruter som hver spiller har. Lage en ny metode countsBricksForPlayer() som teller brikkene, og som brukes i isWinner()-metoden. 
	Legge inn slik at AI kan bli brukt.
	Til slutt; design:
-	Endre farger på brikkene til svart og hvit i getColors() i gameGUI.java
-	Endre bakgrunnen på rutenettet til grønt??





## Oppgave 3
Opprettet først filen Othello.java under mappen game, som skal utvide Game slik som TicTacToe og ConnectFour gjør. 
Deretter la jeg til Othello i både TerminalMenu og MainMenu, ved å legge til playOthelloButtons i MainMenu, og ved å endre på teksten i selectGame():TerminalMenu.
Det neste jeg gjorde var å legge inn de to start-brikkene til hver spiller i midten av griden.
Dette gjorde jeg ved å legge inn under Othello(Graphics graphics, player p1, player p2)
for å få det i terminalen, og under Othello(Graphics graphics, Iterable<Player> players) for å få det
i GUI-en. Dette fordi den ene konstruktøren blir brukt i terminal, og den andre blir brukt i GUI-en.
Dette testet jeg at funket med å kjøre både MainGUI og MainTerminal. 

Testing av TerminalMenu, Othello-oppstart:
1. Kjørte MainTerminal, fikk frem spørsmål om hva spilleren (jeg) skal hete. 
2. Skrev inn navnet, og fikk deretter opp valg om jeg ville spille multiplayer eller mot datamaskinen.
3. Skrev da inn tallet '1' først, og prøvde senere samme prosedyre (1-2) men denne gangen med tallet '2' (mot datamaskinen).
4. Fikk opp tekst som spurte etter navn til spiller to, skrev da inn et navn.
5. Fikk valgmuligheter om hvilke spill jeg ønskte å spille, trykte deretter på tallet '3' (Othello).
6. Fikk opp ett 8x8 grid med to brikker av hver spiller diagonalt over hverandre. 

Testing av MainMenu, Othello:
1. Kjørte MainMenu, fikk opp en GUI/meny med de tre spillene som valgmulighet. 
2. Trykte på Othello-spillet, fikk opp en GUI-dialog. 
3. Skrev inn navnet til spilleren (jeg).
4. Fikk deretter opp valgmuligheter om å spille mot multiplayer, eller mot AI.
5. Valgte multiplayer først, deretter prøvde jeg samme prosedyre (1-4) med AI. 
6. Fikk opp en ny GUI-dialog etter å ha valgt multiplayer, og skrev inn navn på den andre spilleren (med AI kommer ikke denn dialogen opp)
7. Fikk deretter opp ett 8x8 grid med to brikker av hver spiller diagonalt over hverandre.
8. Trykte deretter på 'Go back' og fikk opp i terminalen at spillet var avsluttet. 
9. Gjorde samme prosedyre (1-7), men trykte denne gangen på 'restart'.

Alt dette funket som det skulle, så gikk derfor videre i planen min. 

Sjekket om det ligger en brikke der spilleren vil plassere ved hjelp av metoden
canPlace(). Dersom canPlace() er true, dvs. at det ikke ligger brikker på den valgte ruten, 
sjekker vi videre de åtte retningene det er mulig å legge. Dette gjør vi ved hjelp av å iterere over de forskjellige retningene, 
og deretter ved hjelp av checkDirection().
I checkDirection() finner vi først ut lokasjonen og hvilken spiller sin tur det er. Dersom cellen ikke er "tatt" av den spilleren som nå har sin tur,
eller ikke er en tom celle, sjekker vi videre om spilleren kan gå der ved hjelp av canGo() der vi tar inn den nåværende lokasjonen, og sjekker de åtte retningene. 
Dersom de verdiene vi nettopp fann er samme verdier som nåværende spiller, returnerer vi true. 
Viss spilleren ikke kan velge disse verdiene, returnerer vi false. 
Lagde til testen canGoTest() i OthelloGridTest.java for å sjekke om alt stemmer i forhold til reglene om å plassere brikker

Det neste jeg gjorde var å legge til slik at motstanderen sine brikker, som låg i mellom to av mine brikker, byttet farge. 
Det gjorde jeg ved hjelp av metoden makeMove(). Denne måtte vi override i Othello.java, da Othello-spillet skal ha egne regler som er spesifikt for Othello spillet. 
I makeMove() sjekker vi først om man kan legge på den valgte lokasjonen. Viss ikke, kaster vi exception. Dersom vi kan legge, setter vi currentPlayer (dvs. meg i denne sammenhengen),
på lokasjonen vi er på. Deretter iterer vi over alle de mulige retningene, nesten samme måte som i canGo(), og deretter sjekker om man finner sine egne brikker i retningene. 
Dersom ja, så har vi en midlertidig lokasjon (temp), som vi lagrer lokasjonen til naboen i, slik at den kan iterer seg i retningen. 
I while-løkken oppdaterer den alle lokasjonene med seg selv (currentPlayer), helt til den finner seg selv. Dette gjør at brikker som ligger i mellom to av mine brikker, endrer farge. 
Her måtte jeg lage en ny metode changeColor() for å kunne endre hvilken spiller som er registrert på hvilken lokasjon, siden den orginale board.set bruker canGo(), 
og den sier det er et ulovlig trekk da det allerede er registrert en spiller på den lokasjonen. changeColor() tvinger den til å endre dette, og denne metoden ligger i 
GameBoard.java. Når alle retningene er sjekket og alle brikker er byttet farge på, er det neste spiller sin tur. 
Sjekket at makeMove fungerte som den skulle ved hjelp av makeMoveTest() i OthelloTest.java. 

Deretter fikset jeg at det blir neste spiller sin tur, dersom det ikke er flere gyldige trekk. Dette gjorde jeg i makeMove(). Her la jeg først inn players.nextPlayer()
etter for-løkken for å velge neste spiller. Dette fordi at da kan man sjekke possible moves til neste spiller, før neste spiller eventuelt skal legge. Dersom neste spiller ikke kan legge,dvs. possible moves listen 
er tom, går turen tilbake til den første spilleren igjen. Her fikset jeg også opp i en bug i checkDirection(). Der la jeg til at dersom board ikke er innenfor det gitte rutenettet, returner false. 
Dette for å unngå at naboane til lokasjonen man er på, ikke skal være utenfor rutenettet. Her prøvde jeg å lage en test som sjekket dette, men å finne alle trekkene man må legge for å ende opp med ingen mulige valg, er veldig tidkrevende. 
I tillegg når jeg brukte board.set() i test-filen og plottet inn brikker på plasser som endte opp med å gi ingen mulige plasser å plassere, funket ikke dette. Dette fordi når man skal makeMove, er kun de fire startbrikkene plottet inn i boardet, som spiller bruker. 
I testen blir kun en kopi av brettet brukt, og det vil derfor ikke gi riktig utslag. Istedenfor, testet jeg ved å legge inn alle brikkene under konstruktøren i Othello.java, og deretter kjørte spillet derifrå, og
testet videre at det faktisk ble neste spiller sin tur. Jeg har kommentert ut testen, så dere kan se hvilke plasseringer jeg la inn brikkene på manuelt. 
Hva som ender med ugyldige trekk fann jeg på wikipedia-siden (https://no.wikipedia.org/wiki/Othello_(brettspill)).


Deretter laget jeg til gameOver(). Her sjekker vi om getPossibleMoves er tom, og dersom den er det, returnerer vi true, false otherwise.
Dette blir riktig fordi getPossibleMoves tar til høgde for at det er lovlig for noen av spillerene å legge, og dersom alle 63 ruter i rutenettet er fylt opp, 
er det ingen possible moves, som igjen fører til game over. Dette sjekket jeg ved å spille spillet helt til hele griden var fylt opp, og ved å gjøre på samme måte som ovenfor i makeMove().

I isWinner() setter jeg først counteren for begge spillerne lik 0. Deretter iterer jeg over alle spillerne som er med, i dette tilfelle spiller 1 og spiller 2, 
og bruker deretter hjelpemetoden countsBricksForPlayer(). I countsBricksForPlayer() itererer vi over alle radene og kolonnene i rutenettet, og teller antall brikker. 
Dette tallet blir lagret i en temporary variabel, og dersom den lokasjonen vi teller tilhører den nåværende spilleren, blir det lagt til 1 i counteren. 
Counter blir deretter sendt tilbake til isWinner, og dette gjør vi for begge spillerne. Deretter sammenlikner vi antall brikker den nåværende spilleren har, 
men den motsatte spilleren, og returner true dersom den nåværende spilleren har flest brikker, og det er den nåværende spilleren som vinner. 
Dersom denne er false, vil loopen bli kjørt en gang til, og den andre spilleren blir kåret som vinner isteden. 

Både gameOver() og isWinner() sjekket jeg at fungerte i testen gameOverAndIsWinner(). Her har jeg plottet inn alle plasseringene som i denne youtube-filmen, https://www.youtube.com/watch?v=sJgLi32jMo0 ,
og vet derfor at hvit ender opp med å vinne. Etter at alle brikkene er lagt, skal spillet også være over. Jeg sjekket også manuelt at alle brikkene som vart plassert i youtube-filmen, kunne bli plassert
i dette programmet også, og at alle brikkene endte opp med samme farge som i filmen. gameOverAndIsWinner()-testen sjekker også om alt er som det skal, da desse lokasjonene er hentet fra ett ekte spill.
Her kunne jeg selvsagt laget egne tester for naboene, om de ulike griddirections osv, men denne testen var tidkrevende, og jeg 
er 100% sikker at dersom denne testen passerer, så fungerer alle reglene i spillet. Dette fordi akkurat desse plasseringene, i akkurat den rekkefølgen, skal gi samme resultat som i ett ekte spill, noe det gjør
sammenliknet med youtube-filmen. Jeg kan derfor med sikkerhet si at spillet fungerer som det skal. 

Alt av regler er nå på plass, og det neste jeg sjekker er AI-spilleren. Dette fungerte som den skulle. 
Dette testet jeg både i terminal og i GUI at funket. Her prøvde jeg meg frem med mange forskjellige trekk, og spilte helt til det var gameover. 
AI gikk aldri tom for trekk. Prøvde også å bytte level på AI, og prøvde da både med 1,2,3,4 og 5. Alt dette funket også. 
Tislutt gikk jeg inn i GameGUI.java og forandret brikkene til svarte og hvite (tok lysegrå som hvit for å bedre se brikkene).



   





