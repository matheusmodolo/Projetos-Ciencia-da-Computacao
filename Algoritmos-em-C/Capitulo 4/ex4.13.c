#include <stdio.h>
#include <stdlib.h>

int main(){

    int array[10];
    int remv[9];
    int i;
    int n;

    for (i = 0; i < 10; i++){
        printf("array[%d]: ", i);
        scanf("%d", &array[i]);
    }

    printf("Posicao a ser removida (0 a 9): ");
    scanf("%d", &n);

    while (n < 0 || n > 9){
        printf("Posicao invalida, forneca novamente!\n");
        printf("Posicao a ser removida (0 a 9):");
        scanf("%d", &n);
    }

    for(i=0; i<9; i++){
            if(i >= n){
                remv[i] = array[i+1];
                printf("array[%d] = %d\n", i, remv[i]);
            }else{
                printf("array[%d] = %d\n", i, array[i]);
            }
    }

return 0;
}
