# Polynames

## Modèle relationnel

Voici le modèle relationnel associé au diagramme draw.io : 

**Game**(<ins>id</ins>, *hintId*, Authentication Code, Score, Spymaster, Operative, Turn)

**Hint**(<ins>id</ins>, hintValue, cards_number)

**Card**(<ins>Word</ins>, *wordId*, *gameID* Color, State)

**Words**(<ins>id</ins>, Word)
