#include <stdio.h>
#include <stdlib.h>

int main(){
    int array[2][3];
    int i;
    int j;

    for (i=0; i<2; i++){
        for (j=0; j<3; j++){
            printf("array[%d][%d]: ", i, j);
            scanf("%d", &array[i][j]);
        }
    }
    printf("M:\n");

    for(i=0; i<2; i++){
        for (j=0; j<3; j++){
                if(j == 2){
                    printf("%.3d", array[i][j]);
                }else{
                    printf("%.3d ", array[i][j]);
                }
        }
        printf("\n");
    }
    printf("\nMt:\n");

    for (i=0; i<3; i++){
        for (j=0; j<2; j++){
                if(j == 1){
                    printf("%.3d", array[j][i]);
                }else{
                    printf("%.3d ", array[j][i]);
                }

        }
        printf("\n");
    }

return 0;
}
