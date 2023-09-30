#include <stdio.h>
#include <stdlib.h>

int main(){

    int array[5];
    int arrayInv[5];
    int i;

    for (i=0; i<5; i++){
        printf("array[%d]: ", i);
        scanf("%d", &array[i]);
    }

    arrayInv[0]=array[4];
    arrayInv[1]=array[3];
    arrayInv[2]=array[2];
    arrayInv[3]=array[1];
    arrayInv[4]=array[0];

    for (i=0; i<5; i++){
        printf("arrayInv[%d] = %d\n", i, arrayInv[i]);
    }

return 0;
}
