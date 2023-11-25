#include "font.h"

Font::Font(int font) : _font(font) {}

std::ostream& Font::output(std::ostream& ost) const {
    ost << ANSI::CSI << _font << 'm';
    return ost;
}
