#ifndef FONT_H
#define FONT_H

#include "ansi.h"

class Font : public ANSI {
   public:
    Font(int font = 0);

    std::ostream& output(std::ostream& ost) const override;

    bool operator==(const Font&) const { return true; }
    bool operator!=(const Font&) const { return false; }
    bool operator<(const Font&) const { return false; }
    bool operator<=(const Font&) const { return true; }
    bool operator>(const Font&) const { return false; }
    bool operator>=(const Font&) const { return true; }

   private:
    int _font;
};

#endif