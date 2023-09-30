#include <stdio.h>
#include <stdlib.h>

int main() {

    int i;
    int j;
    int k;
    int l;


    for( i = 1; i <= 5; i++){
        for(j = 1; j <= i; j++){
            printf("*");
        }
        printf("\n");
    }

    for( k = 1; k <= 4; k++){
        for(l = 4; l >= k; l--){
            printf("*");
        }
        printf("\n");
    }


    return 0;

}
