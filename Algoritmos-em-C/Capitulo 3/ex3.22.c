#include <stdio.h>
#include <stdlib.h>

int main() {

    int i;
    int n1;
    int n2;
    int n3;
    int n4;
    int n5;
    int maior;
    int invalido = 0;

    printf("N1: ");
    scanf("%d", &n1);

    if (n1 <= 0) {
      invalido = 1;
    }else{
      maior = n1;
    }

    printf("N2: ");
    scanf("%d", &n2);

    if (n2 > 0) {
      if (n2 > maior) {
        maior = n2;
      }
    } else {
      invalido = 1;
    }

    printf("N3: ");
    scanf("%d", &n3);

    if (n3 > 0) {
      if (n3 > maior) {
        maior = n3;
      }
    }else{
      invalido = 1;
    }

    printf("N4: ");
    scanf("%d", &n4);

    if (n4 > 0) {
      if (n4 > maior) {
        maior = n4;
      }
    }else{
      invalido = 1;
    }

    printf("N5: ");
    scanf("%d", &n5);

    if (n5 > 0) {
      if (n5 > maior) {
        maior = n5;
      }
    } else {
      invalido = 1;
    }

    if (invalido == 1) {
      printf("Forneca apenas numeros positivos.");
    }else{
      for (i = maior; i >= 1; i--) {
        printf("%04d  ", i);
        if (n1 >= i) {
          printf("*");
        }else{
          printf(" ");
        }
        if (n2 >= i) {
          printf("*");
        } else {
          printf(" ");
        }
        if (n3 >= i) {
          printf("*");
        } else {
          printf(" ");
        }
        if (n4 >= i) {
          printf("*");
        } else {
          printf(" ");
        }
        if (n5 >= i) {
          printf("*");
        } else {
          printf(" ");
        }

        printf("\n");
      }
    }

    return 0;
}
