# Lösung: ADS - 03

###### Author: Clemens Maas
###### Matrikelnummer: 1260892

# Aufgabe 3

3.1
O(n), da die Vorschleife in rechtesRandmax von re bis li n-mal runterzählt und in linkesRandmax von li bis re n-mal hochzählt.

3.2
O(1), da jede Zeile 1x aufgerufen wird.

3.3
O(n)*f(n)

3.4
Anzahl der Folgeglieder = 2^n mit n = die Anzahl der Halbierungen. Daraus resultiert, dass man die genannten Folgen n = log2(Anzahl der Folgeglieder) Mal halbieren kann  

3.5
Anzahl der Folgeglieder = 2^n mit n = die Anzahl der Halbierungen. Daraus resultiert, dass man die genannten Folgen n = log2(Anzahl der Folgeglieder) Mal halbieren kann.
Allerdings muss das n auf oder abgerundet werden.

3.6
Selber Fall wie bei 3.4 und 3.5, da beide Fälle diesmal vereint sind.

3.7
log2(Anzahl der Folgeglieder)

3.8
Da log2(Anzahl der Folgeglieder) die Anzahl der Halbierungen ist, wird die Funktion ein O-Kalkül von O(log2(Anzahl der Folgeglieder)).
