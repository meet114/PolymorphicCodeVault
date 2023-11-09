#include <iostream>
#include <string>

#include "firecracker.h"
#include "puzzle.h"

int main(int argc, char* argv[]) {
    if (argc < 2) {
        std::cout << "Usage: " << argv[0] << " 'phrase to guess'" << std::endl;
        return 1;
    }

    try {
        // Banner
        std::cout << "=== BOOM! Word Guessing Game ===" << std::endl;
        std::cout << "Guess letters or solve the puzzle before the firecracker goes boom!"
                  << std::endl;
        std::cout << "Enter '0' to give up or '!' to solve the puzzle." << std::endl;
        std::cout << "============================" << std::endl << std::endl;

        Firecracker fuse(8);
        Puzzle puzzle(argv[1]);

        bool gameOver = false;
        bool playerWon = false;

        while (!gameOver) {
            std::cout << "Firecracker: " << fuse.firecracker() << std::endl;
            std::cout << "Guessed: " << puzzle.guesses() << std::endl;
            std::cout << "Board: " << puzzle.board() << std::endl;

            std::cout << "Your guess: ";
            char guess;
            std::cin >> guess;
            std::cin.ignore(10000, '\n');

            if (guess == '0') {
                std::cout << "You gave up! The answer was: " << puzzle.solution() << std::endl;
                gameOver = true;
            } else if (guess == '!') {
                std::cout << "Enter solution: ";
                std::string solution;
                std::getline(std::cin, solution);

                if (puzzle.solve(solution)) {
                    playerWon = true;
                    gameOver = true;
                } else {
                    std::cout << "Wrong solution! The firecracker goes BOOM!" << std::endl;
                    gameOver = true;
                }
            } else {
                try {
                    bool correctGuess = puzzle.guess(guess);
                    if (!correctGuess) {
                        bool stillAlive = fuse.tic();
                        if (!stillAlive) {
                            std::cout << "BOOM! The firecracker exploded!" << std::endl;
                            gameOver = true;
                        }
                    }
                } catch (const std::invalid_argument& e) {
                    std::cout << "Invalid guess: " << e.what() << std::endl;
                }
            }

            std::cout << std::endl;
        }

        if (playerWon) {
            std::cout << "Congratulations! You solved the puzzle: " << puzzle.solution()
                      << std::endl;
        } else if (!gameOver) {
            std::cout << "Game over! The puzzle was: " << puzzle.solution() << std::endl;
        }

        return 0;
    } catch (const std::exception& e) {
        std::cerr << "Error: " << e.what() << std::endl;
        return 1;
    }
}