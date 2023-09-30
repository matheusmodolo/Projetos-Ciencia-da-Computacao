#include <stdio.h>
#include <stdlib.h>

void decompoeTempo( int totalSegundos, int *horas, int *minutos, int *segundos );

int main(){

    int hhoras;
    int mminutos;
    int ssegundos;
    int *horas = &hhoras;
    int *minutos = &mminutos;
    int *segundos = &ssegundos;

    int totalSegundos;

    printf("Total de segundos: ");
    scanf("%d", &totalSegundos);

    system("cls");

    decompoeTempo(totalSegundos, horas, minutos, segundos );

    printf("%d segundo(s) corresponde(m) a:\n", totalSegundos);
    printf("    %d hora(s)\n    %d minuto(s)\n    %d segundo(s)", *horas, *minutos, *segundos);


return 0;
}
void decompoeTempo( int totalSegundos, int *horas, int *minutos, int *segundos ){

    int resto;

    *horas = totalSegundos/3600;
    resto = totalSegundos%3600;
    *minutos = resto/60;
    *segundos = resto%60;



}
