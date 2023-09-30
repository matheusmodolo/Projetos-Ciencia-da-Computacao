#include <stdio.h>
#include <stdlib.h>

int main (){

    int i;
    int n;


    printf("Tabuada do numero: ");
    scanf("%d", &n);

    for(i=0; i<=10; i++){
        printf("%d x %d = %d\n", n, i, n * i);
    }


return 0;
}
