#ifndef FONT_H
#define FONT_H

#include "ansi.h"

class Font : public ANSI {
   public:
    Font(int font = 0);

    std::ostream& output(std::ostream& ost) const override;

    bool operator==(const Font& rhs) const { return _font == rhs._font; }
    bool operator!=(const Font& rhs) const { return _font != rhs._font; }
    bool operator<(const Font& rhs) const { return _font < rhs._font; }
    bool operator<=(const Font& rhs) const { return _font <= rhs._font; }
    bool operator>(const Font& rhs) const { return _font > rhs._font; }
    bool operator>=(const Font& rhs) const { return _font >= rhs._font; }

   private:
    int _font;
};

#endif