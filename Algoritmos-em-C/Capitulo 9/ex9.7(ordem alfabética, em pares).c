#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){

    char string1[5][41];
    char string2[5][41];
    int i;

    for (i=0; i<5; i++){
        printf("Par %d, palavra 1: ", i+1);
        fgets(string1[i], 41, stdin);
        string1[i][strlen(string1[i])-1] = '\0';

        printf("Par %d, palavra 2: ", i+1);
        fgets(string2[i], 41, stdin);
        string2[i][strlen(string2[i])-1] = '\0';
    }

    printf("\n");

    int comp;

    for (i=0; i<5; i++){

        comp = strcmp(string1[i], string2[i]);

        if (comp<0){
            printf("%s - %s: ORDEM CRESCENTE\n", string1[i], string2[i]);
            //crescente
        }else if(comp > 0){
            printf("%s - %s: ORDEM DECRESCENTE\n", string1[i], string2[i]);
            //decrescente
        }else{
            printf("%s - %s: IGUAIS\n", string1[i], string2[i]);
            //iguais
        }
    }



    return 0;
}
