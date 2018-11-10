#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <wait.h>

int main() {
   int b = fork();
   int x=0;
   if(b == 0) {
        pid_t y;

        x = fork();

        if (x == 0) {
            printf("x");
        } else {
            y = fork();

            if (y == 0) {
                printf("y");
            } else {
                printf("b");
            }
        }
    } else {
        
        printf("a\n");
        kill(x, SIGKILL);
        kill(b, SIGKILL);
        
    }
    
    return 0;
}