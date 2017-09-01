# RoundAboutTesting

The basic structure of how rounds are tracked goes like this:

Round
* Round Number
* List of Actors
* Current Actor
* Index of Next Actor
  
Actor
* Name
* Initiative
* Active
* ArrayList of Effects
  
Effect
* Duration
* Description
* Initiative Count
* Active

Every time a round number is changed, it modifies the durations of all the effects. Every time the round moves to the next actor, each effect's duration, it _should_ change the durations of each effect. This will prove more difficult than it seems, but I'm confident I can work it out.

Operations the Driver can perform:
* __next round__ - Increments the round without changing the current actor, changing all of the durations. _Should_ simply reset to the beginning of the next round with appropriate changes.
* __set round__ - Changes the round number by the amount input, but _should_ reset the round to the beginning of its order once reached.
* __next actor__ - Properly changes to the next actor, and when at the last actor, changes the round number and changes the current actor to the one with the highest initiative. _Should_ change each duration as appropriate. Will be harder than it seems, because simply checking if a durations initiative count is higher than the current actor's, it would simply decrease every single time. __NEEDS THOUGHT__
* __add actor__ - Adds an actor and an initiative to the list of actors. The actor is inserted into the ArrayList and sorted into the proper position.
* __hide actor__ - Hides an actor appropriately. _Should_ work with duplicate names, but currently doesn't. Need to figure out how to do it with duplicate names. __Probably easier the whole actor object was used to check, rather than just the name, but that's a pain in the ass to do through Eclipse's terminal at the moment.__
* __add effect__ - Adds an effect and a duration to an actor's list of effects. _Should_ also save the initiative count that it was added, but doesn't. Probably simple! Doesn't seem unreasonable.
* __hide effect__ - Hides an effect appropriately. _Should_ work with duplicate descriptions, but currently doesn't. Need to figure out how to do it with duplicate descriptions. __Probably easier the whole effect object was used to check, rather than just the name, but that's a pain in the ass to do through Eclipse's terminal at the moment.__
