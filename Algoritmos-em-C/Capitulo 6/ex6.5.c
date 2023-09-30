#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(){

    float n;
    float r;

    printf("Numero: ");
    scanf("%f", &n);

    if (n>0){
        r = sqrt (n);
        printf("Raiz quadrada de %.2f: %.2f", n, r);
    }else{
        r = pow (n,2);
        printf("Quadrado de %.2f: %.2f", n, r);
    }


return 0;
}
