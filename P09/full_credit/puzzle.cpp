#include "puzzle.h"

#include <cctype>

Puzzle::Puzzle(std::string solution) : _solution(solution), _guesses(" ") {
    if (solution.empty()) {
        throw std::invalid_argument("Solution cannot be empty");
    }
}

Puzzle::~Puzzle() {}

bool Puzzle::guess(char c) {
    c = std::tolower(c);

    if (!std::isalpha(c) || _guesses.find(c) != std::string::npos) {
        throw std::invalid_argument("Invalid or already guessed character");
    }

    _guesses += c;

    return _solution.find(c) != std::string::npos;
}

bool Puzzle::solve(std::string attempt) { return attempt == _solution; }

std::string Puzzle::board() {
    std::string result = "";
    for (char c : _solution) {
        if (!std::isalpha(c) || _guesses.find(std::tolower(c)) != std::string::npos) {
            result += c;
        } else {
            result += '_';
        }
    }
    return result;
}

std::string Puzzle::solution() { return _solution; }

std::string Puzzle::guesses() { return _guesses; }