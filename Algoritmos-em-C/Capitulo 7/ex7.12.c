#include <stdio.h>
#include <stdlib.h>

void classificaDupla(int n1, int n2);

int main(){
    int n1[3];
    int n2[3];
    int i;

    for(i=0; i<3; i++){
        printf("n1[%d]: ", i);
        scanf("%d", &n1[i]);

        printf("n2[%d]: ", i);
        scanf("%d", &n2[i]);
    }
    system("cls");

    for(i=0; i<3; i++){
        printf("%d e %d: ", n1[i], n2[i]);
        classificaDupla(n1[i], n2[i]);

    }

return 0;
}

void classificaDupla(int n1, int n2){
    int Ma;
    int Me;

    if(n1 >= n2){
        Ma = n1;
        Me = n2;
    }else{
        Ma = n2;
        Me = n1;
    }
    printf("%d <= %d\n", Me, Ma);

}
