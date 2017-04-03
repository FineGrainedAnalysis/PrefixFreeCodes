#ifndef _QUICKSORT
#define _QUICKSORT


inline void swap(int &x, int &y)
{
  int t; t=x; x=y; y=t;
}

inline void sort2(int x[])
{
  if(x[0]>x[1]) swap(x[0],x[1]);
}

inline void sort3(int x[]) // 3 comparisons, 2.5 on average
{
  sort2(x);
  if(x[1]>x[2]) { swap(x[1],x[2]); sort2(x); }
}

inline void sort4(int x[]) // 5 comparisons
{
  sort2(x); sort2(x+2);
  if(x[0]>x[2]) swap(x[0],x[2]);
  if(x[1]>x[3]) swap(x[1],x[3]);
  sort2(x+1);
}

// this one gets 7.5 comps on average (7 is optimal)
// hopefully with fewer data movements to make it faster
inline void sort5(int x[])
{
  sort4(x);
  int tmp=x[4];
  for(int i=3; i>=0; i--)
    if(x[i]>tmp) {x[i+1]=x[i];}
    else {x[i+1]=tmp; return; }
  x[0]=tmp;
}

#include "pivot.h"

int partition(int x[], int start, int stop)
{
  choosepivot(x,start,stop);
  int pivot = x[stop];

  int left=start, right=stop-1;

  while(left<right)
  {
    while(x[left]<pivot) left++;
    while(right>start && x[right]>=pivot) right--;
    if(left<right) swap(x[left],x[right]);
  }
  swap(x[left],x[stop]);
  return left;
}

void quicksort(int x[], int start, int stop)
{
  if(stop-start<=4)
  {
    if(start>=stop) return;
    switch(stop-start)
    {
      case 1: sort2(x+start); return;
      case 2: sort3(x+start); return;
      case 3: sort4(x+start); return;
      case 4: sort5(x+start); return;
    }
  }
  int pivotpos = partition(x,start,stop);
  quicksort(x,start,pivotpos-1);
  quicksort(x,pivotpos+1,stop);
}

void quicksort(int x[], int len)
  { quicksort(x,0,len-1); }

#endif
