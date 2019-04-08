#include <stdio.h>
#include <string.h>
void printName(const char* input)
{
    char name[255]; //buffer overflow this.
    strcpy(name, input);
    printf("Your name is %s\n", name);
}
int main(int argc, char* argv[])
{ 
    if (argc != 2) 
    {
        printf("Please supply your name as an argument!\n");
        return -1;
    } 
    
    printName(argv[1]);
    return 0;
}

