#makefile for pa2

Search: Search.class
	echo Main-class: Search > Manifest
	jar cvfm Search Manifest Search.class
	rm Manifest
	chmod +x Search

Search.class: Search.java
	javac -Xlint Search.java

clean: 
	rm -f Search.class Search

submit: README makefile Search.java
	submit cmps012b-pt.u14 pa2 README makefile Search.java
