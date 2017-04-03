
using namespace std;

#include<math.h>

#include "online.h"

#include "Timer.h"

int main()
{

#include "config.h"


  Timer t;

cout << "Timing about to begin...\n";

  t.reset();
  t.start();

  quicksort(A,Alen);

  int ans;
  for(int i=0; i<queries; i++)
    ans=A[(rand()%Alen)];
  t.stop();
  cout << t.elapsed() << endl;

  delete [] A;
  return 0;

}
