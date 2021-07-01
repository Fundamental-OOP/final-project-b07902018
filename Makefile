all:
	javac -d build -sourcepath src src/Main.java
	jar cfe game.jar Main  -C build/ .
	rm -rf build