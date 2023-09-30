#include <stdio.h>
#include <stdlib.h>

int main(){

    float array[5];
    float n;
    float somatorio=0;
    float multi=1;
    int i;

    for(i=0; i<5; i++){
        printf("array[%d]: ", i);
        scanf("%f", &array[i]);
    }
    for(i=0; i<5; i++){
        somatorio = somatorio + array[i]; //somatorio+=array[i];
    }
    for(i=0; i<5; i++){
        multi = multi * array[i];
    }
    printf("Somatorio: %.2f", somatorio);
    printf("\nProdutorio: %.2f", multi);



return 0;
}
