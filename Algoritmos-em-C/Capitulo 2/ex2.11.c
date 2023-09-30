#include <stdio.h>
#include <stdlib.h>

int main(){

float a;
float b;
float g;

printf("alfa: ");
scanf("%f", &a);

printf("beta: ");
scanf("%f", &b);

printf("gama: ");
scanf("%f", &g);


    if (a + b + g != 180){
        printf("As medidas fornecidas dos angulos nao representam um triangulo valido!");

    }else if (a == 90 || b == 90 || g == 90){
        printf("Triangulo RETANGULO");

    }else if(a>90 || b > 90 || g > 90){
        printf("Triangulo OBTUSANGULO");

    }else if(a < 90 && b < 90 && g < 90){
        printf("Triangulo ACUTANGULO");

    }


return 0;
}
