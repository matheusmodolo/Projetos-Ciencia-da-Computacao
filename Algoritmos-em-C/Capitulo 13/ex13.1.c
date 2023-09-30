#include <stdio.h>
#include <stdlib.h>

int main(){

    FILE *arquivoNotas;
    float notas;
    float soma = 0;
    float media;
    int cont = 0;

    arquivoNotas = fopen("notas.txt", "r");

    if(arquivoNotas != NULL){
        while (!feof(arquivoNotas)){
            fscanf(arquivoNotas, "%f", &notas);
            /*fgetc(arquivoNotas);*/

            soma += notas;
            cont++;
        }

        media = soma/cont;

        printf("Media: %.2f", media);
    }
    else{
        printf("\nERRO\n");

    }

    fclose(arquivoNotas);

    return 0;
}
