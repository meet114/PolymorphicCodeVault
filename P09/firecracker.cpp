#include "firecracker.h"

Firecracker::Firecracker(int length) : _length(length) {
    if (length < 3) {
        throw std::invalid_argument("Firecracker length must be at least 3");
    }
}

Firecracker::~Firecracker() {}

bool Firecracker::tic() {
    if (_length > 0) {
        _length--;
    }
    return _length > 0;
}

std::string Firecracker::firecracker() {
        std::string fuse = "";
    for (int i = 0; i < _length; i++) {
        fuse += "-";
    }
    return "| BOOM |" + fuse + "*";
}