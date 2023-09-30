#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){

    char string [41];
    char string2 [41];
    char string3 [41];
    int comp12;
    int comp23;
    int comp13;


    printf("String 1: ");
    gets(string);

    printf("String 2: ");
    gets(string2);

    printf("String 3: ");
    gets(string3);

    system("cls");

    comp12 = strcmp(string, string2);
    comp23 = strcmp(string2, string3);
    comp13 = strcmp(string, string3);

    if (comp12 < 0 && comp23 < 0){
        printf("%s, %s e %s", string, string2, string3);
    }else if(comp12 < 0 && comp23 > 0 && comp13 < 0){
        printf("%s, %s e %s", string, string3, string2);
    }else if(comp12 > 0 && comp23 < 0 && comp13 < 0){
        printf("%s, %s e %s", string2, string, string3);
    }else if(comp12 > 0 && comp23 < 0 && comp13 > 0){
        printf("%s, %s e %s", string2, string3, string);
    }else if(comp12 < 0 && comp23 > 0 && comp13 > 0){
        printf("%s, %s e %s", string3, string, string2);
    }else{
        printf("%s, %s e %s", string3, string2, string);

    }




    return 0;
}
