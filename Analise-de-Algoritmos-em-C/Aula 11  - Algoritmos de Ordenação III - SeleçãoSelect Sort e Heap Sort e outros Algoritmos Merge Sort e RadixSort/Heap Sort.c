#include <stdio.h>
#include <stdlib.h>

void heapSort (int *a, int n);

void heap(int L, int R, int *a);

void imprimir(int *a, int n);

int main(){

    printf("Heap Sort\n");

    srand(time(NULL));
    printf("\nTamanho do Array: ");
    int n;
    scanf("%d", &n);
    int a[n];
    for(int i = 0; i<n; i++){
        a[i] = rand()%100;
    }
    imprimir(a, n);
    heapSort(a, n);

    printf("\nArray Ordenado    [] = ");
    for(int i=0; i < n; i++){
        printf("%d ", a[i]);
    }

	return 0;
}

void heapSort(int *a, int n){
    int L, R, x;
    L = (n/2)+1;
    R = n - 1;
    while (L > 0){
        L--;
        heap(L, R, a);
    }
    while(R > 0){
        x = a[0];
        a[0] = a[R];
        a[R] = x;
        R--;
        heap(L, R, a);
        imprimir (a, n);
    }
}

void heap(int L, int R, int *a){
    int i, j, x;
    i = L;
    j = 2*L;
    x = a[L];

    if((j<R)&&(a[j] < a[j+1])){
        j++;
    }
    while((j <= R) && (x < a[j])){
        a[i] = a[j];
        i = j;
        j = 2*j;

        if((j < R) && (a[j] < a[j+1])){
            j++;
        }
        a[i] = x;
    }
}

void imprimir(int *a, int n){

    printf("\nArray Desordenado [] = ");
    for(int i=0; i < n; i++){
        printf("%d ", a[i]);
    }
}
