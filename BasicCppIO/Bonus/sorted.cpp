#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

int main(int argc, char* argv[]) {
    std::vector<std::string> words;
    for (int i = 1; i < argc; ++i) {
        words.push_back(argv[i]);
    }

    std::sort(words.begin(), words.end());

    for (const std::string& word : words) {
        std::cout << word << std::endl;
    }

    return 0;
}