#ifndef _PERM
#define _PERM

#include "prg.h"

// generates a random permutation using the Knuth shuffle

void permute(long A[], long Alen)
{
  for(long i=Alen-1; i>0; i--)
  {
    long j=uniform(i+1);
    long tmp=A[i]; A[i]=A[j]; A[j]=tmp;
  }
}

#endif
