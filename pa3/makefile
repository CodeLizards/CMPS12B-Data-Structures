#makefile for CMPS12B pa3

JAVAC      = javac 
MAINCLASS  = DictionaryClient
JAVASRC    = $(wildcard *.java)
SOURCES    = $(JAVASRC) makefile README
CLASSES    = $(patsubst %.java, %.class, $(JAVASRC))
JARCLASSES = $(patsubst %.class, %*.class, $(CLASSES))
JARFILE    = $(MAINCLASS) 


all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(JARCLASSES)
	chmod +x $(JARFILE)
	rm Manifest

%.class: %.java
	$(JAVAC) $<

clean:
	rm -f *.class $(JARFILE)

submit: README makefile Dictionary.java DictionaryClient.java KeyCollisionException.java KeyNotFoundException.java DictionaryInterface.java DictionaryTest.java 
	submit cmps012b-pt.u14 pa3 README makefile Dictionary.java DictionaryClient.java KeyCollisionException.java KeyNotFoundException.java DictionaryInterface.java DictionaryTest.java
