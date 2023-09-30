#include <stdio.h>
#include <stdlib.h>

int main(){
    int array1[3][4];
    int n;
    int array2[3][4];
    int i;
    int j;

    for (i=0; i<3; i++){
        for (j=0; j<4; j++){
            printf("array[%d][%d]: ", i, j);
            scanf ("%d", &array1[i][j]);
        }
    }
    printf("Multiplicar por: ");
    scanf("%d", &n);

    printf("arrayMult:\n");

    for (i=0; i<3; i++){
        for (j=0; j<4; j++){
            array2[i][j] = array1[i][j] * n;
        }
    }



    for (i=0; i<3; i++){
        for (j=0; j<4; j++){
            if (j == 3){
                printf("%.3d", array2[i][j]);
            }else{
                printf("%.3d ", array2[i][j]);
            }
        }
        printf("\n");
    }



return 0;
}
