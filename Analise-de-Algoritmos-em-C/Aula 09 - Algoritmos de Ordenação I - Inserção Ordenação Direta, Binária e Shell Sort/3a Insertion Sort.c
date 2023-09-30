#include <stdio.h>
#include <stdlib.h>

int insertionSort(int *a, int t);
int imprimir(int *a, int t);

int main () {
    srand(time(NULL));

    int t;

    printf("\nInsertion Sort\n\n");
    printf("Tamanho do Array: ");
    scanf("%d",&t);

    int a[t];

    printf("\nArray gerado aleatoriamente:\n");

    for(int i = 0; i < t; i++) {
        a[i] = rand()%100;
        printf("a[%d]: %d\n", i, a[i]);
    }
    imprimir(a,t);
    insertionSort(a,t);

    printf("\nArray Ordenado    [] = ");
    for(int i=0; i < t; i++) {
        printf("%d ",a[i]);
    }

    return 0;
}

int insertionSort(int *a, int t) {

    int i, j, aux;

    for(i=1; i<t; i++) {
        for(j=i; j>0; j--) {

            if(a[j] < a[j-1]) {
                aux = a[j-1];
                a[j-1] = a[j];
                a[j] = aux;
            }
        }
        imprimir(a,t);
        printf("- %d",a[i]);
    }
}

int imprimir(int *a, int t) {

    printf("\nArray Desordenado [] = ");
    for(int i=0; i < t; i++) {
        printf("%d ",a[i]);
    }
}
