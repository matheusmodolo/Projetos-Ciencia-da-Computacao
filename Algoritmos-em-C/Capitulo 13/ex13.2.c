#include <stdio.h>
#include <stdlib.h>

int main(){

    FILE *arquivoBarra;
    int n;

    arquivoBarra = fopen("barras.txt", "r");

    if(arquivoBarra != NULL){
        while (!feof(arquivoBarra)){
            fscanf(arquivoBarra, "%d", &n);
            for(int i = 0; i<n; i++){
                printf("*");
            }
            printf(" (%d)\n", n);
        }
    }

    else{
        printf("\nERRO\n");

    }



    return 0;
}
