#include <stdio.h>
#include <stdlib.h>

int mdc( int a, int b );

int main(){

    int a;
    int b;

    printf("Entre com o valor de a: ");
    scanf("%d", &a);
    printf("Entre com o valor de b: ");
    scanf("%d", &b);

    printf("mdc( %d, %d ) = %d", a, b, mdc(a,b));

    return 0;
}

int mdc( int a, int b ){

    if(b == 0){
        return a;
    }else if(a>=b && b>0){
        return mdc(b, a%b);
    }

}
