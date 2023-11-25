#include "color.h"

#include <map>
#include <stdexcept>

const std::string Color::RGB = ";2;";

Color::Color() : _mode(Color_mode::RESET), _red(0), _green(0), _blue(0) {}

Color::Color(int red, int green, int blue, Color_mode mode)
    : _mode(mode), _red(red), _green(green), _blue(blue) {
    if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
        throw std::invalid_argument("Color components must be in range [0,255]");
    }
}

Color Color::operator+(const Color& other) const {
    int new_red = 255 - (255 - _red) * (255 - other._red) / 255;
    int new_green = 255 - (255 - _green) * (255 - other._green) / 255;
    int new_blue = 255 - (255 - _blue) * (255 - other._blue) / 255;

    return Color(new_red, new_green, new_blue, _mode);
}

std::ostream& Color::output(std::ostream& ost) const {
    static const std::map<Color_mode, int> code = {
        {Color_mode::FOREGROUND, 38}, {Color_mode::BACKGROUND, 48}, {Color_mode::RESET, 0}};

    ost << ANSI::CSI << code.at(_mode);

    if (_mode != Color_mode::RESET) {
        ost << RGB << _red << ";" << _green << ";" << _blue;
    }

    ost << "m";

    return ost;
}