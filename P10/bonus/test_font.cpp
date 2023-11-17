#include "font.h"
#include "test_utils.h"

#include <iostream>
#include <sstream>

int main() {
    int result = 0;
    int vector = 1;
    
    std::ostringstream oss;
    std::string expected[] = {
        "\033[0m",    // Font font{0};
        "\033[21m",   // Font font{21};
    };
    
    {
        Font font;
        oss.str("");
        oss << font;
        if(oss.str() != expected[0]) {
            result |= vector;
            std::cerr << "FAIL: default Font constructor wrong output\n"
                      << "Expected: " << char_values(expected[0]) << "\n"
                      << "Actual:   " << char_values(oss.str()) << "\n\n";
        }
    }
    vector <<= 1;

    {
        Font font{21};
        oss.str("");
        oss << font;
        if(oss.str() != expected[1]) {
            result |= vector;
            std::cerr << "FAIL: non-default Font constructor wrong output\n"
                      << "Expected: " << char_values(expected[0]) << "\n"
                      << "Actual:   " << char_values(oss.str()) << "\n\n";
        }
    }
    vector <<= 1;

    {
        Font f00;
        Font f01{0};
        Font f8{8};
        if(!(f00 == f01)) {
            result |= vector;
            std::cerr << "FAIL: {0} NOT == {0}\n";
        }
        if(f00 != f01) {
            result |= vector;
            std::cerr << "FAIL: {0} != {0}\n";
        }
        if(!(f00 >= f01)) {
            result |= vector;
            std::cerr << "FAIL: {0} NOT >= {0}\n";
        }
        if(!(f00 <= f01)) {
            result |= vector;
            std::cerr << "FAIL: {0} NOT <= {0}\n";
        }
        if(f00 >= f8) {
            result |= vector;
            std::cerr << "FAIL: {0} > {8}\n";
        }
        if(f8 <= f00) {
            result |= vector;
            std::cerr << "FAIL: {8} <= {0}\n";
        }
        if(!(f00 < f8)) {
            result |= vector;
            std::cerr << "FAIL: {0} NOT < {8}\n";
        }
        if(!(f8 > f00)) {
            result |= vector;
            std::cerr << "FAIL: {8} NOT > {0}\n";
        }
    }

    if(result != 0) std::cerr << "\nFAIL: Error code " << result << std::endl;
    return result;
}
