#include <stdio.h>
#include <stdlib.h>

void classificaTrinca(int n1, int n2, int n3);

int main(){
    int n1[3];
    int n2[3];
    int n3[3];
    int i;

    for(i=0; i<3; i++){
        printf("n1[%d]: ", i);
        scanf("%d", &n1[i]);

        printf("n2[%d]: ", i);
        scanf("%d", &n2[i]);

        printf("n3[%d]: ", i);
        scanf("%d", &n3[i]);
    }

    for(i=0; i<3; i++){
        printf("%d, %d e %d: ", n1[i], n2[i], n3[i]);
        classificaTrinca(n1[i], n2[i], n3[i]);

    }

return 0;
}

void classificaTrinca(int n1, int n2, int n3){
    if (n1 <= n2 && n2 <= n3){
        printf("%d <= %d <= %d\n", n1, n2, n3);
    }else if(n1 <= n3 && n3 <= n2){
        printf("%d <= %d <= %d\n", n1, n3, n2);
    }else if(n2<=n1 && n1<= n3){
        printf("%d <= %d <= %d\n", n2, n1, n3);
    }else if(n2<=n3 && n3<=n1){
        printf("%d <= %d <= %d\n", n2, n3, n1);
    }else if(n3<=n2 && n2<=n1){
        printf("%d <= %d <= %d\n", n3, n2, n1);
    }else if(n3<=n1 && n1<=n2){
        printf("%d <= %d <= %d\n", n3, n1, n2);
    }
}
