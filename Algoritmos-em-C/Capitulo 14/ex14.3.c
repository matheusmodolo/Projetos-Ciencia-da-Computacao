//não consegui fazer por recursividade :C
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void inverter( char *destino, const char *base, int tamanho );

int main(){

    char base[41];
    char destino[41];
    int t;

    printf("String: ");
    gets(base);

    t = strlen(base) - 1;

    inverter(destino, base, t);

    printf("Invertida: %s", destino);

    return 0;
}

void inverter( char *destino, const char *base, int tamanho ){
    int i;
    int c = 0;

    for (i=tamanho; i>=0; i--){
        destino[c] = base[i];
        c++;
    }
    destino[c] = '\0';
}
