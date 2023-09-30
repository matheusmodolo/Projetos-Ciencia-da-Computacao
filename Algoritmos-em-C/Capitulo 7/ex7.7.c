#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int ehPrimo(int n);

int main (){
    int i;
    bool primo;

    for (i=1; i<=20; i++){

            primo = ehPrimo(i);

            printf("%d: ", i);
            if(primo){
                printf("eh primo");
            }else{
                printf("nao eh primo");
            }
            printf("\n");
    }

return 0;
}

int ehPrimo (int n){

    int c=0;

    for(int i = 1; i <= n; i++){
        if (n%i==0){
            c++;
        }
    }
    if(c==2){
        return true;
    }else{
        return false;
    }
}
