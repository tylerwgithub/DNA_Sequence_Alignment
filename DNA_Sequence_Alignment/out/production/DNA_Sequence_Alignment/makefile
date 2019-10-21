JC = javac
JFLAGS = -g
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	./src/fastahandler.java \
	./src/fileHandler.java \
	./src/generator.java \
	./src/main.java \
	./src/partitioning.java
	

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
	$(RM) *.txt
	
