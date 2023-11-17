#include "test_utils.h"

#include <iostream>
#include <sstream>

// Converts the string into a series of space-separated decimal integers
//   for each char in the parameter string
std::string char_values(std::string s) {
    std::ostringstream oss;  // Values streamed to oss just like std::cout
    for(char& c : s) oss << static_cast<int>(c) << ' ';
    return oss.str();        // Return all text that was streamed to oss
}


