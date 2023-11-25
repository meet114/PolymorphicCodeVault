#ifndef ANSI_H
#define ANSI_H

#include <iostream>

class ANSI {
   public:
    // Traditional comparison operators instead of spaceship
    bool operator==(const ANSI&) const { return true; }
    bool operator!=(const ANSI&) const { return false; }
    bool operator<(const ANSI&) const { return false; }
    bool operator<=(const ANSI&) const { return true; }
    bool operator>(const ANSI&) const { return false; }
    bool operator>=(const ANSI&) const { return true; }

    // Abstract method for outputting ANSI codes
    virtual std::ostream& output(std::ostream& ost) const = 0;

    // Friend function for streaming ANSI codes
    friend std::ostream& operator<<(std::ostream& ost, const ANSI& ansi);

    // Control Sequence Introducer
    static const std::string CSI;
};

#endif