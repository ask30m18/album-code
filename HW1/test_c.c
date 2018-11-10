#include <stdio.h>
#include <stdlib.h>
int main() {
    
    int b = fork();
    
    if(b==0) {
        int x = fork();
        if(x==0) {
            printf("x\n");
        } else {
            int y = fork();
            if(y==0) {
                printf("y\n");
            } else {
                printf("b\n");
                int status1;
                int status2;
                waitpid(x, &status1, 0);
                waitpid(y, &status2, 0);
                if (status1 == 0 && status2 == 0)
                {
                    printf("Çocuklar bittikten sonra bittim\n");    
                }
            }
        }
    } else {
        printf("a\n");
    }
    
    return 0;
}