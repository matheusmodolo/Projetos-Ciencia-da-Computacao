#include<stdio.h>  //4.2//
#include<stdlib.h>

int main(){

    int i;
    int array[5];
    int arrayCubo[5];

    for (i=0; i<5; i++){
        printf("array[%d]: ", i);
        scanf("%d", &array[i]);
    }
    for (i=0; i<5; i++){
        arrayCubo[i] = array[i]*array[i]*array[i];
    }
    for (i=0; i<5; i++){
        printf("arrayCubo[%d] = %d\n", i, arrayCubo[i]);
    }

return 0;
}
