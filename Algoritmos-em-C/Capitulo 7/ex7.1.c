#include <stdio.h>
#include <stdlib.h>

int absoluto (int n);

int absoluto (int n){
    if (n<0){
        return -n;
    }else{
        return n;
    }
}

int main(){
    int i;
    int n[5];

    for (i=0; i<5; i++){
        printf("n%d: ", i);
        scanf("%d", &n[i]);
    }
    for(i=0; i<5; i++){
        printf("absoluto(%d) = %d\n", n[i], absoluto(n[i]));
    }

return 0;
}
