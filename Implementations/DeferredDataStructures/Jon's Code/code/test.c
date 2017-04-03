
using namespace std;

#include "online.h"

int main()
{

  int A[5];

  // test sort2
  //
  for(int i=0; i<10; i++)
  {
    A[0]=rand()%100;
    A[1]=rand()%100;
    sort2(A);
    cout << A[0] << " " << A[1] << endl;
  }
  for(int i=0; i<10; i++)
  {
    A[0]=rand()%100;
    A[1]=rand()%100;
    A[2]=rand()%100;
    sort3(A);
    cout << A[0] << " " << A[1] << " " << A[2] << endl;
  }
  for(int i=0; i<30; i++)
  {
    A[0]=rand()%100;
    A[1]=rand()%100;
    A[2]=rand()%100;
    A[3]=rand()%100;
    sort4(A);
    cout << A[0] << " " << A[1] << " " << A[2] << " " << A[3] << endl;
  }
  for(int i=0; i<30; i++)
  {
    A[0]=rand()%100;
    A[1]=rand()%100;
    A[2]=rand()%100;
    A[3]=rand()%100;
    A[4]=rand()%100;
    sort5(A);
    cout << A[0] << " " << A[1] << " " << A[2] << " " << A[3] <<" "<<A[4] << endl;
  }

  const int Blen=100;
  int B[Blen];
  for(int i=0; i<Blen; i++) B[i]=rand()%(10*Blen);
  quicksort(B,Blen);
  for(int i=0; i<Blen; i++) 
    { cout << B[i] << " "; if(i%10==9) cout << endl; }
  cout << endl;
/*
*/

  return 0;
}
