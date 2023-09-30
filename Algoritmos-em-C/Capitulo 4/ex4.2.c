#include <stdio.h>
#include <stdlib.h>

int main (){

    int i;
    int array[5];
    int n;
    int arrayMult[5];

    for (i=0; i<5; i++){
        printf("array[%d]: ", i);
        scanf("%d", &array[i]);
    }
    printf("Multiplicar por: ");
    scanf("%d", &n);

    for (i=0; i<5; i++){
        arrayMult[i] = array[i]*n;
    }
    for (i=0; i<5; i++){
        printf("arrayMult[%d] = %d\n", i, arrayMult[i]);
    }

return 0;
}
