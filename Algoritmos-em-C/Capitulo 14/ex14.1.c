#include <stdio.h>
#include <stdlib.h>

int ackermann( int m, int n );

int main(){

    int m;
    int n;

    printf("Entre com o valor de m: ");
    scanf("%d", &m);
    printf("Entre com o valor de n: ");
    scanf("%d", &n);

    printf("ackermann( %d, %d ) = %d", m, n, ackermann(m,n));


    return 0;
}

int ackermann( int m, int n ){

    if(m==0){
        return n+1;
    }else if(m>0 && n == 0){
        return ackermann (m-1,1);
    }else if(m>0 && n>0){
        return ackermann (m - 1, ackermann(m, n-1));
    }
}
