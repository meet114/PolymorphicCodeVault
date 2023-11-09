#include "puzzle.h"

#include <cctype>

Puzzle::Puzzle(std::string solution) : _solution(solution) {
    if (solution.empty()) {
        throw std::invalid_argument("Solution cannot be empty");
    }

    _guesses.insert(' ');
}

Puzzle::~Puzzle() {}

bool Puzzle::guess(char c) {
    c = std::tolower(c);

    if (!std::isalpha(c) || _guesses.count(c) > 0) {
        throw std::invalid_argument("Invalid or already guessed character");
    }

    _guesses.insert(c);

    return _solution.find(c) != std::string::npos;
}

bool Puzzle::solve(std::string attempt) { return attempt == _solution; }

std::string Puzzle::board() {
    std::string result = "";
    for (char c : _solution) {
        if (!std::isalpha(c) || _guesses.count(std::tolower(c)) > 0) {
            result += c;
        } else {
            result += '_';
        }
    }
    return result;
}

std::string Puzzle::solution() { return _solution; }

std::string Puzzle::guesses() {
    std::string result = "";
    for (char c : _guesses) {
        result += c;
    }
    return result;
}