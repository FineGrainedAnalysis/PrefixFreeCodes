
using namespace std;

#include<math.h>
#include "online.h"

#include "Timer.h"

int main()
{

#include "config.h"

  Timer t;
  online x(A,Alen);

cout << "Timing about to begin...\n";

  t.reset();
  t.start();
  for(int i=0; i<queries; i++)
    x.select(rand()%Alen);
  t.stop();
  cout << t.elapsed() << endl;

  cout << "fraction of 1s = " << double(x.num1s())/Alen << endl;

  return 0;

  for(int i=0; i<queries; i++)
  {

     if(i%2==0) // do selection query
     {
       int rank=rand()%Alen;
       cout << i+1 << ": ["<< rank << "] "<< x.select(rank) << endl;
     }
     else // do rank/search query
     {
       int value=rand()%1000;
       cout << i+1 << ": "<< value << " ["<< x.rank(value) <<"]\n";;
     }

     for(int j=0; j<Alen; j++) 
       cout << A[j] << (j%20==19?'\n':' ');

     x.print(cout);
  }
/*
 */
/*
  // loop to sort
  for(int j=2; j<Alen; j+=2) x.select(j);
  x.print(cout);
*/

  delete [] A;
  return 0;

}
