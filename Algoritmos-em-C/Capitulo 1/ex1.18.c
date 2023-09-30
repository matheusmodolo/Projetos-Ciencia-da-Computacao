#include <stdio.h>
#include <stdlib.h>

int main(){

    float A;
    float D;
    float d;

    printf("Valor da diagonal maior: ");
    scanf("%f", &D);

    printf("Valor da diagonal menor: ");
    scanf("%f", &d);

    A = D*d/2;

    printf("\nArea = %.2f", A);


return 0;
}
