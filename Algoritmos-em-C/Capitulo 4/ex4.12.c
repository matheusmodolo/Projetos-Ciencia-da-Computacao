#include <stdio.h>
#include <stdlib.h>

int main(){

    int array[5];
    int copia[4];
    int i;
    int n;

    for(i=0; i<5; i++){
        printf("array[%d]: ", i);
        scanf("%d", &array[i]);
    }
    for(i=0; i<5; i++){
        copia[i] = array[i+1];
    }
    for(i=0; i<4; i++){
        printf("array[%d] = %d\n", i, copia[i]);
    }


return 0;
}
