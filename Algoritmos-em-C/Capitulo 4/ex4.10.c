#include <stdio.h>
#include <stdlib.h>

int main() {

    int array[5];
    int i;
    int n;
    int j = -1;

    for (i=0; i<5; i++){
        printf("array[%d]: ", i);
        scanf("%d", &array[i]);
    }

    printf("Copiar maiores que: ");
    scanf("%d", &n);

    for(i=0; i<5; i++){
            if(array[i]>n){
                    j++;
                    printf("arrayCopia[%d] = %d\n", j, array[i]);
            }
    }

    if(j == -1){
        printf("Nao houve copia!");
    }


return 0;
}
