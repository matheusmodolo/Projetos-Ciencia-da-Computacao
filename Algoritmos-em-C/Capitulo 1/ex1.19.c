#include <stdio.h>
#include <stdlib.h>

int main(){

    float r;
    float D;
    float C;
    float A;
    float pi;

    printf("Valor do raio do circulo: ");
    scanf("%f", &r);

    pi = 3.141592;
    D = 2*r;
    C = 2*pi*r;
    A = pi*r*r;

    printf("\nDiametro = %.2f", D);
    printf("\nCircunferencia = %.2f", C);
    printf("\nArea = %.2f", A);



return 0;
}
