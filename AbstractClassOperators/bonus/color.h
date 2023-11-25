#ifndef COLOR_H
#define COLOR_H

#include "ansi.h"
#include "color_mode.h"

class Color : public ANSI {
   public:
    Color();
    Color(int red, int green, int blue, Color_mode mode = Color_mode::FOREGROUND);

    Color operator+(const Color& other) const;

    std::ostream& output(std::ostream& ost) const override;

        bool operator==(const Color& other) const;
    bool operator!=(const Color& other) const;
    bool operator<(const Color& other) const;
    bool operator<=(const Color& other) const;
    bool operator>(const Color& other) const;
    bool operator>=(const Color& other) const;

   protected:
    static const std::string RGB;

   private:
    Color_mode _mode;
    int _red;
    int _green;
    int _blue;
};

#endif