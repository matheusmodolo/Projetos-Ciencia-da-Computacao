#include <stdio.h>
#include <stdlib.h>

int main(){

    char string[41];

    printf("String: ");
    gets (string);

    printf("%s", string);

    for (int i = 0; i<4; i++){
        if(i<3){
            printf("%c, ", string[i]);
        }else{
            printf("%c.", string[i]);
        }
    }

return 0;
}
