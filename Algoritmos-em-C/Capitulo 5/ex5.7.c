#include <stdio.h>
#include <stdlib.h>

int main(){
    int array1[3][2];
    int array2[2][3];
    int i;
    int j;

    for (i=0; i<3; i++){
        for (j=0; j<2; j++){
            printf("array1[%d][%d]: ", i, j);
            scanf("%d", &array1[i][j]);
        }
    }
    for (i=0; i<2; i++){
        for (j=0; j<3; j++){
            printf("array2[%d][%d]: ", i, j);
            scanf("%d", &array2[i][j]);
        }
    }

    int arrayM[3][3];

    for (i=0; i<3; i++){
        for (j=0; j<3; j++){
            arrayM[i][j] = ((array1[i][0]*array2[0][j])+(array1[i][1] *array2[1][j]));

        }
    }
    printf("\n");
    printf("A x B =\n");

    for (i=0; i<3; i++){
        for (j=0; j<3; j++){
                if(arrayM[i][j] < 0){
                        if(j == 2){
                            printf("%.2d", arrayM[i][j]);
                        }else{
                            printf("%.2d ", arrayM[i][j]);
                        }
                }else{
                    if (j == 2){
                        printf("%.3d", arrayM[i][j]);
                    }else{
                        printf("%.3d ", arrayM[i][j]);
                    }

                }
        }
        printf("\n");
    }

return 0;
}
