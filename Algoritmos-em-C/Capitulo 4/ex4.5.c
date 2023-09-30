#include <stdio.h>
#include <stdlib.h>

int main(){

    int i;
    int n;
    int c = 0;
    int array[5];

    for (i=0; i<5; i++){
        printf("array[%d]: ", i);
        scanf("%d", &array[i]);
    }
    printf("Buscar por: ");
    scanf("%d", &n);

    for(i=0; i<5; i++){
        if(array[i] == n){
            c++;
        }
    }

    if(c == 0){
        printf("O array nao contem o valor %d.", n);
    }else if(c>1){
        printf("O array contem %d ocorrencias do valor %d.", c, n);
    }else{
        printf("O array contem %d ocorrencia do valor %d.", c, n);
    }

return 0;
}
