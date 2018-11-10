#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <wait.h>

int main() {
   int b = fork();
   int x=0;
   if(b == 0) {
        x = fork();
        if (x == 0) {
            printf("x");
        } else {
            int y = fork();
            if (y == 0) {
                printf("y");
            } else {
                printf("b");
                printf ("Parentı öldürüyorum");
                kill (getppid(), 9);
            }
        }
    } else {
        printf("a\n");
        printf ("Öldürülmeyi bekliyorum\n");
        wait(0);
    }
    return 0;
}
  
