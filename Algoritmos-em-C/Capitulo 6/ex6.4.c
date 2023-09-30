#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(){

    float n;
    float r;

    printf("Numero: ");
    scanf("%f", &n);

    r = fabs(n);

    printf("Valor absoluto: %.2f", r);


return 0;
}
