#include <stdio.h>
#include <stdlib.h>

int main (){

    int i;
    int n1;
    int n2;
    int contador = 0;

    printf("N1: ");
    scanf("%d", &n1);

    printf("N2: ");
    scanf("%d", &n2);


    if(n1 <= n2){
        for(i = n1; i <= n2; i++){
            if(i % 2 ==0){
                contador ++;
            }
        }
            printf("Numeros pares entre %d e %d: %d", n1, n2, contador);

    }else{
         for(i = n2; i <= n1; i++){
            if(i % 2 ==0){
                contador ++;
            }
        }
        printf("Numeros pares entre %d e %d: %d", n2, n1, contador);

    }


return 0;
}
