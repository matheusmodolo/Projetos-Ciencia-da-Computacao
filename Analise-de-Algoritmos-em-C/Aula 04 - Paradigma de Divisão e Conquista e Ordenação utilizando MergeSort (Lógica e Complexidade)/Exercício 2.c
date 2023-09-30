#include <stdio.h>
#include <stdlib.h>

void MergeSortRecursivo(int A[], int p, int r);
void IntercalaComSentinela(int A[], int p, int q, int r);

int main() {

    srand(time(NULL));

    int n;

    printf("Entre com um tamanho do Array de inteiros: ");
    scanf("%d", &n);

    int i;
    int r;
    int a[n];

    printf("\nOrdenacao\n\n Array Desord.[] = ");

    for (i=0; i < n; i++) {
        r = rand()%100;
        a[i] = r;
        printf(" %d", a[i]);
    }
    MergeSortRecursivo(a, 0, n);
    return 0;
}

void MergeSortRecursivo(int A[], int p, int r) {
    int q;
    if(r-p>1) {
        q = (p+r)/2;
        MergeSortRecursivo(A, p, q);
        MergeSortRecursivo(A, q, r);
        IntercalaComSentinela(A, p, q, r);
        printf("\n Array Ord.   [] = ");
        for(int l = 0; l<r; l++) {
            printf(" %d", A[l]);
        }
    }
}
void IntercalaComSentinela(int A[], int p, int q, int r) {
    int i, j, k, *aux;
    aux = malloc((r-p) * sizeof(int));

    for(i=p; i<q; i++) {
        aux[i-p]=A[i];
    }
    for(j=q; j<r; j++) {
        aux[r-p+q-j-1] = A[j];
    }
    i = 0;
    j = r - p - 1;

    for(k = p; k<r; k++ ) {
        if(aux[i]<=aux[j]) {
            A[k] = aux[i++];
        } else {
            A[k] = aux[j--];
        }
    }
    free(aux);
}
