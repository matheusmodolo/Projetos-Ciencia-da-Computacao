#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

void imprimirCaixa( const char *str );

int main(){

    char str[41];

    printf("String: ");
    gets(str);

    imprimirCaixa(str);
    printf("|| %s ||\n", str);
    imprimirCaixa(str);

    return 0;
}

void imprimirCaixa( const char *str ){
    int igual;

    igual = strlen(str) + 2;

    printf("++");
    for (int i = 0; i<igual; i++){
        printf("=");
    }
    printf("++\n");

}
