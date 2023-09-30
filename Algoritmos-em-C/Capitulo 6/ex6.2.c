#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(){
    float b;
    float e;
    float r;

    printf("Base: ");
    scanf("%f", &b);

    printf("Expoente: ");
    scanf("%f", &e);

    r = pow(b, e);

    printf("%.2f ^ %.2f = %.2f", b, e, r);


return 0;
}
