#makefile

FLAGS = -std=c99 -Wall FileReverse.c
SOURCES = FileReverse.c
OBJECTS = FileReverse.o
EXEBIN = FileReverse

all: $(EXEBIN)

$(EXEBIN) : $(OBJECTS)
	gcc -o $(EXEBIN) $(OBJECTS)

$(OBJECTS) : $(SOURCES)
	gcc -c $(FLAGS) $(SOURCES)

clean : 
	rm -f $(EXEBIN) $(OBJECTS)

submit : README makefile FileReverse.c
	submit cmps012b-pt.u14 lab3 README makefile FileReverse.c 
	
