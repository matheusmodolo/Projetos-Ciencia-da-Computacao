#include <stdio.h>
#include <stdlib.h>

int main(){

    int array[3][2];
    int i;
    int j;

    for (i=0; i<3; i++){
        for(j=0; j<2; j++){
            printf("array[%d][%d]: ", i, j);
            scanf("%d", &array[i][j]);
        }
    }

    printf("\n");

    for (i=0; i<3; i++){
        for(j=0; j<2; j++){
                if (j == 1){
                    printf("%03d", array[i][j]);
                }else{
                    printf("%03d ", array[i][j]);
                }

            }
                    printf("\n");
        }

return 0;
}
