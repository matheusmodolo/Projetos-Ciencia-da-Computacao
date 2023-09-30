#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void inverter (char *inv, const char *string);

int main(){

    char string[41];
    char inv[41];

    printf("String: ");
    gets(string);

    inverter (inv, string);

    printf("Invertida: %s", inv);

    return 0;
}

void inverter (char *inv, const char *string){

    int i;
    int c = 0;

    for (i=strlen(string)-1; i>=0; i--){
        inv[c] = string[i];
        c++;
    }
    inv[c] = '\0';

}
