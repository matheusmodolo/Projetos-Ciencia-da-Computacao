#include <stdio.h>
#include <stdlib.h>

int imprimir(int *a,  int t);
int OrdBinaria(int *a, int t);

int main() {
    srand (time(NULL));

    int t;

    printf("\nOrdenacao Binaria\n\n");
    printf("Tamanho do Array: ");
    scanf("%d",&t);

    int a[t];

    printf("\nArray gerado aleatoriamente:\n");
    for(int i = 0; i < t; i++) {
        a[i] = rand() %100;
        printf("a[%d]: %d\n", i, a[i]);
    }

    imprimir(a,t);
    OrdBinaria(a,t);

    printf("\nArray Ordenado    [] = ");
    for(int i=0; i < t; i++) {
        printf("%d ",a[i]);
    }

    return 0;
}

int OrdBinaria(int *a, int t) {

    int i,j,m,l,r,x;

    for(i = 1; i<t; i++) {

        x = a[i];
        l = 0;
        r = i;

        while(l<r) {
            m = (l+r)/2;
            if(x >= a[m]) {
                l = m+1;
            } else {
                r = m;
            }
        }
        for(j=i; j>l; j--) {
            a[j] = a[j-1];
        }
        a[r] = x;
        imprimir(a,t);
    }
}

int imprimir(int *a, int t) {

    printf("\nArray Desordenado [] = ");
    for(int i=0; i < t; i++) {
        printf("%d ",a[i]);
    }
}
