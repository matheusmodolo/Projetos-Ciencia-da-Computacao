#include <stdio.h>
#include <stdlib.h>

int tamanho( const char *str );

int main(){

    char str [41];

    printf("Frase: ");
    gets(str);

    printf("%d caractere(s)!", tamanho(str));

    return 0;
}

int tamanho( const char *str ){

    int c = 0;

    while ( str[c] != '\0'){
        c++;
    }
return c;
}
