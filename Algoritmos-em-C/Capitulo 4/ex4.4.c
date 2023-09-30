#include <stdio.h>
#include <stdlib.h>

int main (){

    int n;
    int i;
    int array[5];

    for (i=0; i<5; i++){
        printf("array[%d]: ", i);
        scanf("%d", &array[i]);
    }
    printf("Buscar por: ");
    scanf("%d", &n);

    for (i=0; i<5; i++){
        printf("Indice %d: ", i);
        if(array[i] == n){
            printf("ACHEI\n");
        }else{
            printf("NAO ACHEI\n");
        }
    }

return 0;
}
