#ifndef PUZZLE_H
#define PUZZLE_H
#include <algorithm>
#include <set>
#include <stdexcept>
#include <string>

class Puzzle {
   private:
    std::string _solution;
    std::set<char> _guesses;

   public:
    Puzzle(std::string solution);
    virtual ~Puzzle();
    int guess(char c);
    bool solve(std::string attempt);
    std::string board();
    std::string solution();
    std::string guesses();
};

#endif