#include <stdio.h>
#include <stdlib.h>

int main(){

    float a[3][3];
    float Det;
    float Det1;
    float Det2;
    int i;
    int j;

    for (i=0; i<3; i++){
        for (j=0; j<3; j++){
            printf("array[%d][%d]: ", i, j);
            scanf("%f", &a[i][j]);
        }
    }

    Det1 = (a[0][0]*a[1][1]*a[2][2]) + (a[0][1]*a[1][2]*a[2][0]) + (a[0][2]*a[1][0]*a[2][1]);
    Det2 = (a[0][2]*a[1][1]*a[2][0]) + (a[0][0]*a[1][2]*a[2][1]) + (a[0][1]*a[1][0]*a[2][2]);
    Det = Det1 - Det2;

    printf("Determinante: %f", Det);

return 0;
}
