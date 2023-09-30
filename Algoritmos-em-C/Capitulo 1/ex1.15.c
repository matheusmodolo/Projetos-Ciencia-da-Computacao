#include <stdio.h>
#include <stdlib.h>

int main(){

    float h;
    float l;
    float P;
    float A;

    printf("Valor da largura: ");
    scanf("%f", &l);

    printf("Valor da altura: ");
    scanf("%f", &h);

    P = 2*l + 2*h;
    A = l*h;

    printf("\nPerimetro = %.2f", P);
    printf("\nArea = %.2f", A);


return 0;
}
