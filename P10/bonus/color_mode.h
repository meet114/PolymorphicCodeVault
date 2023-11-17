#ifndef COLOR_MODE_H
#define COLOR_MODE_H

#include <iostream>

enum class Color_mode { FOREGROUND, BACKGROUND, RESET };

namespace {
using ColorMode = Color_mode;
}

std::ostream& operator<<(std::ostream& ost, const Color_mode& cm);

#endif