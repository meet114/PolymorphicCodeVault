#include "puzzle.h"

#include <cctype>

Puzzle::Puzzle(std::string solution) : _solution(solution) {
    if (solution.empty()) {
        throw std::invalid_argument("Solution cannot be empty");
    }

    for (char& c : _solution) {
        c = std::tolower(c);
    }

    _guesses.insert(' ');
}

Puzzle::~Puzzle() {}

int Puzzle::guess(char c) {
    c = std::tolower(c);

    if (!std::isalpha(c) || _guesses.count(c) > 0) {
        throw std::invalid_argument("Invalid or already guessed character");
    }

    _guesses.insert(c);

    return std::count(_solution.begin(), _solution.end(), c);
}

bool Puzzle::solve(std::string attempt) { return attempt == _solution; }

std::string Puzzle::board() {
    std::istringstream iss(_solution);
    std::ostringstream oss;

    char c;
    while (iss.get(c)) {
        if (!std::isalpha(c) || _guesses.count(c) > 0) {
            oss << c;
        } else {
            oss << '_';
        }
    }

    return oss.str();
}

std::string Puzzle::solution() { return _solution; }

std::string Puzzle::guesses() {
    std::string result = "";
    for (char c : _guesses) {
        result += c;
    }
    return result;
}
bool Puzzle::solved() {
    for (char c : _solution) {
        if (std::isalpha(c) && _guesses.count(c) == 0) {
            return false;
        }
    }
    return true;
}