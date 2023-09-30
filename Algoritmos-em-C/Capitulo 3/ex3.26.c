#include <stdio.h>
#include <stdlib.h>

int main(){

    int nMaior, nMenor, n;
    int contador=0;

    printf("Entre com um valor: ");
    scanf("%d", &n);

    if(n<0){
        nMaior=0;
        nMenor=0;
    }else{
        nMaior=n;
        nMenor=n;
        contador++;
    }

    while(n>=0){
        printf("Entre com um valor: ");
        scanf("%d", &n);

        if(contador==1 && n<0){
            nMenor=0;
        }

        if(n>nMaior){
            nMaior=n;

        }
        if(n>=0){
            if(n<nMenor){
                nMenor=n;
            }
        }
    }

    printf("Menor numero: %d\n", nMenor);
    printf("Maior numero: %d", nMaior);


    return 0;
}
