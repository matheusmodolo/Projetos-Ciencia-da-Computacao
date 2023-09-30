#include <stdio.h>
#include <stdlib.h>

int main(){

    int array[10];
    int array2[10];
    int i;

    for (i = 0; i < 10; i++){
        printf("array[%d]: ", i);
        scanf("%d", &array[i]);
    }

    int j = -1;

    for(i=0; i<10; i++){
            if(array[i]%2==1){
                j++;
                printf("array[%d] = %d\n", j, array[i]);
            }
    }

return 0;
}
