#include <stdio.h>
#include <stdlib.h>

int main() {

    int i, j;
    int k, l;
    int m, n;
    int o, p;


    for(i = 1; i <= 5; i++){
        for(j = 1; j <= i; j++){
            printf("*");
        }
        printf("\n");
    }

    printf("\n");

    for(k = 1; k <= 5; k++){
        for(l = 5; l >= k; l--){
            printf("*");
        }
        printf("\n");
    }

    printf("\n");

    for(m = 1; m <= 5; m++){
        for(n = 5; n >= 1; n--){
            if(m < n){
                printf(" ");
            }else{
                printf("*");
            }
        }
        printf("\n");
    }

    printf("\n");

    for( o = 1; o <= 5; o++){
        for(p = 1; p <= 5; p++){
            if(p < o){
                printf(" ");
            }else{
                printf("*");
            }
        }
        printf("\n");
    }

    return 0;

}
