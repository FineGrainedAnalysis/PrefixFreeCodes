#ifndef _PIVOT
#define _PIVOT

// for swap() and sort5()
#include "quicksort.h"

// choose one of these for the pivot method

const int pivot_default=0;
const int pivot_random=1;
const int pivot_medof3=2;
const int pivot_medofmed=3;

const int pivot=0;

// chooses the pivot, and swaps it to A[stop]
// hopefully optimizing compiler makes this very efficient
inline void choosepivot(int A[], int start, int stop)
{
  if(pivot==pivot_default) return;

  if(pivot==pivot_random)
  {
    int pos=start + rand()%(stop-start+1);
    swap(A[pos],A[stop]);
    return;
  }

  if(pivot==pivot_medof3)
  {
    int mid=(start+stop)/2;
    if(A[start]<=A[mid])
    {
      if(A[mid]<=A[stop])
        { swap(A[mid],A[stop]); return; }
      if(A[stop]<=A[start])
        { swap(A[start],A[stop]); return; }
      return;
    }
    // so A[mid]<A[start]
    if(A[start]<=A[stop])
      { swap(A[start],A[stop]); return; }
    if(A[stop]<=A[mid])
      { swap(A[mid],A[stop]); return; }
    return;
  }
}

#endif
