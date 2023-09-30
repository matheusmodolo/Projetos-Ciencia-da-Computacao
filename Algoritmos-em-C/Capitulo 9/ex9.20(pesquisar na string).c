#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <stdbool.h>

bool contem( const char *fonte, const char *aPesquisar );

int main(){

    char fonte[41];
    char pesquisar[41];
    bool estaContida;
    int teste;

    printf("String fonte: ");
    gets(fonte);
    printf("String a pesquisar: ");
    gets(pesquisar);

    estaContida = contem(fonte, pesquisar);

    if(estaContida == true){
        printf("\"%s\" esta contida em \"%s\"", pesquisar, fonte);
    }else{
        printf("\"%s\" nao esta contida em \"%s\"", pesquisar, fonte);
    }

    return 0;
}

bool contem( const char *fonte, const char *pesquisar ){
    int i;
    int j;
    int c = 0;
    int b = 0;

    for(i=0; i<strlen(fonte); i++){
        if (fonte[i]==pesquisar[0] && c!= strlen(pesquisar)){
            for (j=i; j<strlen(fonte); j++){
                if (fonte[j]==pesquisar[b]){
                    c++;
                    b++;
                }
            }
        }
    }

    if(c==strlen(pesquisar)){
        return true;
    }else{
        return false;
    }
}
