#include <stdio.h>
#include <stdlib.h>

void MergeSortRecursivo(int A[], int p, int r);
void IntercalaSemSentinela(int A[], int p, int q, int r);

int main() {

    srand(time(NULL));

    int t;

    printf("Entre com um tamanho do Array de inteiros: ");
    scanf("%d", &t);

    int i;
    int r;
    int a[t];

    printf("\nOrdenacao\n\n Array Desord.[] = ");

    for (i=0; i<t; i++) {
        r = rand()%100;
        a[i] = r;
        printf(" %d", a[i]);
    }
    MergeSortRecursivo(a, 0, t);
    printf("\n");


    return 0;
}
void MergeSortRecursivo(int A[], int p, int r) {
    int q;
    if((r-p)>1) {
        q = (p+r)/2;
        MergeSortRecursivo(A, p, q);
        MergeSortRecursivo(A, q, r);
        IntercalaSemSentinela(A, p, q, r);
        printf("\n Array Ord.   [] = ");
        for(int i = 0; i<r; i++) {
            printf(" %d", A[i]);
        }
    }
}
void IntercalaSemSentinela(int A[], int p, int q, int r) {

    int *aux;
    aux = malloc((r-p)*sizeof(int));
    int i = p;
    int j = q;
    int k = 0;
    int tam = r - p;

    while(i<q && j<r) {
        if(A[i]<=A[j]) {
            aux[k++] =A[i++];
        } else {
            aux[k++] = A[j++];
        }
    }
    while(i<q) {
        aux[k++] = A[i++];
    }
    while(j<r) {
        aux[k++] = A[j++];
    }
    for (k = 0; k<tam; k++) {
        A[p+k]=aux[k];
    }
}
