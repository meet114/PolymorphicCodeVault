#include "color.h"
#include "test_utils.h"

#include <iostream>
#include <sstream>

int main(int argc, char* argv[]) {
    int result = 0;
    int vector = 1;
    
    std::ostringstream oss;
    std::string expected[] = {
        "\033[0m",                 // Color color;
        "\033[38;2;13;17;29m",     // Color color{13, 17, 29};
        "\033[48;2;0;43;97m",      // Color color{0, 43, 97, Color_mode::BACKGROUND};
        "\033[38;2;46;85;113m",    // Color c1{16, 24, 36} + Color c2{31, 67, 89};
    };
    
    {
        Color reset;
        oss.str("");
        oss << reset;
        if(oss.str() != expected[0]) {
            result |= vector;
            std::cerr << "FAIL: default Color constructor wrong output\n"
                      << "Expected: " << char_values(expected[0]) << "\n"
                      << "Actual:   " << char_values(oss.str()) << "\n\n";
        }
    }
    vector <<= 1;

    {
        Color color{13, 17, 29};
        oss.str("");
        oss << color;
        if(oss.str() != expected[1]) {
            result |= vector;
            std::cerr << "FAIL: foreground Color constructor wrong output\n"
                      << "Expected: " << char_values(expected[1]) << "\n"
                      << "Actual:   " << char_values(oss.str()) << "\n\n";
        }
    }

    {
        Color color{0, 43, 97, Color_mode::BACKGROUND};
        oss.str("");
        oss << color;
        if(oss.str() != expected[2]) {
            result |= vector;
            std::cerr << "FAIL: background Color constructor wrong output\n"
                      << "Expected: " << char_values(expected[2]) << "\n"
                      << "Actual:   " << char_values(oss.str()) << "\n\n";
        }
    }
    vector <<= 1;

    {
        Color c1{16, 24, 36};
        Color c2{31, 67, 89};
        Color sum = c1 + c2;
        oss.str("");
        oss << sum;
        if(oss.str() != expected[3]) {
            result |= vector;
            std::cerr << "FAIL: operator+ wrong output\n"
                      << "Expected: " << char_values(expected[3]) << "\n"
                      << "Actual:   " << char_values(oss.str()) << "\n\n";
        }
    }
    vector <<= 1;

    // Test comparison operators (BONUS only!)
    if(argc > 1) {
        Color c00{16, 24, 35}; // in sort order from c0 to c4
        Color c01{16, 24, 35}; //   except c00 == c01 and
        Color c1{16, 24, 36};  //          c5 == c6
        Color c2{16, 67, 36};
        Color c3{31, 67, 36};
        Color c4{31, 67, 36, Color_mode::BACKGROUND};
        Color c5{31, 67, 36, Color_mode::RESET};
        Color c6{ 0,  0,  0, Color_mode::RESET};
        // equal variations
        if(!(c00 == c01)) {
            result |= vector;
            std::cerr << "FAIL: {16, 24, 35} NOT == {16, 24, 35}\n";
        }
        if(c00 != c01) {
            result |= vector;
            std::cerr << "FAIL: {16, 24, 35} != {16, 24, 35}\n";
        }
        if(!(c00 <= c01)) {
            result |= vector;
            std::cerr << "FAIL: {16, 24, 35} NOT <= {16, 24, 35}\n";
        }
        if(!(c00 >= c01)) {
            result |= vector;
            std::cerr << "FAIL: {16, 24, 35} NOT >= {16, 24, 35}\n";
        }
        // 3 positions of greater than
        if(c00 == c1) {
            result |= vector;
            std::cerr << "FAIL: {16, 24, 35} == {16, 24, 36}\n";
        }
        if(c1 == c2) {
            result |= vector;
            std::cerr << "FAIL: {16, 24, 36} == {16, 67, 36}\n";
        }
        if(c2 == c3) {
            result |= vector;
            std::cerr << "FAIL: {16, 67, 36} == {31, 67, 36}\n";
        }
        // greater / less variations
        if(c00 >= c1) {
            result |= vector;
            std::cerr << "FAIL: {16, 24, 35} >= {16, 24, 36}\n";
        }
        if(!(c1 < c2)) {
            result |= vector;
            std::cerr << "FAIL: {16, 24, 36} NOT less than {16, 67, 36}\n";
        }
        if(c1 > c2) {
            result |= vector;
            std::cerr << "FAIL: {16, 24, 36} greater than {16, 67, 36}\n";
        }
        if(c2 > c3) {
            result |= vector;
            std::cerr << "FAIL: {16, 67, 36} greater than {31, 67, 36}\n";
        }
        // background variations
        if(c3 == c4) {
            result |= vector;
            std::cerr << "FAIL: {31, 67, 36} == {31, 67, 36, Color_mode::BACKGROUND}\n";
        }
        if(c3 >= c4) {
            result |= vector;
            std::cerr << "FAIL: {31, 67, 36} >= {31, 67, 36, Color_mode::BACKGROUND}\n";
        }
        // reset variations
        if(c4 >= c5) {
            result |= vector;
            std::cerr << "FAIL: {31, 67, 36, Color_mode::BACKGROUND} >= {31, 67, 36, Color_mode::RESET}\n";
        }
        if(c5 != c6) {
            result |= vector;
            std::cerr << "FAIL: {31, 67, 36, Color_mode::RESET} != { 0, 0, 0, Color_mode::RESET}\n";
        }
    }
    
    if(result != 0) std::cerr << "\nFAIL: Error code " << result << std::endl;
    return result;
}
