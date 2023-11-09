#ifndef FIRECRACKER_H
#define FIRECRACKER_H

#include <stdexcept>
#include <string>

class Firecracker {
   private:
    int _length;

   public:
    Firecracker(int length);
    virtual ~Firecracker();
    bool tic();
    std::string firecracker();
};

#endif
