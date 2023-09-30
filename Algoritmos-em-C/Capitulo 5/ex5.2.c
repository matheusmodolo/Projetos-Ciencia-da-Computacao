#include <stdio.h>
#include <stdlib.h>

int main() {

    int array1 [3][3];
    int array2 [3][3];
    int arraySoma [3][3];
    int i;
    int j;
    int k;

    for(i = 0; i < 3; i++){
        for( j = 0; j < 3; j++){
            printf("array[%d][%d]: ", i, j);
            scanf("%d", &array1[i][j]);
        }
    }

    for(i = 0; i < 3; i++){
        for( j = 0; j < 3; j++){
            printf("array[%d][%d]: ", i, j);
            scanf("%d", &array2[i][j]);
        }
    }

    for(i = 0; i < 3; i++){
        for( j = 0; j < 3; j++){
            arraySoma[i][j] = array1[i][j] + array2[i][j];
        }
    }

    printf("array1:       array2:       arraySoma:\n");

     for(i = 0; i < 3; i++){
        for( j = 0; j < 3; j++){
            printf("%.3d ", array1[i][j]);
        }

        if (i == 1){
            printf("+ ");
        } else {
            printf("  ");
        }

        for(j = 0; j < 3; j++){
            printf("%.3d ", array2[i][j]);
        }

        if (i == 1){
            printf("= ");
        } else {
            printf("  ");
        }


        for(j = 0; j < 3; j++){
                if(j == 2){
                        printf(" %.3d", arraySoma[i][j]);

                }else{
                        printf(" %.3d", arraySoma[i][j]);

                }
        }
        printf("\n");
     }


      return 0;
    }







