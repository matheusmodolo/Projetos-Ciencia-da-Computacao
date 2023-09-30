#include <stdio.h>
#include <stdlib.h>

int main(){

    printf("Forneca um numero: ");
    int n;
    scanf("%d", &n);

    int f = 1;

    for(int i = 1; i<=n; i++){
        f*=i;
    }

    printf("%d! = %d", n, f);

	return 0;
}
