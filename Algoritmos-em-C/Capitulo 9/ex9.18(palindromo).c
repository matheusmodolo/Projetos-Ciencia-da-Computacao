/*   TA ERRADO :(   */
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <ctype.h>

bool ehPalindromo( const char *str );

int main(){

    char str[41];
    int cont = 0;

    printf("String: ");
    gets(str);

    if (ehPalindromo(str)){
        printf("\"%s\" e' um palindromo!", str);
    }else{
        printf("\"%s\" nao e' um palindromo!", str);
    }

    return 0;
}
bool ehPalindromo( const char *str ){

    char inv[41];
    int i;
    int c = 0;

    for (i=strlen(str)-1; i>=0; i--){
            inv[c] = str[i];
            c++;
    }

    inv[c] = '\0';

    for (i=0; i< strlen(str); i++){
        if (inv[i]!=str[i]){
            return false;
        }else{
            return true;
        }
    }
}
