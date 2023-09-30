#include <stdio.h>
#include <stdlib.h>

void somatorioMedia( float a[], int n, float *somatorio, float *media );

int main(){

    float a[10];
    int i;

    float ssomatorio = 0;
    float mmedia;
    float *somatorio = &ssomatorio;
    float *media = &mmedia;


    for (i=0; i<10; i++){
        printf("n[%d]: ", i);
        scanf("%f", &a[i]);
    }

    somatorioMedia(a, 10, somatorio, media);

    printf("Somatorio: %.2f\n", ssomatorio);
    printf("Media: %.2f", mmedia);


return 0;
}

void somatorioMedia( float a[], int n, float *somatorio, float *media ){

    for (int i = 0; i<n; i++){
        *somatorio += a[i];
    }

    *media = *somatorio/n;

}
