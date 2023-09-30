#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int contarOcorrencias( const char *str, char c );

int main (){

    char str[41];
    char c;

    printf ("Caractere: ");
    scanf (" %c", &c);
    getchar();

    do{
        printf("Frase: ");
        gets(str);

        if (strcmp (str, "fim")==0){
            break;
        }

        if(contarOcorrencias(str, c)==0){
            printf("\"%s\" nao possui nenhuma ocorrencia do caractere '%c'.\n", str, c);
        }else{
            printf("\"%s\" tem %d ocorrencia(s) do caractere '%c'.\n", str, contarOcorrencias(str, c), c);
        }

    }while(strcmp (str, "fim") != 0);

    return 0;
}

int contarOcorrencias( const char *str, char c ){

    int cont = 0;

    for (int i=0; i<strlen(str); i++){
        if(str[i]==c){
            cont++;
        }
    }

    return cont;
}
