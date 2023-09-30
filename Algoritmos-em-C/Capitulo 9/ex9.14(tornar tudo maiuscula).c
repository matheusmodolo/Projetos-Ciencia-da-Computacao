#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

void tornarMaiuscula( char *str );

int main(){

    char str[41];

    printf("Frase: ");
    gets(str);

    tornarMaiuscula(str);

    printf("%s", str);

    return 0;
}
void tornarMaiuscula( char *str ){

    int i;

    for (i=0; i<strlen(str); i++){
        str[i] = toupper(str[i]);
    }

}
