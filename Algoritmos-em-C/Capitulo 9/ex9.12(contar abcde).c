#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

int contarOcorrencias( const char *str, char c );

int main(){

    char str[41];
    char c;

    printf("Frase: ");
    gets(str);

    printf("A/a: %d\n", contarOcorrencias (str, 'A'));
    printf("B/b: %d\n", contarOcorrencias (str, 'B'));
    printf("C/c: %d\n", contarOcorrencias (str, 'C'));
    printf("D/d: %d\n", contarOcorrencias (str, 'D'));
    printf("E/e: %d", contarOcorrencias (str, 'E'));

    return 0;
}

int contarOcorrencias( const char *str, char c ){

    int cont = 0;

    for (int i=0; i<strlen(str); i++){
        if(str[i]==c || str[i] == tolower(c)){
            cont++;

        }
    }

    return cont;
}
