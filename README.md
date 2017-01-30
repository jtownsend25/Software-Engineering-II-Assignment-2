# Software-Engineering-II-Assignment-2
Repository for Software Engineering II Assignment 2 - card game project

Assignment Specifications

CS 4311 – Winter 2017 – hw2




due: Feb 3, 2017




This is a group assignment. Here are the tasks:

1.Get a group of 3 or 4.


2.Pick one of the games someone in the group did for hw1


3.Create a project site on github.com for your group. Give me the URL so I can check on the activity.


4.Implement a simple, console-based version of the game:

1.Support single battles between 2 players


2.Support using the Strategies from hw1 – you may need to revise the hw1 code, but it should still be recognizable.


3.The main loop for the game should be encapsulated by a child class of the generic Duel class with the play() method as the algorithm and overriding the primitive operations as appropriate.


4.Support choosing Strategies between the options from hw1


5.Each group member should support 3 specific cards from the game. All card classes should be subclasses of a general class/interface Card

1.At least 2 cards should have one or more card-specific properties


2.Support these properties using one of these patterns we have discussed so far: Strategy, Decorator, Observer




◾in the comments for the class representing your specific card, explain why you chose the pattern you chose for adding the special features


◾Provide unit tests for each card class – upload all unit tests to github, too


6.Update the Move class from the first assignment to satisfy the Command pattern. The game should be able to execute the move, but does not need to be able to undo the move.


◦Provide unit tests for each concrete Move subclass





Submission: whatever is on your github repository by the deadline will be the submission.




Grading: You get credit for what you post to the repository, including the comments on the 2 or 3 cards which use patterns to implement the special features. 60% Correctness, 20% design analysis for your special cards, 20% style




Correctness: Whether you are following the patterns appropriately as well as the code runs and does stuff according to your chosen game.




Style: I still want to see comments for each class and method (including the @Test methods of the unit tests). You still need to use good identifier names, though I’ll make an exception for any loop counters in for loops.
