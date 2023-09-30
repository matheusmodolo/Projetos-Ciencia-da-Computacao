#include <stdio.h>
#include <stdlib.h>

int c = 0;

int maxArray( int *a, int n);

int main(){

    int n;
    printf("Entre com o tamanho do Array de inteiros: ");
    scanf("%d", &n);
    int a[n];
    // *pa = a;
    int i;
    for(i=0; i<n; i++){
        printf("Digite o valor para a posicao %d do array: ", i+1);
        scanf("%d", &a[i]);
    }

    int maior;
    maior = maxArray(a, n);
    printf("O maior elemento do array eh: %d (Num. operacoes = %d)", maior, c);

    return 0;
}
int maxArray( int *a, int n){
    int i, ma;
    ma = a[0];
        for(i=1; i<n; i++){
            if(a[i] > ma){
                ma = a[i];
            }
            c++;
        }
    return ma;
}
