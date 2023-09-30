#include <stdio.h>
#include <stdlib.h>
#define max(A, B) ((A>B) ? (A):(B))
int kadane (int *a, int n);

int main() {

    printf(" Resolucao do problema do Subarranjo Maximo - Kadane:");
    printf("\n Forneca o tamanho do array (n): ");
    int n;
    scanf("%d", &n);
    int a[n];

    for(int i = 0; i<n; i++){
        printf(" Entre com o %d elemento do array: ", i+1);
        scanf("%d", &a[i]);
    }

    printf("\n Imprimindo o Array analisado:");
    for(int i = 0; i<n; i++){
        printf(" %d ", a[i]);
    }

    printf("\n O valor do Subarranjo Maximo eh: %d\n\n", kadane(a, n));

    return 0;
}
int kadane (int *a, int n) {
    int soma = 0;
    int resp = 0;

    for (int i = 0; i< n; i++) {
        soma += a[i];
        resp = max(resp, soma);

        if(soma<0) {
            soma = 0;
        }
    }

    return resp;
}
