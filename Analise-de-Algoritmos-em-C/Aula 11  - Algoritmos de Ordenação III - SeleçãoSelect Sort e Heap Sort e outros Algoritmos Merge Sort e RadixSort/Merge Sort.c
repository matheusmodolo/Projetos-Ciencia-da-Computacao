#include <stdio.h>
#include <stdlib.h>

int mergeSort (int p, int q, int *a);

void intercala (int p, int q, int r, int *a);

void imprimir(int *a, int n);

int main(){

    printf("Merge Sort\n");

    srand(time(NULL));
    printf("\nTamanho do Array: ");
    int n;
    scanf("%d", &n);
    int a[n];
    for(int i = 0; i<n; i++){
        a[i] = rand()%100;
    }
    imprimir(a, n);
    mergeSort(0, n, a);

    printf("\nArray Ordenado    [] = ");
    for(int i=0; i < n; i++){
        printf("%d ", a[i]);
    }

	return 0;
}

int mergeSort (int p, int r, int *a){
    if (p < r-1) {
      int q = (p + r)/2;
      mergeSort (p, q, a);
      mergeSort (q, r, a);
      intercala (p, q, r, a);
      imprimir(a, r);
   }
}

void intercala (int p, int q, int r, int *a){
    int *w;
    w = malloc ((r-p) * sizeof (int));
    int i = p, j = q;
    int k = 0;

    while (i < q && j < r) {
       if (a[i] <= a[j])  w[k++] = a[i++];
       else  w[k++] = a[j++];
    }
    while (i < q)  w[k++] = a[i++];
    while (j < r)  w[k++] = a[j++];
    for (i = p; i < r; ++i)  a[i] = w[i-p];
    free (w);

}

void imprimir(int *a, int n){

    printf("\nArray Desordenado [] = ");
    for(int i=0; i < n; i++){
        printf("%d ", a[i]);
    }
}
