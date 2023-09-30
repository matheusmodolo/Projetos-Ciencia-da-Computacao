#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

int contarPalavras( const char *str );

int main(){

    char str[41];

    printf("Frase: ");
    gets(str);

    printf("Quantidade de palavras: %d", contarPalavras (str));

    return 0;
}
int contarPalavras( const char *str ){

    int cont = 0;
    int i;

    for(i =0; i<strlen(str);i++){
        if(str[i]==' '){
            cont++;
        }
    }
    if(cont>0){
        cont++;
    }

    return cont;
}
