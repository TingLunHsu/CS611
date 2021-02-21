1. Description of each classes

            BoardBasedGame
                /        
               /         
      ConnectBasedBame
        /      \
       /        \
  TicTacToe   OrderChaos 

BoardBasedGame: 
	An abstract class that can be the super class of any other 
	board based game

ConnectBasedBame:
	An abstract class that can be the super class of any other 
	connect based game. It contains some common methods used
	in connect based games, such as TicTacToe, Order and Chaos, 
	Connect Four, Gobang

TicTacToe:
	A class for players to play TicTacToe

OrderChaos:
	A class for players to play Order and Chaos

Board:
	A board class that can be used to play any 2D board-based game

Player:
	A class that play games in the game series

MultipleGames:
	A class that allows two players to play several games in choice of
	TicTacToe and Order and Chaos


2. How to compile and run the code
$ make build
$ make run


3. How to play
Simply follow the instruction from the program

4.
- I used an 2D Object array in Board class to make it more extendible.
  So for games that simply contain O/X, it can use char. For other games such as chess, I can simply add another Chess class to represent each
  chess.
- For whichever kind of connect based game that only use O/X (or any 
  two type of marks), it can inherit from ConnectedBasedGame, and it 
  contains several common used methods for this type of games.
