#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

void removerLetra( char *str, char c );

int main(){

    char str[41];
    char c;

    printf("Frase: ");
    gets(str);

    printf("Caractere: ");
    scanf(" %c", &c);

    removerLetra (str, c);

    printf("%s", str);

    return 0;
}

void removerLetra( char *str, char c ){

        char str2[41];
        int i;

        for (i=0; i<strlen(str); i++){
            if (str[i]==tolower(c) || str[i]==toupper(c)){
                for (int j=i; j<strlen(str); j++){
                    str[j]=str[j+1];
                }
            }
        }
}
