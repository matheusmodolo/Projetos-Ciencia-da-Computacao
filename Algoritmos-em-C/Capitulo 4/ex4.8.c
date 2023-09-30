#include <stdio.h>
#include <stdlib.h>

int main(){

    int i;
    int n;
    int array[5];
    int arrayPar[5];
    int arrayImpar[5];
    int par = 0;
    int impar = 0;


    for (i=0; i<5; i++){
        printf("array[%d]: ", i);
        scanf("%d", &array[i]);
    }
    for(i=0; i<5; i++){
        if(array[i]%2==0){
            arrayPar[par++] = array[i];
        }else{
            arrayImpar[impar++] = array[i];
        }
    }

    printf("Numeros pares:");

    if(par==0){
        printf(" nao ha");
    }else{
        for (i=0; i<par; i++){
                printf(" %d", arrayPar[i]);
        }
    }

    printf(".");

    printf("\nNumeros impares:");

    if(impar==0){
        printf(" nao ha");
    }else if(arrayImpar[i] >= 1){

        for (i=0; i<impar; i++){
                printf(" %d", arrayImpar[i]);

        }
    }

    printf(".");


return 0;
}
