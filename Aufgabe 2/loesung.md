# Lösung: ADS - 02

###### Author: Clemens Maas
###### Matrikelnummer: 1260892

## Aufgabe 1.1

Bei der Berechnung der Gesamtkomplextität muss hier nur bedacht werden das beide Anweisungsfolgen sequentiell hintereinander ausgeführt
werden. Daher verändert es sich nur intern.

O(a) + O(b) = O(a+b)

Bei mehr Infos die Einzelkomplexitäten berechnen?

## Aufgabe 1.2

Bei der If-Clause ist die Ausführung von A1 || A2 untergeordnet. Daher schon einmal O(B + X).
Addition da wir aus 1.1 im Hinterkopf haben, dass hier die Befehle sequentiell abgearbeitet werden.
Da entweder A1 oder A2 eingesetzt werden können, nehmen wir das theoretisch mögliche Maximum, um jeden Fall abzudecken.

Lösung daher >> O(B + max(A1+A2))

## Aufgabe 1.3

Die Gesamtkomplexität fängt ersteinmal mit O(B) an, da jedesmal B ausgeführt wird (verglichen wird).
Wichtig ist aber wie oft die Schleife, also B, ausgeführt wird. So kommen wir zu O(B * n).
Jetzt kommt wieder 1.1 und 1.2 zum Tragen und wir müssen A addieren, welche ebenfalls von n beinflusst wird.

Lösung: O(B * n + n * A)
Lösung: O(B * n + n * max(A1+A2))

## Aufgabe 2

Hier müssen wir eigentlich nur die For-Schleifen betrachten, da die anderen Konstanten wegfallen.

Lösung: O(n³)
