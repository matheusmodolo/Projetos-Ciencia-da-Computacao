#include <stdio.h>
#include <stdlib.h>

int main(){

    int i;
    int n;

    printf("Quantidade de elementos (1 a 9): ");
    scanf("%d", &n);

    while ( n <1 || n >9){
        printf("Quantidade incorreta! forneca novamente!\n");
        printf("Quantidade de elementos (1 a 9): ");
        scanf("%d", &n);
    }

    int array[n];

    for(i=0; i<n; i++){
        printf("array[%d]: ", i);
        scanf("%d", &array[i]);
    }

    int v;

    printf("Valor que sera inserido: ");
    scanf("%d", &v);

    printf("array[0] = %d\n", v);


    for (i=0; i<n; i++){
        array[i] = array[i];
        printf("array[%d] = %d\n", i+1, array[i]);
    }

return 0;
}
