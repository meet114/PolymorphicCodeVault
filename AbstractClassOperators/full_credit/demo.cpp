#include "ansi.h"
#include "color.h"
#include "font.h"

#include <iostream>
#include <iomanip>
#include <vector>

int by4counter = 0;
std::string by4() {
    return (++by4counter % 4) ? "    " : "\n";
}

int main() {
    Color reset; // Clears all colors and fonts

    // Test color
    Color UTA_blue{0, 100, 177};
    Color UTA_orange{245, 128, 38};
    Color UTA_alt_orange{196, 85, 23};
    Color UTA_white{255, 255, 255};
    std::cout << UTA_blue << "This is UTA blue    "
              << UTA_orange << "This is UTA orange    "
              << UTA_alt_orange << "This is UTA alt orange    "
              << UTA_white << "This is UTA white\n"
              << reset << std::endl;
    
    // Test color addition
    Color red{255,0,0};
    Color green{0,255,0};
    Color blue{0,0,255};
    // Color mixed = red + green + blue;
    // std::cout << mixed << "This is red + green + blue" << reset << std::endl;
    std::cout << "operator+: "
              << red + green  << "red + green = yellow    " 
              << red + blue   << "red + blue = magenta    " 
              << green + blue << "green + blue = cyan\n" 
              << reset << std::endl;
    
    // Test font modes
    //  0 Steady      1 Bold   2 Dim       3 Italic    4 Underline
    //  5 Slow Blink  6 Blink  7 Reverse   8 Conceal   9 Strikeout
    // 10-19 Alternate fonts (not usually implemented)
    // 21 Double Underline
    // Fore: 30 Black 31 Red  32 Green 33 Yellow 34 Blue 35 Magenta 36 Cyan 37 White
    // Back: 40 Black 41 Red  42 Green 43 Yellow 44 Blue 45 Magenta 46 Cyan 47 White    
    // 51 Framed   52 Encircled  53  Overlined
    // 73 Superscript         74 Subscript
    Font steady;
    int index = 0;
/*    std::string text[] = {"bold      ", "dim       ", "italic    ", "underline ",
                          "slow blink", "blink     ", "reverse   ", "conceal   ",
                          "strikeout ", "font #1   ", "font #2   ", "font #3   ",
                          "font #4   ", "font #5   ", "font #6   ", "font #7   ",
                          "font #8   ", "font #9   ", "font #10  ", "base font ",
                          "dbl uline ", 
                                        "black     ", "red       ", "green     ",
                          "yellow    ", "blue      ", "magenta   ", "cyan      ",
                          "white     ", 
                                        "black     ", "red       ", "green     ",
                          "yellow    ", "blue      ", "magenta   ", "cyan      ",
                          "white     ", 
                                        "framed    ", "encircled ", "overlined ",
                          "super     ", "sub       "};
*/
    std::string text[] = {"bold      ", "dim       ", "italic    ", "underline ",
                          "slow blink", "blink     ", "reverse   ", "conceal   ",
                          "strikeout ", "font #1   ", "font #2   ", "font #3   ",
                          "font #4   ", "font #5   ", "font #6   ", "font #7   ",
                          "font #8   ", "font #9   ", "font #10  ", "dbl uline ", 
                          "black     ", "red       ", "green     ", "yellow    ", 
                          "blue      ", "magenta   ", "cyan      ", "white     ", 
                          "black     ", "red       ", "green     ", "yellow    ", 
                          "blue      ", "magenta   ", "cyan      ", "white     ", 
                          "framed    ", "encircled ", "overlined ",
                          "super     ", "sub       "};
    by4counter = 0;
    for(int f=1; f<=21; ++f) {
        if(f == 20) continue;
        Font font{f};
        std::cout << font << "Style  " << text[index++] << steady << by4();
    }
    std::cout << std::endl;
    by4counter = 0;
    for(int f=30; f<=37; ++f) {
        Font font{f};
        std::cout << font << "Color  " << text[index++] << steady << by4();
    }
    for(int f=40; f<=47; ++f) {
        Font font{f};
        std::cout << font << "Bkgnd  " << text[index++] << steady << by4();
    }
    std::cout << std::endl;
    by4counter = 0;
    for(int f=51; f<=53; ++f) {
        Font font{f};
        std::cout << font << "Font   " << text[index++] << steady << by4();
    }
    std::cout << std::endl;
    by4counter = 0;
    for(int f=73; f<=74; ++f) {
        Font font{f};
        std::cout << font << "Script " << text[index++] << steady << by4();
    }
    std::cout << '\n' << std::endl;
    
    // Test polymorphism
    std::vector<ANSI*> ansi;
    for(int r=0; r<255; r+=128) {
        for(int g=0; g<255; g+=128) {
            for(int b=0; b<255; b+=128) {
                ansi.push_back(new Color{r, g, b, ColorMode::FOREGROUND});
                ansi.push_back(new Color{r, g, b, ColorMode::BACKGROUND});
            }
        }
    }
    
    for(int f=1; f<10; ++f) ansi.push_back(new Font{f});
    

    for(ANSI* a : ansi) {
        std::cout << *a << "Polymorphic demo" << reset << by4();
    }
    std::cout << '\n' << std::endl;
    

}

