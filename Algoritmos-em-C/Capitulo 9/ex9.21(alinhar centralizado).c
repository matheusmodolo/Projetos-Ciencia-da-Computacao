#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

void imprimirCentralizado( const char *str );

int main (){

    char str[41];

    printf("String: ");
    gets(str);

    imprimirCentralizado(str);
    printf("%s", str);

    return 0;
}

void imprimirCentralizado( const char *str ){

    int espaco;

    espaco = 40 - strlen(str);

    for (int i = 0; i<espaco; i++){
        printf(" ");
    }

}
