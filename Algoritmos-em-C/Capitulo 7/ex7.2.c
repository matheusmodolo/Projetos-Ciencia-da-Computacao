#include <stdio.h>
#include <stdlib.h>
#include <math.h>

float Area (float raio);
float Circunferecia (float raio);

int main(){

    float r;

    printf("Raio: ");
    scanf("%f", &r);

    printf("Area = %.2f\n", Area(r));
    printf("Circunferencia = %.2f", Circunferencia(r));
return 0;
}

float Area (float raio){
    float pi = acos (-1);
    float Area;
    Area = pi* pow(raio, 2);
    return Area;
}

float Circunferencia(float raio){
    float pi = acos (-1);
    float Circunferencia;
    Circunferencia = 2*pi*raio;
    return Circunferencia;
}
