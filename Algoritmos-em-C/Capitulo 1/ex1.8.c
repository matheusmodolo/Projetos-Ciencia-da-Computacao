#include <stdio.h>
#include <stdlib.h>

int main() {

    int P;
    int A;
    int l;
    int h;

    printf("Valor da largura: ");
    scanf("%d", &l);

    printf("Valor da altura: ");
    scanf("%d", &h);

    P = 2 * l + 2 * h;
    A = l * h;

    printf("\nPerimetro = %d",P);
    printf("\nArea = %d", A);

return 0;
}
