#include <stdio.h>
#include <stdlib.h>

int comb (int n, int k);

int fatorial(int n);

int main(){

    printf("Entre com o valor de grupos distintos (k): ");
    int k;
    scanf("%d", &k);
    printf("Entre com o numero de pessoas: (n): ");
    int n;
    scanf("%d", &n);
    printf("A quantidade de combinacoes C(n, k) = C(%d, %d) = %d", n, k, comb(n, k));

	return 0;
}

int comb (int n, int k){

    return (fatorial(n))/(fatorial(k)*fatorial(n-k));
}
int fatorial(int n){
    if (n==0 || n==1){
        return 1;
    }
    return n*fatorial(n-1);
}
