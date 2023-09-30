#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){

    int i;
    int j;
    char string [41];

    printf("Nome: ");
    gets(string);

    system("cls");

    for (j = 0; j<5; j++){
        for (i=0; i<strlen(string); i++){
            printf("%c", string[i]);
        }
        printf("\n");
    }

    return 0;
}
