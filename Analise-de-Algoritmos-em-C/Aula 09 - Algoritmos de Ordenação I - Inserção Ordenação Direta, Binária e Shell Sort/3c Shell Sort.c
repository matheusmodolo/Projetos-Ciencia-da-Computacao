#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int imprimir(int *a, int t);
int shellSort(int *a,int t, int in, int SegCorrente);

int main(){
    srand(time(NULL));

    int t;

    printf("Shell Sort\n\n");
    printf("Tamanho do Array: ");
    scanf("%d",&t);

    int a[t];

    printf("\nArray gerado aleatoriamente:\n");

    for(int i = 0; i < t; i++){
        a[i] = rand () % 100;
        printf("a[%d]: %d\n", i, a[i]);
    }

    imprimir(a,t);
    int np = 2;
    int in;
    int SegCorrente;

    for(int i = np; i >= 0;i--){
        in = (int)pow(2,i);

        for(SegCorrente = 0; SegCorrente < in; SegCorrente++){
            shellSort(a,t,in,SegCorrente);
        }

    }

    printf("\nArray Ordenado    [] = ");
    for(int i=0; i < t; i++){
        printf("%d ",a[i]);
    }
    pritnf("\n");

return 0;
}

int imprimir(int *a, int t){

    printf("\nArray Desordenado [] = ");
    for(int i=0; i < t; i++){
        printf("%d ",a[i]);
    }

}

int shellSort(int *a, int t, int in, int SegCorrente){

    int i, j, x, k;

    for(i=(SegCorrente+in); i<t; i+=in){

        k = SegCorrente;
        j = i-in;
        x = a[i];

        while((j>=SegCorrente)&&(k==SegCorrente)){
            if(x < a[j]){
                a[j+in] = a[j];
                j = j-in;

            }else{
                k = j+in;
            }
        }
        imprimir(a,t);
        a[k] = x;
    }
}
