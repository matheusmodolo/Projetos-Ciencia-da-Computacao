#include <stdio.h>
#include <stdlib.h>

int main (){

    float n;
    float metade;
    float triplo;

    printf("Entre com um valor: ");
    scanf("%f", &n);

    metade = n/2;
    triplo = n*3;

    if (n>20){

            printf("A metade de %.2f e %.2f", n, metade);
    }else{
            printf("O triplo de %.2f e %.2f", n, triplo);
    }



return 0;
}
