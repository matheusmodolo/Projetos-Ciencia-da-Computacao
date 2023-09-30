#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

void imprimirDireita( const char *str );

int main (){

    char str[41];

    printf("String: ");
    gets(str);

    imprimirDireita(str);
    printf("%s", str);

    return 0;
}

void imprimirDireita( const char *str ){

    int espaco;

    espaco = 80 - strlen(str);

    for (int i = 0; i<espaco; i++){
        printf(" ");
    }

}
