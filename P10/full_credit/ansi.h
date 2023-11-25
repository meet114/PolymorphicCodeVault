#ifndef ANSI_H
#define ANSI_H

#include <iostream>

class ANSI {
   public:
    bool operator==(const ANSI&) const { return true; }
    bool operator!=(const ANSI&) const { return false; }
    bool operator<(const ANSI&) const { return false; }
    bool operator<=(const ANSI&) const { return true; }
    bool operator>(const ANSI&) const { return false; }
    bool operator>=(const ANSI&) const { return true; }

    virtual std::ostream& output(std::ostream& ost) const = 0;

    friend std::ostream& operator<<(std::ostream& ost, const ANSI& ansi);

    static const std::string CSI;
};

#endif