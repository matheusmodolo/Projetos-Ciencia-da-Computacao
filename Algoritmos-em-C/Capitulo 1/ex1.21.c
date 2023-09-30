#include <stdio.h>
#include <stdlib.h>

int main(){

    int n;
    int sucessor;
    int antecessor;

    printf("Forneca um numero inteiro: ");
    scanf("%d", &n);

    sucessor = n + 1;
    antecessor = n-1;

    printf("\nSucessor de %d: %d", n, sucessor);
    printf("\nAntecessor de %d: %d", n, antecessor);

return 0;
}
