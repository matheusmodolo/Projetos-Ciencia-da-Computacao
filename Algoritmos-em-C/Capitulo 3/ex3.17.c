#include <stdio.h>
#include <stdlib.h>

int main () {

    int i;
    int a = 0;
    int b = 1;
    int aux;
    int contador = 0;
    int n;

    printf("Termo desejado: ");
    scanf("%d", &n);

    for(i = 0; i <= n; i++){
        aux = a + b;


        if(contador >= 1){
            a = b;
            b = aux;
        }
            contador++;
    }
         printf("Fibonacci de %d e %d ", n, aux);


    return 0;

}
