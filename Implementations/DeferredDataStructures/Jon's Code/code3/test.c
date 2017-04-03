#include <iostream>
#include "perm.h"

using namespace std;

int main()
{
  const long Alen=20;
  long A[Alen];

  for(int i=0; i<Alen; i++) A[i]=i;

  permute(A,Alen);

  for(int i=0; i<Alen; i++)
    cout << A[i] << " ";
  cout << endl;

  return 0;
}
