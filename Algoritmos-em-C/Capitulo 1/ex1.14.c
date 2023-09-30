#include <stdio.h>
#include <stdlib.h>

int main(){
    float l;
    float P;
    float A;

    printf("Valor do lado: ");
    scanf("%f", &l);

    P = 4 * l;
    A = l * l;

    printf("\nPerimetro = %.2f", P);
    printf("\nArea = %.2f", A);

return 0;
}
