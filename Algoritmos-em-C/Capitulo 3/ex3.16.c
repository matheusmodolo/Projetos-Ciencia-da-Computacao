#include <stdio.h>
#include <stdlib.h>

int main () {

    int i;
    int a = 0;
    int b = 1;
    int aux;
    int contador = 0;


    for(i = 1; i <= 20; i++){
        aux = a + b;

        if(contador >= 1){
            a = b;
            b = aux;
        }

        printf("%d ", aux);
        contador++;
    }

    return 0;
}
