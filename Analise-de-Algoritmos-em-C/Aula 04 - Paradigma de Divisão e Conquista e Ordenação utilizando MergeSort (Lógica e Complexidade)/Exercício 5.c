#include <stdio.h>
#include <stdlib.h>

void MergeSortRecursivo(int A[], int p, int r);
void IntercalaSemSentinela(int A[], int p, int q, int r);
int BuscaBinariaRecursiva(int A[], int p, int r, int b);


int main() {

    srand(time(NULL));

    int t;

    printf("Entre com o tamanho do Array de Inteiros: ");
    scanf("%d", &t);

    int a[t];
    int i;
    for(i=0; i<t; i++) {
        a[i] = rand()%100;
    }
    MergeSortRecursivo(a, 0, t);

    printf("\nArray Gerado Ordenado: ");
    for(i=0; i<t; i++) {
        printf(" %d", a[i]);
    }
    printf("\nEntre com o valor inteiro a ser procurado:");
    int x;
    scanf("%d", &x);

    printf("\nO valor %d for encontrado no indice %d do Array!\n", x, BuscaBinariaRecursiva(a, 0, t, x));


    return 0;
}

void MergeSortRecursivo(int A[], int p, int r) {
    int q;
    if((r-p)>1) {
        q = (p+r)/2;
        MergeSortRecursivo(A, p, q);
        MergeSortRecursivo(A, q, r);
        IntercalaSemSentinela(A, p, q, r);
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
            aux[k++] = A[i++];
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

int BuscaBinariaRecursiva(int A[], int p, int r, int b) {
    if(p==r-1){ //1
        return r;
    }else{
        int q = (p+r)/2;
        if(A[q] < b){
            return BuscaBinariaRecursiva(A, q, r, b);
        }else{
            return BuscaBinariaRecursiva(A, p, q, b);
        }
    }
}
