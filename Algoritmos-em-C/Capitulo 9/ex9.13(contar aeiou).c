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
    printf("E/e: %d\n", contarOcorrencias (str, 'E'));
    printf("I/i: %d\n", contarOcorrencias (str, 'I'));
    printf("O/o: %d\n", contarOcorrencias (str, 'O'));
    printf("U/u: %d", contarOcorrencias (str, 'U'));

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
