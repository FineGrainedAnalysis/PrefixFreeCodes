//  Class Timer
//
//  This class implements a stopwatch for timing algorithms.
//  It uses the clock() system call from <time.h>.
//
//  Constructor:
//    Timer T;            -- initializes the timer, resets it, and starts it
//  Standard functions:
//    T.reset();          -- resets and starts the timer
//    T.start();          -- starts the timer
//    T.stop();           -- stops the timer
//    double T.elapsed(); -- returns the elapsed time in seconds
//  Output operator:
//    cout << T;          -- prints the elapsed time

#ifndef _TIMER
#define _TIMER

#include<time.h>
#include<iostream>

class Timer
{
    double starttime, stoptime;
    double now() const
      { return double(clock())/double(CLOCKS_PER_SEC); }
  public:
    void reset() { stoptime=0; start(); }
    Timer() { reset(); }
    void start() { starttime=now(); }
    void stop() { stoptime=now(); }
    double elapsed() const
    {
      if(stoptime>0) return stoptime-starttime;
      else return now()-starttime;
    }
};

ostream & operator<<(ostream & os, const Timer & T)
{ 
  os << T.elapsed() << " secs ";
  return os;
}

#endif
