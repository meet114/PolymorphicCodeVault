#include <iostream>

int main() {
    std::cout << "IMPORTANT: This program demonstrates the capabilities of your terminal.\n";
    std::cout << "    Your terminal need NOT implement everything here!\n";
    std::cout << "    Colors and a few fonts are enough to test your code.\n";
    std::cout << "    If you can't find a terminal that works at all, don't worry.\n";
    std::cout << "    Just rely on the test_font and test_color regression tests.\n";
    std::cout << "    If those work, you're good to go!\n\n";
    
    std::cout << "\033[31m" << "This should be red\033[0m\n";
    std::cout << "\033[32m" << "This should be green\033[0m\n";
    std::cout << "\033[34m" << "This should be blue\033[0m\n";

    std::cout << "\033[41m" << "This should be highlighted in red\033[0m\n";
    std::cout << "\033[42m" << "This should be highlighted in green\033[0m\n";
    std::cout << "\033[44m" << "This should be highlighted in blue\033[0m\n";

    std::cout << "\033[1m" << "This should be bold\033[0m\n";
    std::cout << "\033[2m" << "This should be dim\033[0m\n";
    std::cout << "\033[3m" << "This should be italic\033[0m\n";
    std::cout << "\033[4m" << "This should be underline\033[0m\n";
    std::cout << "\033[21m" << "This should be double-underline\033[0m\n\n";
    std::cout << "\033[53m" << "This should be overlined\033[0m\n";
    std::cout << "\033[5m" << "This should be slowly blinking\033[0m\n";
    std::cout << "\033[6m" << "This should be blinking\033[0m\n";
    std::cout << "\033[7m" << "This should be reversed colors\033[0m\n";
    std::cout << "\033[9m" << "This should be strike out\033[0m\n";
}
