//lab4.c

#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
#include<assert.h>

#define MAX_STRING_LENGTH 100

// function prototype 
void extract_chars(char* s, char* a, char* d, char* p, char* w);

// function main which takes command line arguments 
int main(int argc, char* argv[]){
   FILE* in;        // handle for input file                  
   FILE* out;       // handle for output file                 
   char* line;      // string holding input line              
   char* chars; // string holding all alpha-numeric chars
   char* nums;
   char* punct;
   char* white; 

   // check command line for correct number of arguments 
   if( argc != 3 ){
      printf("Usage: %s input-file output-file\n", argv[0]);
      exit(EXIT_FAILURE);
   }

   // open input file for reading 
   if( (in=fopen(argv[1], "r"))==NULL ){
      printf("Unable to read from file %s\n", argv[1]);
      exit(EXIT_FAILURE);
   }

   // open output file for writing 
   if( (out=fopen(argv[2], "w"))==NULL ){
      printf("Unable to write to file %s\n", argv[2]);
      exit(EXIT_FAILURE);
   }

   // allocate strings line and chars on the heap 
   line = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   chars = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   nums = calloc(MAX_STRING_LENGth+1, sizeof(char);
   punct = calloc(MAX_STRING_LENGTH+1, sizeof(char);
   white = calloc(MAX_STRING_LENGTh+1, sizeof(char);
   assert( line!=NULL && chars!=NULL );
   assert( nums!=NULL && punct!=NULL);
   assert( white!=NUL);

   // read each line in input file, extract alpha-numeric characters 
   while( fgets(line, MAX_STRING_LENGTH, in) != NULL ){
      extract_chars(line, chars, nums, punct, white);
      fprintf(out, "line %d\n contains", line);
      fprintf(out, )
   }

   // free heap memory 
   free(line);
   free(chars);

   // close input and output files 
   fclose(in);
   fclose(out);

   return EXIT_SUCCESS;
}

// function definition 
void extract_chars(char* s, char* a, char* p, char* w){
   int i=0, j=0;
   while(s[i]!='\0' && i<MAX_STRING_LENGTH){
      if( ischar( (int)s[i]) ) a[j++] = s[i];
      i++;
   }
   a[j] = '\0';
}
