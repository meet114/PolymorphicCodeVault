#include <cstdlib>
#include <ctime>
#include <fstream>
#include <iostream>
#include <set>
#include <string>

#include "firecracker.h"
#include "puzzle.h"

int main(int argc, char* argv[]) {
    if (argc < 2) {
        std::cout << "Usage: " << argv[0] << " <file of puzzles>" << std::endl;
        return 1;
    }

    try {
        srand(time(NULL));

        std::ifstream puzzleFile(argv[1]);
        if (!puzzleFile) {
            throw std::runtime_error("Could not open file " + std::string(argv[1]));
        }

        std::set<std::string> puzzles;
        std::string line;
        while (std::getline(puzzleFile, line)) {
            puzzles.insert(line);
        }

        std::cout << puzzles.size() << " quotes loaded." << std::endl;

        int index = rand() % puzzles.size();
        auto it = puzzles.begin();
        std::advance(it, index);

        Puzzle puzzle(*it);

        std::cout << "=================\n";
        std::cout << "   B O O M !\n";
        std::cout << "=================\n" << std::endl;

        std::cout << "Enter lower case letters to guess,\n"
                  << "! to propose a solution,\n"
                  << "0 to exit.\n"
                  << std::endl;

        Firecracker fuse(8);
        bool gameOver = false;
        bool playerWon = false;

        while (!gameOver) {
            std::cout << fuse.firecracker() << std::endl;
            std::cout << "Guessed: " << puzzle.guesses() << std::endl;
            std::cout << puzzle.board() << ": ";

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
                    int count = puzzle.guess(guess);
                    std::cout << "Found " << count << " " << guess << std::endl;

                    if (count == 0) {
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