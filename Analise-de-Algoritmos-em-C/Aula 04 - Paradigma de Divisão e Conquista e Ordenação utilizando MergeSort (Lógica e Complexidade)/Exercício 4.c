#include <stdio.h>
#include <stdlib.h>

void MergeSortInterativo(int A[], int n);
void IntercalaSemSentinela(int A[], int p, int q, int r);

int main() {

    srand(time(NULL));

    int t;

    printf("Entre com um tamanho do Array de inteiros: ");
    scanf("%d", &t);

    int i;
    int r;
    int a[t];

    printf("\nOrdenacao\n Array Desord.[] = ");

    for (i=0; i<t; i++) {
        r = rand()%100;
        a[i] = r;
        printf(" %d", a[i]);
    }
    MergeSortInterativo(a, t);



    return 0;
}

void MergeSortInterativo(int A[], int n) {
    int b = 1;
    while(b<n) {
        int p = 0;
        while(p+b<n) {
            int r = p+2*b;
            if(r>n) {
                r=n;
            }
            IntercalaSemSentinela(A, p, p+b, r);
            p = p + 2*b;
            printf("\n Array Ord.   [] = ");
            for(int i=0; i<n; i++) {
                printf(" %d", A[i]);
            }
        }
        b = 2*b;
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
