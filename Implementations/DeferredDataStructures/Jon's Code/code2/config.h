
  const int queries=200000;
  const int Alen=(int)pow(queries,1.5);

  int *A=new int[Alen];

  srand(0);
  for(int i=0; i<Alen; i++) A[i]=rand()%Alen;

  cout << "Alen=" << Alen << "  #queries=" <<queries<<endl;
