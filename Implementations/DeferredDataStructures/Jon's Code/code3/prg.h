#ifndef _PRG
#define _PRG

#include <stdlib.h>
#include <math.h>

// use srandom() to set the seed

inline long double uniform()
{
  long double u=random();
  u=u/RAND_MAX;
  return u;
}

inline long int uniform(long int max)
{
  return random()%max;
}

long double normal() // using Knuth's algorithm, 3.4.1.C
 // or the polar method, Box, Muller, Marsaglia, 1958
{
  long double v1, v2, s;
  do{
    v1=2*uniform()-1;
    v2=2*uniform()-1;
    s=v1*v1+v2*v2;
  } while(s>=1);
  return v1*sqrt( -2*log(s)/s );
}

long int normal(long double mu, long double sigma, long max)
{
  long double u;
  do {
    u=normal();
    u=u*sigma+mu;
  } while(u<0 || u>=max);
  return (long) u;
}

#endif
