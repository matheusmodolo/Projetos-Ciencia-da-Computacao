#include <stdio.h>
#include <stdlib.h>

int main(){

    int i;
    int n;
    int array1[5];
    int array2[5];
    int arraySoma[5];
    int contador = 0;

    printf("Forneca os valores do primeiro arraay: \n");
    for(i=0; i<5; i++){
        printf("array1[%d]: ", i);
        scanf("%d", &array1[i]);
    }
    printf("Forneca os valores do segundo array: \n");
    for(i=0; i<5; i++){
        printf("array2[%d]", i);
        scanf("%d", &array2[i]);
    }
    printf("\n");
    for (i=0; i< 5; i++){
        arraySoma[i] = array1[i] +array2[i];
        printf("arraySoma[%d] = %d\n", i, arraySoma[i]);

    }



return 0;
}
