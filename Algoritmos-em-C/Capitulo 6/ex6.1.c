#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(){

    float a, b, c;
    float delta;
    float x1, x2;

    printf("a: ");
    scanf("%f", &a);

    printf("b: ");
    scanf("%f", &b);

    printf("c: ");
    scanf("%f", &c);


    delta = pow(b, 2) - 4*a*c;

    x1 = (-b + sqrt(delta) )/2*a;

    x2 = (-b - sqrt(delta) )/2*a;

    if(a == 0){
        printf("Nao existe equacao do segundo grau!");
    }else{


        printf("Delta: %.2f\n", delta);


        if(delta == 0){
            printf("S = {%.2f}", x1);
        }else if(delta < 0){
            printf("S = {}");
        }else{
            if(x1>=x2){
                printf("S = {%.2f, %.2f}", x2, x1);
            }else{
                printf("S = {%.2f, %.2f}", x1, x2);
            }
        }
    }


return 0;
}
