all:
	javac -d build -sourcepath src src/Main.java
run:
	java -classpath build Main