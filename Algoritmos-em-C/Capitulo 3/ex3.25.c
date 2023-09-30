#include <stdio.h>
#include <stdlib.h>

int main () {

    float n=0;
    int contador=0;
    float somatorio=0;
    float media=0;


    while(n>=0){
        printf("Entre com um valor: ");
        scanf("%f", &n);

        if(n>=0){
            somatorio+=n;
            contador++;
        }
    }

    if(contador>0){
         media=somatorio/contador;
    }else {
        somatorio=0;
        media=0;
        contador=0;
    }



    printf("Somatorio: %.2f\n", somatorio);
    printf("Media: %.2f\n", media);
    printf("Quantidade: %d", contador);














    return 0;

}
