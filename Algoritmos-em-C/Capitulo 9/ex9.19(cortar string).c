#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

void substring(char *recorte, const char *origem, int inicio, int fim );

int main(){

    char str[41];
    char recorte[41];
    int i;
    int f;

    printf("String: ");
    gets(str);

    printf("Inicio: ");
    scanf("%d", &i);
    printf("Fim: ");
    scanf("%d", &f);

    substring(recorte, str, i, f);

    printf("Recorte: %s", recorte);

    return 0;
}
void substring(char *recorte, const char *origem, int inicio, int fim ){

    int i;
    int aux = 0;

    if (inicio>=fim || inicio > strlen(origem) || fim>strlen(origem)){
        for(i=0; i<strlen(origem); i++){
            recorte[i] = origem [i];
            aux++;
        }
        recorte[aux] = '\0';
    }else{
        for(i=inicio; i<fim; i++){
            recorte[aux] = origem [i];
            aux++;
        }
        recorte[aux] = '\0';
    }
}
