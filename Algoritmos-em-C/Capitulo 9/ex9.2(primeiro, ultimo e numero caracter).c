#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){

    char string[41];
    int i = 0;

    printf("Sentenca: ");
    gets(string);

    printf("Primeiro caractere: %c", string[0]);

    char ult;

    for (i=0; i<41; i++){
        if (string[i] == '\0'){
            ult = string[i] - 2;
        }
        break;
    }

    printf("\nUltimo caractere: %c", string[strlen(string) - 1]);
    printf("\nNumero de caracteres: %d", strlen(string));

    return 0;
}
