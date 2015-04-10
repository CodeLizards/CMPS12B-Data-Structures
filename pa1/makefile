# A simple makefile for pa1
# elbharri
# cmps012b
Extrema: Extrema.class
	echo Main-class: Extrema > Manifest
	jar cvfm Extrema Manifest Extrema.class
	rm Manifest
	chmod +x Extrema
Extrema.class: Extrema.java
	 javac -Xlint Extrema.java
clean:
	rm -f Extrema.class Extrema
submit: README makefile Extrema.java 
	 submit cmps012b-pt.u14 pa1 README makefile Extrema.java
