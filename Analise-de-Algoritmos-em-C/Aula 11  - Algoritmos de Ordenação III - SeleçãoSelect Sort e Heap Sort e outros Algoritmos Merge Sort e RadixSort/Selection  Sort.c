#include <stdio.h>
#include <stdlib.h>

int selectionSort (int *a, int n);
void imprimir(int *a, int n);

int main(){

    printf("Selection Sort\n");

    srand(time(NULL));
    printf("\nTamanho do Array: ");
    int n;
    scanf("%d", &n);
    int a[n];
    for(int i = 0; i<n; i++){
        a[i] = rand()%100;
    }
    imprimir(a, n);
    selectionSort(a, n);

    printf("\nArray Ordenado    [] = ");
    for(int i=0; i < n; i++){
        printf("%d ", a[i]);
    }

	return 0;
}

int selectionSort(int *a, int n){
     int i, j, x, aux;
    for (i = 0; i < n-1; i++){
     x = i;
     for (j = (i+1); j < n; j++) {
       if(a[j] < a[x])
         x = j;
     }
     if (a[i] != a[x]) {
       aux = a[i];
       a[i] = a[x];
       a[x] = aux;
     }
     imprimir(a, n);
  }
}

void imprimir(int *a, int n){

    printf("\nArray Desordenado [] = ");
    for(int i=0; i < n; i++){
        printf("%d ", a[i]);
    }
}
