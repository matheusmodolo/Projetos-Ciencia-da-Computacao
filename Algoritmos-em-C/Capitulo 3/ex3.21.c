#include <stdio.h>
#include <stdlib.h>

int main() {

    int n;
    int i;
    int j;

    printf("Altura: ");
    scanf("%d", &n);

    if(n > 0){
        for(i = 1; i <= n; i++){
            for(j = n; j >= 1; j--){
                if(i < j){
                    printf(" ");
                }else{
                    printf("*");
                }
            }

            for(j = n; j >= 1; j--){
                if(i > j){
                    printf("*");
                }else{
                    printf("");
                }
            }

            printf("\n");
        }

    }else if (n < 0) {
        n = n*(-1);
        for(i = 1; i <= n; i++){
            for( j = 1; j <= n; j++){
                if(i > j){
                    printf(" ");
                }else{
                    printf("*");
                }
            }

            for(j = 1; j <= n; j++){
                if(i < j){
                    printf("*");
                }else{
                    printf("");
                }
            }

            printf("\n");
        }

    }


    return 0;
}
