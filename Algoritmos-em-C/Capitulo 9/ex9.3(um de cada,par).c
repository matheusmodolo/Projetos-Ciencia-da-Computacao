#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){

    char string[41];;

    printf("Sentenca: ");
    gets (string);



    for (int i=0; i<strlen(string); i++){

        if (i%2==0){
            if (i==0) {
                    if (string[i] == ' ') {
                        printf("' '");
                    } else {
                        printf("%c", string[i]);
                    }
            } else {
                if (string[i] == ' ') {
                        printf(", ' '");
                    } else {
                        printf(", %c", string[i]);
                    }
            }
        }
    }
return 0;
}
