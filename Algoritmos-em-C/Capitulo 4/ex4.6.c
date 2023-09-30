#include <stdio.h>
#include <stdlib.h>

int main(){

    int array[5];
    int coleta[5];
    int i;
    int buscarpor;
    int indC = 0;
    int n;

    for (i=0; i<5; i++){
        printf("array[%d]: ", i);
        scanf("%d", &array[i]);
       }

    printf("Buscar por: ");
    scanf("%d", &buscarpor);

    for (i=0; i<5; i++){
                if(array[i]==buscarpor){
                    coleta[indC++]=i;
                }
    }

    if(indC==0){
        printf("O array nao contem o valor %d.", buscarpor);
    }else{
        printf("O valor %d foi encontrado ", buscarpor);
        if(indC==1){
            printf("no indice %d", coleta[0]);
        }else{
            printf("nos indices ");
            for (i=0; i<indC; i++){
                if(i==0){
                    printf("%d", coleta[i]);
                }else if(i==indC-1){
                    printf(" e %d", coleta[i]);
                }else{
                    printf(", %d", coleta[i]);
                }
            }
        }
            printf(" do array.");
    }

return 0;
}
