#include <stdio.h>
#include <stdlib.h>

int main (){

    int i;
    int j;
    int a;

    printf("Altura: ");
    scanf("%d", &a);

    for (i = 1; i <= a; i++){
        for(j = 1; j <= i; j++){
            printf("*");
        }
        printf("\n");
    }

return 0;
}
