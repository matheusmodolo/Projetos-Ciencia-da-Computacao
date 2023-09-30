#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

void tornarMinuscula( char *str );

int main(){

    char str[41];

    printf("Frase: ");
    gets(str);

    tornarMinuscula(str);

    printf("%s", str);

    return 0;
}
void tornarMinuscula( char *str ){

    int i;

    for (i=0; i<strlen(str); i++){
        str[i] = tolower(str[i]);
    }

}
